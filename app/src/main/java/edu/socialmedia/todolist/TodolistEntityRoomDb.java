package edu.socialmedia.todolist;

import android.util.EventLogTags;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Task")
public class TodolistEntityRoomDb {
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "topic_date_name")
    private String tdn;
    @ColumnInfo(name = "date_of_reminder")
    private String dor;
    @ColumnInfo(name = "add_task")
    private String addTask;
    @ColumnInfo(name = "task_description")
    private String taskDescription;
    @ColumnInfo(name = "choose_date")
    private String chooseDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTdn() {
        return tdn;
    }

    public void setTdn(String tdn) {
        this.tdn = tdn;
    }

    public String getDor() {
        return dor;
    }

    public void setDor(String dor) {
        this.dor = dor;
    }

    public String getAddTask() {
        return addTask;
    }

    public void setAddTask(String addTask) {
        this.addTask = addTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(String chooseDate) {
        this.chooseDate = chooseDate;
    }
}
