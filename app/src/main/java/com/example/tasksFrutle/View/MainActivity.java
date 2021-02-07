package com.example.tasksFrutle.View;

import android.os.Bundle;

import com.example.tasksFrutle.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity, MainFragment.newInstance())
                    .commit(); }
         }
    }
