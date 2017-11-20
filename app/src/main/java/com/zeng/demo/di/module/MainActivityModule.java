package com.zeng.demo.di.module;

import com.zeng.demo.di.scope.ActivityScope;
import com.zeng.demo.main.MainActivity;
import com.zeng.demo.main.MainContract;
import com.zeng.demo.main.MainPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * description:Data：2017/11/20-15:20
 *
 * @author admin
 */

@Module
public abstract class MainActivityModule {


    @ActivityScope
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter presenter);


    @Provides
    static String provideClazzName() {
        return MainActivity.class.getName();
    }
}
