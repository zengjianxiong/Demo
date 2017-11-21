package com.zeng.demo.demo.mvp;

import com.zeng.demo.demo.BasePresenter;
import com.zeng.demo.demo.BaseView;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class DemoContract {
    interface IView extends BaseView<IPresenter> {
    }

    public interface IPresenter extends BasePresenter<IView> {

        void show();
    }

    public interface IModel {
        void show();
    }
}
