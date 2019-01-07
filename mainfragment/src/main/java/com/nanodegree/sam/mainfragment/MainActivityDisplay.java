package com.nanodegree.sam.mainfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivityDisplay extends AppCompatActivity {

    TextView jokeDisplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_main);

        jokeDisplayer = findViewById(R.id.displayjoke);
        jokeDisplayer.setText(getIntent().getStringExtra("JokeExtra"));

    }
}
