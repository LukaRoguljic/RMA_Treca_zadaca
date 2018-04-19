package com.example.luka.todotask;



public class Task {

    public String mTitle, mPriority;


    public Task(String mTitle, String mPriority) {
        this.mTitle = mTitle;
        this.mPriority = mPriority;

    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPriority() {
        return mPriority;
    }

    public void setmPriority(String mPriority) {
        this.mPriority = mPriority;
    }
}
