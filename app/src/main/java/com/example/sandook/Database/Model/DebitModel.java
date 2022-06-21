package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_debit")
public class DebitModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "bank")
    @NonNull
    public String dBank;

    @ColumnInfo(name = "ac_holder")
    @NonNull
    public String dAcHolder;

    @ColumnInfo(name = "number")
    @NonNull
    public String dNumber;

    @ColumnInfo(name = "security_code")
    @NonNull
    public String dSecurity;

    @ColumnInfo(name = "cvv")
    @NonNull
    public String dCvv;

    @ColumnInfo(name = "expiry")
    @NonNull
    public String dExpiration;

    @ColumnInfo(name = "name")
    @NonNull
    public String dName;

    @ColumnInfo(name = "address")
    @NonNull
    public String dAddress;

    public DebitModel(@NonNull String dBank, @NonNull String dAcHolder, @NonNull String dNumber, @NonNull String dSecurity, @NonNull String dCvv, @NonNull String dExpiration, @NonNull String dName, @NonNull String dAddress) {
        this.dBank = dBank;
        this.dAcHolder = dAcHolder;
        this.dNumber = dNumber;
        this.dSecurity = dSecurity;
        this.dCvv = dCvv;
        this.dExpiration = dExpiration;
        this.dName = dName;
        this.dAddress = dAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getdBank() {
        return dBank;
    }

    public void setdBank(@NonNull String dBank) {
        this.dBank = dBank;
    }

    @NonNull
    public String getdAcHolder() {
        return dAcHolder;
    }

    public void setdAcHolder(@NonNull String dAcHolder) {
        this.dAcHolder = dAcHolder;
    }

    @NonNull
    public String getdNumber() {
        return dNumber;
    }

    public void setdNumber(@NonNull String dNumber) {
        this.dNumber = dNumber;
    }

    @NonNull
    public String getdSecurity() {
        return dSecurity;
    }

    public void setdSecurity(@NonNull String dSecurity) {
        this.dSecurity = dSecurity;
    }

    @NonNull
    public String getdCvv() {
        return dCvv;
    }

    public void setdCvv(@NonNull String dCvv) {
        this.dCvv = dCvv;
    }

    @NonNull
    public String getdExpiration() {
        return dExpiration;
    }

    public void setdExpiration(@NonNull String dExpiration) {
        this.dExpiration = dExpiration;
    }

    @NonNull
    public String getdName() {
        return dName;
    }

    public void setdName(@NonNull String dName) {
        this.dName = dName;
    }

    @NonNull
    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(@NonNull String dAddress) {
        this.dAddress = dAddress;
    }
}
