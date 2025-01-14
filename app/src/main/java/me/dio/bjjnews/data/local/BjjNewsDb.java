package me.dio.bjjnews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.dio.bjjnews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class BjjNewsDb extends RoomDatabase {
    public abstract NewsDao newsDao();
}
