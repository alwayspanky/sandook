package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_Password")
public class PassModel implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "Name")
    @NonNull
    public String name;

    @ColumnInfo(name = "Login")
    @NonNull
    public String login;

    @ColumnInfo(name = "Password")
    @NonNull
    public String password;

    @ColumnInfo(name = "Website")
    @NonNull
    public String website;

    @ColumnInfo(name = "Category")
    @NonNull
    public String category;

    @ColumnInfo(name = "Notes")
    @NonNull
    public String notes;

    public PassModel(@NonNull String name, @NonNull String login, @NonNull String password, @NonNull String website, @NonNull String category, @NonNull String notes) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.website = website;
        this.category = category;
        this.notes = notes;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@NonNull String website) {
        this.website = website;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    public void setCategory(@NonNull String category) {
        this.category = category;
    }

    @NonNull
    public String getNotes() {
        return notes;
    }

    public void setNotes(@NonNull String notes) {
        this.notes = notes;
    }
}
