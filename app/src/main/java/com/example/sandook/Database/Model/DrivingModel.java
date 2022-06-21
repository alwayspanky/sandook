package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "tbl_driving")
public class DrivingModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String dName;

    @ColumnInfo(name = "gender")
    @NonNull
    public String dGender;

    @ColumnInfo(name = "dob")
    @NonNull
    public String dDob;

    @ColumnInfo(name = "country")
    @NonNull
    public String dCountry;

    @ColumnInfo(name = "number")
    @NonNull
    public String dNumber;

    @ColumnInfo(name = "issueDate")
    @NonNull
    public String dIssueDate;

    @ColumnInfo(name = "expiry")
    @NonNull
    public String dExpirationDate;

    public DrivingModel(@NonNull String dName, @NonNull String dGender, @NonNull String dDob, @NonNull String dCountry, @NonNull String dNumber, @NonNull String dIssueDate, @NonNull String dExpirationDate) {
        this.dName = dName;
        this.dGender = dGender;
        this.dDob = dDob;
        this.dCountry = dCountry;
        this.dNumber = dNumber;
        this.dIssueDate = dIssueDate;
        this.dExpirationDate = dExpirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getdName() {
        return dName;
    }

    public void setdName(@NonNull String dName) {
        this.dName = dName;
    }

    @NonNull
    public String getdGender() {
        return dGender;
    }

    public void setdGender(@NonNull String dGender) {
        this.dGender = dGender;
    }

    @NonNull
    public String getdDob() {
        return dDob;
    }

    public void setdDob(@NonNull String dDob) {
        this.dDob = dDob;
    }

    @NonNull
    public String getdCountry() {
        return dCountry;
    }

    public void setdCountry(@NonNull String dCountry) {
        this.dCountry = dCountry;
    }

    @NonNull
    public String getdNumber() {
        return dNumber;
    }

    public void setdNumber(@NonNull String dNumber) {
        this.dNumber = dNumber;
    }

    @NonNull
    public String getdIssueDate() {
        return dIssueDate;
    }

    public void setdIssueDate(@NonNull String dIssueDate) {
        this.dIssueDate = dIssueDate;
    }

    @NonNull
    public String getdExpirationDate() {
        return dExpirationDate;
    }

    public void setdExpirationDate(@NonNull String dExpirationDate) {
        this.dExpirationDate = dExpirationDate;
    }
}
