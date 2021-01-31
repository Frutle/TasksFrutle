package com.example.tasksFrutle;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksFrutle.Model.Task;
import com.example.tasksFrutle.Model.TaskFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private RecyclerView mRecyclerView;
    private FloatingActionButton mActionButton;
    private Adapter mAdapter;
    private Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);

        mToolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.RecyclerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new Adapter();
        mRecyclerView.setAdapter(mAdapter);

        mActionButton = view.findViewById(R.id.fab);
        mActionButton.setOnClickListener(v -> {
            getFragmentManager().beginTransaction()
                    .replace(R.id.activity, TaskFragment.newInstance())
                    .commit();
        });

        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getTaskLiveData().observe(getViewLifecycleOwner(),
                tasks -> {
            mAdapter.setItems(tasks);
        });
    }

}
