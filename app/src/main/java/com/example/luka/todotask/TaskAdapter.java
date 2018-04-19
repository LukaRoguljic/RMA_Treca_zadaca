package com.example.luka.todotask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * Created by Luka on 19.4.2018..
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    ArrayList<Task> mTasks;


    public TaskAdapter(ArrayList<Task> tasks){
        mTasks = tasks;
    }

    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View taskView = inflater.inflate(R.layout.item_task,parent,false);
        ViewHolder taskViewHolder = new ViewHolder(taskView);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(TaskAdapter.ViewHolder holder, int poition){
        Task task = this.mTasks.get(poition);
        holder.tvTitle.setText(task.getmTitle());
        holder.tvPriorityColor.setText(task.getmPriority());
    }

    @Override
    public int getItemCount(){
        return this.mTasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mtvTitle, mtvPriorityColor;

        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvPriorityColor) TextView tvPriorityColor;

        public ViewHolder(View itemView){
            super(itemView);
            this.mtvTitle = tvTitle;
            this.mtvPriorityColor = tvPriorityColor;
        }
    }


}
