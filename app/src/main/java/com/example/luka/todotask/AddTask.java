package com.example.luka.todotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddTask extends AppCompatActivity {

    Intent intent = new Intent();
    public static final String TITLE = "title";
    public static final String PRIORITY = "priority";

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
        ButterKnife.bind(this);
        trigger();
    }

    private void trigger(){
        mTaskInput  = etTaskInput;
        mPriority   = prioritySpinner;
        mBtnAddTask = btnAddTask;

        mBtnAddTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String title = etTaskInput.getText().toString();
                String priority = prioritySpinner.getSelectedItem().toString();

                if(etTaskInput.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    intent.putExtra(TITLE,title);
                    intent.putExtra(PRIORITY,priority);
                    intent.setClass(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
