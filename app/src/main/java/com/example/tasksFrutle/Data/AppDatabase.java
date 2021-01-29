package com.example.tasksFrutle.Data;

import androidx.room.Database;

import com.example.tasksFrutle.Model.Task;

@Database(entities = {Task.class},version = 1,exportSchema = false)
public abstract class AppDatabase {
    public abstract DataTask taskDao();

}
