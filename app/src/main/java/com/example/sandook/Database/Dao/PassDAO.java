package com.example.sandook.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sandook.Database.Model.BankModel;
import com.example.sandook.Database.Model.CreditModel;
import com.example.sandook.Database.Model.DebitModel;
import com.example.sandook.Database.Model.DrivingModel;
import com.example.sandook.Database.Model.IdCardModel;
import com.example.sandook.Database.Model.PassModel;
import com.example.sandook.Database.Model.PassportModel;
import com.example.sandook.Database.Model.SocialModel;
import com.example.sandook.Database.Model.TaxModel;
import com.example.sandook.Database.Model.noteModel;

import java.util.List;

@Dao
public interface PassDAO {

    //For Password Table
    @Query("SELECT * FROM tbl_Password")
    LiveData<List<PassModel>> getAll();

    @Insert
    void insert(PassModel pass);

    @Delete
    void delete(PassModel pass);

    @Update
    void update(PassModel pass);

    @Query("DELETE FROM tbl_Password")
    void deleteAll();

    //for Notes Table
    @Query("SELECT * FROM tbl_notes")
    LiveData<List<noteModel>> getAllNotes();

    @Insert
    void insertNote(noteModel note);

    @Delete
    void deleteNote(noteModel note);

    @Update
    void updateNote(noteModel note);

    @Query("DELETE FROM tbl_notes")
    void deleteAllNotes();

    //For Bank table
    @Query("SELECT * FROM tbl_bank")
    LiveData<List<BankModel>> getAllBanks();

    @Insert
    void insertBank(BankModel bank);

    @Delete
    void deleteBank(BankModel bank);

    @Update
    void updateBank(BankModel bank);

    @Query("DELETE FROM tbl_bank")
    void deleteAllBank();

    //For Credit table
    @Query("SELECT * FROM tbl_credit")
    LiveData<List<CreditModel>> getAllCredit();

    @Insert
    void insertCredit(CreditModel credit);

    @Delete
    void deleteCredit(CreditModel credit);

    @Update
    void updateCredit(CreditModel credit);

    @Query("DELETE FROM tbl_credit")
    void deleteAllCredit();

    //For Debit table
    @Query("SELECT * FROM tbl_debit")
    LiveData<List<DebitModel>> getAllDebit();

    @Insert
    void insertDebit(DebitModel debit);

    @Delete
    void deleteDebit(DebitModel debit);

    @Update
    void updateDebit(DebitModel debit);

    @Query("DELETE FROM tbl_debit")
    void deleteAllDebit();

    //For Driving Table
    @Query("SELECT * FROM tbl_driving")
    LiveData<List<DrivingModel>> getAllDriving();

    @Insert
    void insertDriving(DrivingModel driving);

    @Delete
    void deleteDriving(DrivingModel driving);

    @Update
    void updateDriving(DrivingModel driving);

    @Query("DELETE FROM tbl_driving")
    void deleteAllDriving();

    //For Id card Table
    @Query("SELECT * FROM tbl_idCard")
    LiveData<List<IdCardModel>> getAllIdCards();

    @Insert
    void insertIdCard(IdCardModel idCard);

    @Delete
    void deleteIdCard(IdCardModel idCard);

    @Update
    void updateIdCard(IdCardModel idCard);

    @Query("DELETE FROM tbl_idCard")
    void deleteAllIdCard();

    //For Passport table
    @Query("SELECT * FROM tbl_passport")
    LiveData<List<PassportModel>> getAllPassport();

    @Insert
    void insertPassport(PassportModel passport);

    @Delete
    void deletePassport(PassportModel passport);

    @Update
    void updatePassport(PassportModel passport);

    @Query("DELETE FROM tbl_passport")
    void deleteAllPassport();

    //For Social Table
    @Query("SELECT * FROM tbl_social")
    LiveData<List<SocialModel>> getAllSocial();

    @Insert
    void insertSocial(SocialModel social);

    @Delete
    void deleteSocial(SocialModel social);

    @Update
    void updateSocial(SocialModel social);

    @Query("DELETE FROM tbl_social")
    void deleteAllSocial();

    //For Tax table
    @Query("SELECT * FROM tbl_tax")
    LiveData<List<TaxModel>> getAllTax();

    @Insert
    void insertTax(TaxModel tax);

    @Delete
    void deleteTax(TaxModel tax);

    @Update
    void updateTax(TaxModel tax);

    @Query("DELETE FROM tbl_tax")
    void deleteAllTax();

}
