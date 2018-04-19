package com.example.luka.todotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnNewTask)  Button  btnNewTask;
    @BindView(R.id.rvTaskView)  RecyclerView rvTaskView;
    String title, priority;
    RecyclerView mTaskList;
    Button  mNewTaskBtn;

    Bundle first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        first = getIntent().getExtras();
        second = getIntent().getExtras();

        //setUpUI();
    }

    private void setUpUI(){


        title = first.toString();
        priority = second.toString();

        mTaskList = rvTaskView;
        ArrayList<Task> tasks = this.loadTasks();
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        mTaskList.setAdapter(taskAdapter);
        mNewTaskBtn = btnNewTask;
        mNewTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task(title,priority);
                TaskDB.getInstance(getApplicationContext()).addTasks(task);
                TaskAdapter adapter = (TaskAdapter) rvTaskView.getAdapter();
                adapter.insert(task);
            }
        });
    }

    private ArrayList<Task> loadTasks() {
        return TaskDB.getInstance(this).getAllTasks();
    }

    @OnClick(R.id.btnNewTask)
    public void startAddTask(){

        Intent startAddTaskActivity = new Intent(this,AddTask.class);
        startActivity(startAddTaskActivity);
    }
}
