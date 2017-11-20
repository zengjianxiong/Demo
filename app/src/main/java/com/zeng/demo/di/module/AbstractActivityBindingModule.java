package com.zeng.demo.di.module;

import com.zeng.demo.di.component.AppComponent;
import com.zeng.demo.di.scope.ActivityScope;
import com.zeng.demo.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * description:Data：2017/11/17-15:10
 * 所有的activity module 都在这地方绑定 ，再将这个管理module添加到{@link AppComponent}
 *
 * @author admin
 */

@Module
public abstract class AbstractActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivitytInjector();

}
