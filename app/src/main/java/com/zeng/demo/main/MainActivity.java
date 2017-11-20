package com.zeng.demo.main;


import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import com.zeng.demo.R;
import com.zeng.demo.base.BaseActivity;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {


    @Inject
    MainPresenter mainPresenter;

    @Inject
    String clazzName;

    @BindView(R.id.textView)
    TextView textView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter loadPresenter() {
        return mainPresenter;
    }

    @Override
    protected void initView() {
        mainPresenter.setTextView(clazzName);
    }

    @Override
    public void showTextView(String clazzName) {
        textView.setText(clazzName);
    }
}
