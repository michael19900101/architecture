package com.aotuman.architecture.mvvm.model.data;

import com.aotuman.architecture.mvvm.model.entity.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DouBanMovieService {
    String BASE_URL = "https://api.douban.com/v2/movie/";

    @GET("top250")
    Observable<Response<List<Movie>>> getMovies(@Query("start") int start, @Query("count") int count);
}