package com.example.sandook.Database.Model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_passport")
public class PassportModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String pName;

    @ColumnInfo(name = "gender")
    @NonNull
    public String pGender;

    @ColumnInfo(name = "dob")
    @NonNull
    public String pDob;

    @ColumnInfo(name = "country")
    @NonNull
    public String pCountry;

    @ColumnInfo(name = "number")
    @NonNull
    public String pNumber;

    @ColumnInfo(name = "issueDate")
    @NonNull
    public String pIssueDate;

    @ColumnInfo(name = "placeIssue")
    @NonNull
    public String pPlaceIssue;

    @ColumnInfo(name = "expiry")
    @NonNull
    public String pExpirationDate;

    public PassportModel(@NonNull String pName, @NonNull String pGender, @NonNull String pDob, @NonNull String pCountry, @NonNull String pNumber, @NonNull String pIssueDate, @NonNull String pPlaceIssue, @NonNull String pExpirationDate) {
        this.pName = pName;
        this.pGender = pGender;
        this.pDob = pDob;
        this.pCountry = pCountry;
        this.pNumber = pNumber;
        this.pIssueDate = pIssueDate;
        this.pPlaceIssue = pPlaceIssue;
        this.pExpirationDate = pExpirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getpName() {
        return pName;
    }

    public void setpName(@NonNull String pName) {
        this.pName = pName;
    }

    @NonNull
    public String getpGender() {
        return pGender;
    }

    public void setpGender(@NonNull String pGender) {
        this.pGender = pGender;
    }

    @NonNull
    public String getpDob() {
        return pDob;
    }

    public void setpDob(@NonNull String pDob) {
        this.pDob = pDob;
    }

    @NonNull
    public String getpCountry() {
        return pCountry;
    }

    public void setpCountry(@NonNull String pCountry) {
        this.pCountry = pCountry;
    }

    @NonNull
    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(@NonNull String pNumber) {
        this.pNumber = pNumber;
    }

    @NonNull
    public String getpIssueDate() {
        return pIssueDate;
    }

    public void setpIssueDate(@NonNull String pIssueDate) {
        this.pIssueDate = pIssueDate;
    }

    @NonNull
    public String getpPlaceIssue() {
        return pPlaceIssue;
    }

    public void setpPlaceIssue(@NonNull String pPlaceIssue) {
        this.pPlaceIssue = pPlaceIssue;
    }

    @NonNull
    public String getpExpirationDate() {
        return pExpirationDate;
    }

    public void setpExpirationDate(@NonNull String pExpirationDate) {
        this.pExpirationDate = pExpirationDate;
    }
}
