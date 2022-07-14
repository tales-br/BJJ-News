package me.dio.bjjnews.data.remote;

import java.util.List;

import me.dio.bjjnews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BjjNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
