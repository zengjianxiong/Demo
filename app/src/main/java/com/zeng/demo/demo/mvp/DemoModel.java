package com.zeng.demo.demo.mvp;

import com.zeng.demo.MoviesWraper;
import com.zeng.demo.network.TmdbWebService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class DemoModel implements DemoContract.IModel {

    private TmdbWebService webService;

    @Inject
    public DemoModel(TmdbWebService service) {
        webService = service;
    }

    @Override
    public void show() {
        webService.popularMovies().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new Consumer<MoviesWraper>() {
            @Override
            public void accept(MoviesWraper moviesWraper) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                throwable.printStackTrace();
            }
        });

    }
}
