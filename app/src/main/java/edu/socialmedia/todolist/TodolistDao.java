package edu.socialmedia.todolist;


import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface TodolistDao {
    @Insert
    void createTask(TodolistEntityRoomDb todolistEntityRoomDb);

}
