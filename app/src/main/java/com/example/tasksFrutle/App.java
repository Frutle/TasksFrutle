package com.example.tasksFrutle;

import android.app.Application;

import androidx.room.Room;

import com.example.tasksFrutle.Data.AppDatabase;
import com.example.tasksFrutle.Data.DataTask;

public class App extends Application {

    private AppDatabase mDatabase;
    private DataTask mDataTask;

    public static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() { //для инициализации при старте
        super.onCreate();

        instance = this;

        mDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"data")
                .build();

        mDataTask = mDatabase.taskDao();
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }

    public void setDatabase(AppDatabase database) {
        mDatabase = database;
    }

    public DataTask getDataTask() {
        return mDataTask;
    }

    public void setDataTask(DataTask dataTask) {
        mDataTask = dataTask;
    }
}

