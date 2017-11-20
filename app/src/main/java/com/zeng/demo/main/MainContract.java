package com.zeng.demo.main;

/**
 * description:Data：2017/11/20-14:44
 *
 * @author admin
 */

public class MainContract {
    interface View {
        void showTextView(String clazzName);
    }

    public interface Presenter {
        /**
         * 展示类名
         *
         * @param clazzName 类名
         */
        void setTextView(String clazzName);
    }

    interface Model {
        String addtext(String clazzName);
    }
}
