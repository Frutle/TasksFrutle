package com.example.tasksFrutle.Model;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.tasksFrutle.App;
import com.example.tasksFrutle.View.MainFragment;
import com.example.tasksFrutle.R;

public class TaskFragment extends Fragment {

    private EditText mEditText;
    private Toolbar mToolbar;
    private Task mTask;

    public static TaskFragment newInstance(){
        return new TaskFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_task,container,false);

        setHasOptionsMenu(true);

        mToolbar = (Toolbar) view.findViewById(R.id.toolbar2);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setTitle(R.string.details);
        }

        mEditText = view.findViewById(R.id.task_text);

        mTask = new Task();
        //получаем текст из view holder ,если он был
        Bundle bundle = this.getArguments();
        if(bundle != null) {
            mEditText.setText(bundle.get("text").toString());
        }
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_task,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: //если была нажата кнопка home возвращаемся в main
                getFragmentManager().beginTransaction()
                        .replace(R.id.activity, MainFragment.newInstance())
                        .commit();
                break;
            case R.id.it_save:
                if(mEditText.getText().length() > 0) {
                    mTask.mText = mEditText.getText().toString();
                    mTask.mDone = false;
                    mTask.mTime = (int) System.currentTimeMillis();
                    if (App.getInstance().getDatabase().inTransaction()) {
                        App.getInstance().getDataTask().update(mTask);
                    } else {
                        App.getInstance().getDataTask().insert(mTask);
                    }
                    getFragmentManager().beginTransaction()
                            .replace(R.id.activity, MainFragment.newInstance())
                            .commit();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
