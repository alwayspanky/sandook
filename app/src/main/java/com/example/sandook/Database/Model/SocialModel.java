package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_social")
public class SocialModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String name;

    @ColumnInfo(name = "gender")
    @NonNull
    public String gender;

    @ColumnInfo(name = "dob")
    @NonNull
    public String dob;

    @ColumnInfo(name = "country")
    @NonNull
    public String country;

    @ColumnInfo(name = "number")
    @NonNull
    public String number;

    public SocialModel(@NonNull String name, @NonNull String gender, @NonNull String dob, @NonNull String country, @NonNull String number) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.country = country;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getDob() {
        return dob;
    }

    public void setDob(@NonNull String dob) {
        this.dob = dob;
    }

    @NonNull
    public String getCountry() {
        return country;
    }

    public void setCountry(@NonNull String country) {
        this.country = country;
    }

    @NonNull
    public String getNumber() {
        return number;
    }

    public void setNumber(@NonNull String number) {
        this.number = number;
    }
}
