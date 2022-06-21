package com.example.sandook.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sandook.Database.DatabaseConnect.PassRepository;
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

public class PassViewModel extends AndroidViewModel {

    private PassRepository passRepository;
    private LiveData<List<PassModel>> allPass;
    private LiveData<List<noteModel>> allNotes;
    private LiveData<List<BankModel>> allBanks;
    private LiveData<List<CreditModel>> allCredits;
    private LiveData<List<DebitModel>> allDebits;
    private LiveData<List<DrivingModel>> allDrivings;
    private LiveData<List<IdCardModel>> allIdCards;
    private LiveData<List<PassportModel>> allPassports;
    private LiveData<List<SocialModel>> allSocials;
    private LiveData<List<TaxModel>> allTaxes;

    public PassViewModel(@NonNull Application application) {
        super(application);

        passRepository = new PassRepository(application);
        allPass = passRepository.getAll();
        allNotes = passRepository.getAllNotes();
        allBanks = passRepository.getAllBank();
        allCredits = passRepository.getAllCredit();
        allDebits = passRepository.getAllDebit();
        allDrivings = passRepository.getAllDriving();
        allIdCards = passRepository.getAllIdCard();
        allPassports = passRepository.getAllPassport();
        allSocials = passRepository.getAllSocial();
        allTaxes = passRepository.getAllTax();
    }

    public void insert(PassModel pass){
        passRepository.insert(pass);
    }

    public void update(PassModel pass){
        passRepository.update(pass);
    }

    public void delete(PassModel pass){
        passRepository.delete(pass);
    }

    public LiveData<List<PassModel>> getAllPass(){
        return allPass;
    }

    // For Notes Table

    public void insertNotes(noteModel note){
        passRepository.insertNote(note);
    }

    public void updateNotes(noteModel note){
        passRepository.updateNote(note);
    }

    public void deleteNotes(noteModel note){
        passRepository.deleteNote(note);
    }

    public LiveData<List<noteModel>> getAllNotes(){
        return allNotes;
    }

    //For Bank Table

    public void insertBank(BankModel bank){
        passRepository.insertBank(bank);
    }

    public void updateBank(BankModel bank){
        passRepository.updateBank(bank);
    }

    public void deleteBank(BankModel bank){
        passRepository.deleteBank(bank);
    }

    public LiveData<List<BankModel>> getAllBanks(){
        return allBanks;
    }

    //For Credit Table

    public void insertCredit(CreditModel credit) {
        passRepository.insertCredit(credit);
    }
    public void updateCredit(CreditModel credit){
        passRepository.updateCredit(credit);
    }
    public void deleteCredit(CreditModel credit){
        passRepository.deleteCredit(credit);
    }
    public LiveData<List<CreditModel>> getAllCredits(){ return allCredits;}

    //For Debit Table

    public void insertDebit(DebitModel debit){
        passRepository.insertDebit(debit);
    }

    public void updateDebit(DebitModel debit){
        passRepository.updateDebit(debit);
    }

    public void deleteDebit(DebitModel debit){
        passRepository.deleteDebit(debit);
    }

    public LiveData<List<DebitModel>> getAllDebits(){
        return allDebits;
    }

    //For Driving table
    public void insertDriving(DrivingModel driving){
        passRepository.insertDriving(driving);
    }

    public void updateDriving(DrivingModel driving){
        passRepository.updateDriving(driving);
    }

    public void deleteDriving(DrivingModel driving){
        passRepository.deleteDriving(driving);
    }

    public LiveData<List<DrivingModel>> getAllDrivings(){
        return allDrivings;
    }

    //For Id Card table
    public void insertIdCard(IdCardModel idCard){
        passRepository.insertIdCard(idCard);
    }

    public void updateIdCard(IdCardModel idCard){
        passRepository.updateIdCard(idCard);
    }

    public void deleteIdCard(IdCardModel idCard){
        passRepository.deleteIdCard(idCard);
    }

    public LiveData<List<IdCardModel>> getAllIdCards(){
        return allIdCards;
    }

    //For Passport Table
    public void insertPassport(PassportModel passport){
        passRepository.insertPassport(passport);
    }

    public void updatePassport(PassportModel passport){
        passRepository.updatePassport(passport);
    }

    public void deletePassport(PassportModel passport){
        passRepository.deletePassport(passport);
    }

    public LiveData<List<PassportModel>> getAllPassports(){
        return allPassports;
    }

    //For Social table
    public void insertSocial(SocialModel social){
        passRepository.insertSocial(social);
    }

    public void updateSocial(SocialModel social){
        passRepository.updateSocial(social);
    }

    public void deleteSocial(SocialModel social){
        passRepository.deleteSocial(social);
    }

    public LiveData<List<SocialModel>> getAllSocials(){
        return allSocials;
    }

    //For Tax table
    public void insertTax(TaxModel tax){
        passRepository.insertTax(tax);
    }

    public void updateTax(TaxModel tax){
        passRepository.updateTax(tax);
    }

    public void deleteTax(TaxModel tax){
        passRepository.deleteTax(tax);
    }

    public LiveData<List<TaxModel>> getAllTaxes(){
        return allTaxes;
    }

}
