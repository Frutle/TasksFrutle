package com.example.tasksFrutle;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mToolbar = view.findViewById(R.id.toolbar);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        activity.setActionBar(mToolbar);


        mRecyclerView = view.findViewById(R.id.RecyclerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

}
