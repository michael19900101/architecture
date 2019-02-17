package com.aotuman.architecture.mvvm.model.data;


import com.aotuman.architecture.mvvm.model.entity.Movie;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.functions.Func1;

public class RetrofitHelper {
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private DouBanMovieService movieService;
    OkHttpClient.Builder builder;

    /**
     * 获取RetrofitHelper对象的单例
     * */
    private static class Singleton {
        private static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return Singleton.INSTANCE;
    }

    private RetrofitHelper() {
        builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(DouBanMovieService.BASE_URL)
                .build();
        movieService = retrofit.create(DouBanMovieService.class);
    }

    //todo
    public void getMovies(Subscriber<Movie> subscriber, int start, int count) {
//        movieService.getMovies(start, count)
//                .map(new Func1<Response<List<Movie>>, List<Movie>>() {
//                    @Override
//                    public List<Movie> call(Response<List<Movie>> listResponse) {
//                        return listResponse.body();
//                    }
//                })
//                .flatMap(new Func1<List<Movie>, Observable<Movie>>() {
//                    @Override
//                    public Observable<Movie> call(List<Movie> movies) {
//                        return Observable.from(movies);
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
    }

}