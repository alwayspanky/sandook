package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_notes")
public class noteModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    public int id;

    @NonNull
    @ColumnInfo(name = "title")
    public String noteTitle;

    @NonNull
    @ColumnInfo(name = "note")
    public String note;

    @NonNull
    @ColumnInfo(name = "category")
    public String category;

    public noteModel(@NonNull String noteTitle, @NonNull String note, @NonNull String category) {
        this.noteTitle = noteTitle;
        this.note = note;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(@NonNull String noteTitle) {
        this.noteTitle = noteTitle;
    }

    @NonNull
    public String getNote() {
        return note;
    }

    public void setNote(@NonNull String note) {
        this.note = note;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

}

