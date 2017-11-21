package com.zeng.demo.demo.mvp;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class DemoPresenter implements DemoContract.IPresenter {

    private DemoContract.IView iView;

    private DemoModel iModel;

    @Inject
    public DemoPresenter(DemoModel model) {
        this.iModel = model;
    }

    @Override
    public void takeView(DemoContract.IView view) {
        this.iView = view;
    }

    @Override
    public void dropView() {

    }

    @Override
    public void show() {
        iModel.show();
    }
}
