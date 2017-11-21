package com.zeng.demo.demo.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zeng.demo.R;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class DemoActivity extends DaggerAppCompatActivity implements DemoContract.IView {

    @Inject
    DemoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mPresenter.takeView(this);


        mPresenter.show();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();

    }
}
