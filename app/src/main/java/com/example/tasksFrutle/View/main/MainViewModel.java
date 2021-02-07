package com.example.tasksFrutle.View.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tasksFrutle.App;
import com.example.tasksFrutle.Model.Task;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LiveData<List<Task>> taskLiveData = App.getInstance().getDataTask().getAllLiveData();

    public LiveData<List<Task>> getTaskLiveData() {
        return taskLiveData;
    }
}
