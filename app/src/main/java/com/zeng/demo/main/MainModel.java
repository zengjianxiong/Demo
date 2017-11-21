package com.zeng.demo.main;

import com.zeng.demo.base.BaseModel;
import com.zeng.demo.network.TmdbWebService;

import javax.inject.Inject;

/**
 * description:Data：2017/11/20-16:01
 *
 * @author admin
 */

public class MainModel extends BaseModel implements MainContract.Model {



    @Inject
    public MainModel() {

    }

    @Override
    public String addtext(String clazzName) {
        return "hello-->" + clazzName;
    }
}
