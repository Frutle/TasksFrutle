package com.example.tasksFrutle;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tasksFrutle.Model.Task;
import com.example.tasksFrutle.Model.TaskFragment;


public class Holder extends RecyclerView.ViewHolder {
    TextView mTaskText;
    CheckBox mCheckBox;
    ImageView mDelete;
    private boolean update;
    private String text;

    Task mTask;

    public Holder(@NonNull View itemView) {
        super(itemView);

        mTaskText = itemView.findViewById(R.id.task_text);
        mCheckBox = itemView.findViewById(R.id.complete);
        mDelete = itemView.findViewById(R.id.delete);

        //сохраняем ранее введенный текст и передаем его в другой fragment
        itemView.setOnClickListener(v -> {
            text = mTaskText.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("text",text);

            TaskFragment taskFragment = TaskFragment.newInstance();
            taskFragment.setArguments(bundle);

            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity,taskFragment)
                    .addToBackStack(null)
                    .commit();
        });

        mCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(!update){
                mTask.mDone = isChecked;
                App.getInstance().getDataTask().update(mTask);
            }
            crossOut();
        });

        mDelete.setOnClickListener(v -> {
            App.getInstance().getDataTask().delete(mTask);
        });
    }

    public void bind(Task task){
        mTask = task;

        mTaskText.setText(task.mText);
        crossOut();

        update = true;
        mCheckBox.setChecked(mTask.mDone);
        update = false;
    }
//если дело сделано,то вычеркиваем
    private void crossOut(){
        if(mTask.mDone){
            mTaskText.setPaintFlags(mTaskText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            mTaskText.setPaintFlags(mTaskText.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

}
