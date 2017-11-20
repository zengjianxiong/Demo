package com.zeng.demo.main;

import android.content.Context;

import com.zeng.demo.base.BasePresenter;

import javax.inject.Inject;

/**
 * description:Data：2017/11/20-14:45
 *
 * @author admin
 */

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {


    private MainModel model;

    @Inject
    public MainPresenter(MainModel model) {
        this.model = model;
    }

    @Override
    public void setTextView(String clazzName) {
        getIView().showTextView(model.addtext(clazzName));
    }
}
