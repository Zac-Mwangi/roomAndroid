package com.example.architectures;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table") //default table name is from class name
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    // @ColumnInfo(name = "priority_column") //changes the column name
    // @Ignore //ignore field thus field wont be added to table
    private int priority;

    //constructor apart from id


    public Note(String title, String description, int priority) {
        //no id since its auto generated, for id we create setter
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //No need for id on constructor because we don't provide it its auto auto increased
    public void setId(int id) {
        this.id = id;
    }


    //for room to persist the values n database we add getter method
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
