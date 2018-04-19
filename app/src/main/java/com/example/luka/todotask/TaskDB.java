package com.example.luka.todotask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;



/**
 * Created by Luka on 18.4.2018..
 */

public class TaskDB extends SQLiteOpenHelper {
    private static TaskDB  mTaskDB = null;


    public TaskDB (Context context){
        super(context.getApplicationContext(), Schema.DATABASE_NAME,null, Schema.SCHEMA_VERSION);
    }

    public static synchronized TaskDB getInstance(Context context){
        if(mTaskDB == null){
            mTaskDB = new TaskDB(context);
        }
        return mTaskDB;
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_TABLE_TASKS); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_TASKS);
        this.onCreate(db);
    }

    //SQL statements
    String CREATE_TABLE_TASKS = "CREATE TABLE " + Schema.TABLE_TASKS
            + "(" + Schema.TITLE + " TEXT PRIMARY KEY," + Schema.PRIORITY + " TEXT," + ")";



    static final String DROP_TABLE_TASKS = "DROP TABLE IF EXISTS " + Schema.TABLE_TASKS;

    static final String SELECT_ALL_TASKS = "SELECT " + Schema.TITLE + "," + Schema.PRIORITY + " FROM " + Schema.TABLE_TASKS;


    public ArrayList<Task> getAllTasks(){
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writeableDatabase.rawQuery(SELECT_ALL_TASKS,null);
        ArrayList<Task> tasks = new ArrayList<>();
        if(taskCursor.moveToFirst()){
            do{
                String title = taskCursor.getString(0);
                String priority = taskCursor.getString(1);
                tasks.add(new Task(title, priority));
            }while(taskCursor.moveToNext());
        }
        taskCursor.close();
        writeableDatabase.close();
        return tasks;
    }

    public void addTasks(Task task){
        ContentValues inputValues = new ContentValues();
        inputValues.put(Schema.TITLE, task.getmTitle()); //put value of getmTitle in inputValues
        inputValues.put(Schema.PRIORITY,task.getmPriority());//put value of priority in inputValues
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_TASKS, Schema.TITLE, inputValues);
        writeableDatabase.close();
    }

    public void deleteTask(Task task){
        String title = task.getmTitle();
        String[] arg = new String[]{String.valueOf(title)};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Schema.TABLE_TASKS, Schema.TITLE + "=?", arg);
        db.close();
    }



    public static class Schema{
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "tasks.db";
        static final String TABLE_TASKS = "tasks";
        static final String TITLE = "title";
        static final String PRIORITY ="priority";
    }
    }

