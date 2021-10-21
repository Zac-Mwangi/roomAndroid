package com.example.architectures;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//interface or abstract because we dont provide method body but room does it for us
//DAU we define all database operations
@Dao
public interface NoteDao {
    //create methods for all operations we want to do
    @Insert //ctrl+b to open
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
}
//next we create NoteDatabase.java