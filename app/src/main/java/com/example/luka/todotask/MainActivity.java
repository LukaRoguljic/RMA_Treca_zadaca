package com.example.luka.todotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnNewCat)   Button btnNewCategory;
    @BindView(R.id.btnNewTask)  Button btnNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnNewCat)
    public void startAddCategory(){
        Intent startAddCatActivity = new Intent(this,AddCategory.class);
        startActivity(startAddCatActivity);
    }

    @OnClick(R.id.btnNewTask)
    public void startAddTask(){
        Intent startAddTaskActivity = new Intent(this,AddTask.class);
        startActivity(startAddTaskActivity);
    }
}
