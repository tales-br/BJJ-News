package me.dio.bjjnews.data;

import androidx.room.Room;

import me.dio.bjjnews.App;
import me.dio.bjjnews.data.local.BjjNewsDb;
import me.dio.bjjnews.data.remote.BjjNewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BjjNewsRepository {

    //region Constantes
    private static final String REMOTE_API_URL = "https://tales-br.github.io/bjj-news-api/";
    private static final String LOCAL_DB_NAME = "bjj-news";
    //endregion

    //region Atributos: encapsulam o acesso a nossa API (Retrofit) e banco de dados local (Room).
    private BjjNewsApi remoteApi;
    private BjjNewsDb localDb;

    public BjjNewsApi getRemoteApi() {
        return remoteApi;
    }

    public BjjNewsDb getLocalDb() {
        return localDb;
    }
    //endregion

    //region Singleton: garante uma instância única dos atributos relacionados ao Retrofit e Room.
    private BjjNewsRepository() {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BjjNewsApi.class);

        localDb = Room.databaseBuilder(App.getInstance(), BjjNewsDb.class, LOCAL_DB_NAME).build();
    }

    public static BjjNewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final BjjNewsRepository INSTANCE = new BjjNewsRepository();
    }
    //endregion
}
