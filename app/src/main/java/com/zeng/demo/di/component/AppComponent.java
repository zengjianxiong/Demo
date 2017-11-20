package com.zeng.demo.di.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.zeng.demo.DemoApp;
import com.zeng.demo.di.module.AbstractActivityBindingModule;
import com.zeng.demo.di.module.AbstractApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * description:Data：2017/11/17-14:44
 * App应用组件
 *
 * @author admin
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AbstractApplicationModule.class,
        AbstractActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    /**
     * @param demoApp DemoApp
     */
    void inject(DemoApp demoApp);

    /**
     * @param instance DaggerApp
     */
    @Override
    void inject(DaggerApplication instance);





    @Component.Builder
    interface Builder {

        /**
         * @param application App引用
         * @return 应用组件的构建方法
         */
        @BindsInstance
        AppComponent.Builder application(Application application);

        /**
         * @return 返回应用组件
         */
        AppComponent build();
    }
}
