package com.zeng.demo;


import com.zeng.demo.di.component.AppComponent;
import com.zeng.demo.di.component.DaggerAppComponent;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;


/**
 * description:Data：2017/11/17-14:42
 *
 * @author admin
 */

public class DemoApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
        return appComponent;
    }
}
