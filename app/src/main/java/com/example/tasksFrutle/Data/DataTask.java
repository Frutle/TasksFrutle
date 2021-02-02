package com.example.tasksFrutle.Data;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tasksFrutle.Model.Task;

import java.util.List;

//для работы с базой данных
@Dao
public interface DataTask {
    @Query("SELECT * FROM Task")
    List<Task> getAll();

    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getAllLiveData();

    @Query("SELECT * FROM Task WHERE mId IN (:noteIds)")
    List<Task> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM Task WHERE mId = :uid LIMIT 1")
    Task findById(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

}
