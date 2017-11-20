package com.zeng.demo.base;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.zeng.demo.mvp.IView;

import java.util.List;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;


/**
 * Activity基类
 *
 * @author gc
 * @since 1.0
 */
@SuppressLint("RestrictedApi")
public abstract class BaseActivity<P extends BasePresenter> extends DaggerAppCompatActivity implements IView {
    protected View view;
    protected P mPresenter;

    private Unbinder unbinder;
    protected BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        unbinder = ButterKnife.bind(this);
        mPresenter = loadPresenter();
        initCommonData();
        initView();

    }

    protected abstract int getLayoutId();

    protected abstract P loadPresenter();

    private void initCommonData() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract void initView();


    /**
     * @return 显示的内容
     */
    public View getView() {
        view = View.inflate(this, getLayoutId(), null);
        return view;
    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("ExitApp");
        this.registerReceiver(this.broadcastReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unbinder.unbind();
        this.unregisterReceiver(this.broadcastReceiver);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager fragmentManager = getSupportFragmentManager();
        for (int indext = 0; indext < fragmentManager.getFragments().size(); indext++) {
            //找到第一层Fragment
            Fragment fragment = fragmentManager.getFragments().get(indext);
            if (fragment == null) {
                Timber.w("Activity result no fragment exists for index: 0x" + Integer.toHexString(requestCode));
            } else {
                handleResult(fragment, requestCode, resultCode, data);
            }
        }
    }

    /**
     * 递归调用，对所有的子Fragment生效
     *
     * @param fragment
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment fragment, int requestCode, int resultCode, Intent data) {
        //调用每个Fragment的onActivityResult
        fragment.onActivityResult(requestCode, resultCode, data);
        Timber.e("MyBaseFragmentActivity");
        //找到第二层Fragment
        List<Fragment> childFragment = fragment.getChildFragmentManager().getFragments();
        if (childFragment != null) {
            for (Fragment f : childFragment) {
                if (f != null) {
                    handleResult(f, requestCode, resultCode, data);
                }
            }
        }

        if (childFragment == null) {
            Timber.e("MyBaseFragmentActivity1111");
        }
    }


}
