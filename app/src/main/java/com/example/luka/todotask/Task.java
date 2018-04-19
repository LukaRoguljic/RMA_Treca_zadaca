package com.example.luka.todotask;



public class Task {

    public String mTitle, mPriority;
    public int mID;

    public Task(int mID, String mTitle, String mPriority) {
        this.mTitle = mTitle;
        this.mPriority = mPriority;
        this.mID = mID;
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

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }
}
