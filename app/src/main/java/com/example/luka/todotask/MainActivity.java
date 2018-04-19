package com.example.luka.todotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnNewTask)  Button  btnNewTask;
    @BindView(R.id.rvTaskView)  RecyclerView rvTaskView;
    String title, priority;
    ListView mTaskList;
    Button  mNewTaskBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);;
        ButterKnife.bind(this);
    }



    @OnClick(R.id.btnNewTask)
    public void startAddTask(){
        Intent startAddTaskActivity = new Intent(this,AddTask.class);
        startActivity(startAddTaskActivity);
    }
}
