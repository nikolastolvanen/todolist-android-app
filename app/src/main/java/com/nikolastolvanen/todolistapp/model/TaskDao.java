package com.nikolastolvanen.todolistapp.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

    @Query("DELETE FROM task_table")
    void deleteAllTasks();

    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM task_table WHERE task_table.id == :id")
    LiveData<Task> getTask(long id);

    //@Query("SELECT * FROM task_table WHERE due_date") /////////////////////////
    //LiveData<List<Task>> getTasksToday();

}
