package com.example.tasksFrutle.Model;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tasksFrutle.R;

public class TaskFragment extends Fragment {

    private EditText mText;
    private Toolbar mToolbar;

    public static TaskFragment newInstance(){
        return new TaskFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_task,container,false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mText = view.findViewById(R.id.task_text);

//        mToolbar = view.findViewById(R.id.toolbar2);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setActionBar(mToolbar);
//        ActionBar actionBar = activity.getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeButtonEnabled(true);
//        if(actionBar != null){
//            actionBar.setTitle(R.string.details);
//        }


    }
}
