package edu.socialmedia.todolist;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodolistEntityRoomDb.class}, version = 1)
public abstract class TodoListDb extends RoomDatabase {

    public abstract TodolistDao mTodolistDao();

}
