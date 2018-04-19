package com.example.luka.todotask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.OnClick;

public class AddTask extends AppCompatActivity {

    @BindView(R.id.etTaskInput) EditText etTaskInput;
    @BindView(R.id.prioritySpinner) Spinner prioritySpinner;
    @BindView(R.id.btnAddTask) Button btnAddTask;

    EditText mTaskInput;
    Spinner  mPriority;
    Button   mBtnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

   /* private void trigger(){
        mTaskInput  = etTaskInput;
        mPriority   = prioritySpinner;
        mBtnAddTask = btnAddTask;

        btnAddTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void OnClick(View view){

            }
        }
    }*/
}
