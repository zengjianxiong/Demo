package com.zeng.demo.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * description:Data：2017/11/17-15:05
 *
 * @author admin
 */
@Module
public abstract class AbstractApplicationModule {
    /**
     * @param application application
     * @return Context
     */
    @Binds
    abstract Context bindContext(Application application);
}
