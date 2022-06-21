package com.example.sandook.Database.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_bank")
public class BankModel implements Serializable {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;

    @ColumnInfo(name = "name")
    @NonNull
    public String bName;

    @ColumnInfo(name = "bank")
    @NonNull
    public String bankName;

    @ColumnInfo(name = "ac_holder")
    @NonNull
    public String bAcHolder;

    @ColumnInfo(name = "ac_no")
    @NonNull
    public String bAc;

    @ColumnInfo(name = "bic")
    @NonNull
    public String bBic;

    @ColumnInfo(name = "iban")
    @NonNull
    public String bIban;

    @ColumnInfo(name = "ifsc")
    @NonNull
    public String bIfsc;

    public BankModel(@NonNull String bName, @NonNull String bankName, @NonNull String bAcHolder, @NonNull String bAc, @NonNull String bBic, @NonNull String bIban, @NonNull String bIfsc) {
        this.bName = bName;
        this.bankName = bankName;
        this.bAcHolder = bAcHolder;
        this.bAc = bAc;
        this.bBic = bBic;
        this.bIban = bIban;
        this.bIfsc = bIfsc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getbName() {
        return bName;
    }

    public void setbName(@NonNull String bName) {
        this.bName = bName;
    }

    @NonNull
    public String getBankName() {
        return bankName;
    }

    public void setBankName(@NonNull String bankName) {
        this.bankName = bankName;
    }

    @NonNull
    public String getbAcHolder() {
        return bAcHolder;
    }

    public void setbAcHolder(@NonNull String bAcHolder) {
        this.bAcHolder = bAcHolder;
    }

    @NonNull
    public String getbAc() {
        return bAc;
    }

    public void setbAc(@NonNull String bAc) {
        this.bAc = bAc;
    }

    @NonNull
    public String getbBic() {
        return bBic;
    }

    public void setbBic(@NonNull String bBic) {
        this.bBic = bBic;
    }

    @NonNull
    public String getbIban() {
        return bIban;
    }

    public void setbIban(@NonNull String bIban) {
        this.bIban = bIban;
    }

    @NonNull
    public String getbIfsc() {
        return bIfsc;
    }

    public void setbIfsc(@NonNull String bIfsc) {
        this.bIfsc = bIfsc;
    }
}
