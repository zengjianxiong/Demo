package com.zeng.demo.base;


import android.content.Context;


import com.zeng.demo.mvp.IModel;
import com.zeng.demo.mvp.IPresenter;
import com.zeng.demo.mvp.IView;

import java.lang.ref.WeakReference;

/**
 * Presenter基类
 *
 * @author gc
 * @since 1.0
 */
public abstract class BasePresenter<V extends IView> implements IPresenter {


    private WeakReference<V> mViewRef; // View接口类型的弱引用


    /**
     * 建立关联
     *
     * @param iview
     */
    @Override
    public void attachView(IView iview) {
        mViewRef = new WeakReference(iview);
    }

    /**
     * 解除关联
     */
    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    /**
     * 获取View
     *
     * @return
     */
    @Override
    public V getIView() {
        return mViewRef.get();
    }

    /**
     * 判断是否与View建立了关联
     *
     * @return 建立则返回true
     */
    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }


}
