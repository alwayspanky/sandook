package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_idCard")
public class IdCardModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String iName;

    @ColumnInfo(name = "gender")
    @NonNull
    public String iGender;

    @ColumnInfo(name = "dob")
    @NonNull
    public String iDob;

    @ColumnInfo(name = "country")
    @NonNull
    public String iCountry;

    @ColumnInfo(name = "number")
    @NonNull
    public String iNumber;

    @ColumnInfo(name = "issueDate")
    @NonNull
    public String iIssueDate;

    @ColumnInfo(name = "expiry")
    @NonNull
    public String iExpirationDate;

    @ColumnInfo(name = "address")
    @NonNull
    public String iAddress;

    public IdCardModel(@NonNull String iName, @NonNull String iGender, @NonNull String iDob, @NonNull String iCountry, @NonNull String iNumber, @NonNull String iIssueDate, @NonNull String iExpirationDate, @NonNull String iAddress) {
        this.iName = iName;
        this.iGender = iGender;
        this.iDob = iDob;
        this.iCountry = iCountry;
        this.iNumber = iNumber;
        this.iIssueDate = iIssueDate;
        this.iExpirationDate = iExpirationDate;
        this.iAddress = iAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getiName() {
        return iName;
    }

    public void setiName(@NonNull String iName) {
        this.iName = iName;
    }

    @NonNull
    public String getiGender() {
        return iGender;
    }

    public void setiGender(@NonNull String iGender) {
        this.iGender = iGender;
    }

    @NonNull
    public String getiDob() {
        return iDob;
    }

    public void setiDob(@NonNull String iDob) {
        this.iDob = iDob;
    }

    @NonNull
    public String getiCountry() {
        return iCountry;
    }

    public void setiCountry(@NonNull String iCountry) {
        this.iCountry = iCountry;
    }

    @NonNull
    public String getiNumber() {
        return iNumber;
    }

    public void setiNumber(@NonNull String iNumber) {
        this.iNumber = iNumber;
    }

    @NonNull
    public String getiIssueDate() {
        return iIssueDate;
    }

    public void setiIssueDate(@NonNull String iIssueDate) {
        this.iIssueDate = iIssueDate;
    }

    @NonNull
    public String getiExpirationDate() {
        return iExpirationDate;
    }

    public void setiExpirationDate(@NonNull String iExpirationDate) {
        this.iExpirationDate = iExpirationDate;
    }

    @NonNull
    public String getiAddress() {
        return iAddress;
    }

    public void setiAddress(@NonNull String iAddress) {
        this.iAddress = iAddress;
    }
}
