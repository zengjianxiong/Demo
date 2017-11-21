package com.zeng.demo.di.module;

import com.zeng.demo.demo.mvp.DemoActivity;
import com.zeng.demo.demo.mvp.DemoContract;
import com.zeng.demo.demo.mvp.DemoModel;
import com.zeng.demo.demo.mvp.DemoPresenter;
import com.zeng.demo.di.scope.ActivityScope;
import com.zeng.demo.main.MainActivity;
import com.zeng.demo.network.TmdbWebService;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2017/11/20-15:20
 *
 * @author admin
 */

@Module
public  class DemoActivityModule {


    @Provides
    static String provideClazzName() {
        return DemoActivity.class.getName();
    }







}
