package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_credit")
public class CreditModel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "bank")
    @NonNull
    public String cBank;

    @ColumnInfo(name = "ac_holder")
    @NonNull
    public String cAcHolder;

    @ColumnInfo(name = "number")
    @NonNull
    public String cNumber;

    @ColumnInfo(name = "security_code")
    @NonNull
    public String cSecurity;

    @ColumnInfo(name = "cvv")
    @NonNull
    public String cCvv;

    @ColumnInfo(name = "expiry")
    @NonNull
    public String cExpiration;

    @ColumnInfo(name = "name")
    @NonNull
    public String cName;

    @ColumnInfo(name = "address")
    @NonNull
    public String cAddress;

    public CreditModel(@NonNull String cBank, @NonNull String cAcHolder, @NonNull String cNumber, @NonNull String cSecurity, @NonNull String cCvv, @NonNull String cExpiration, @NonNull String cName, @NonNull String cAddress) {
        this.cBank = cBank;
        this.cAcHolder = cAcHolder;
        this.cNumber = cNumber;
        this.cSecurity = cSecurity;
        this.cCvv = cCvv;
        this.cExpiration = cExpiration;
        this.cName = cName;
        this.cAddress = cAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getcBank() {
        return cBank;
    }

    public void setcBank(@NonNull String cBank) {
        this.cBank = cBank;
    }

    @NonNull
    public String getcAcHolder() {
        return cAcHolder;
    }

    public void setcAcHolder(@NonNull String cAcHolder) {
        this.cAcHolder = cAcHolder;
    }

    @NonNull
    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(@NonNull String cNumber) {
        this.cNumber = cNumber;
    }

    @NonNull
    public String getcSecurity() {
        return cSecurity;
    }

    public void setcSecurity(@NonNull String cSecurity) {
        this.cSecurity = cSecurity;
    }

    @NonNull
    public String getcCvv() {
        return cCvv;
    }

    public void setcCvv(@NonNull String cCvv) {
        this.cCvv = cCvv;
    }

    @NonNull
    public String getcExpiration() {
        return cExpiration;
    }

    public void setcExpiration(@NonNull String cExpiration) {
        this.cExpiration = cExpiration;
    }

    @NonNull
    public String getcName() {
        return cName;
    }

    public void setcName(@NonNull String cName) {
        this.cName = cName;
    }

    @NonNull
    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(@NonNull String cAddress) {
        this.cAddress = cAddress;
    }
}
