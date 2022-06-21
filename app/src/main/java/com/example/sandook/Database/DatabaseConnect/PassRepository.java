package com.example.sandook.Database.DatabaseConnect;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sandook.Database.Dao.PassDAO;
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

public class PassRepository {

    private PassDAO passDAO;
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


    public PassRepository(Application application){

        PassDatabase database = PassDatabase.getInstance(application);
        passDAO = database.passDAO();
        allPass = passDAO.getAll();
        allNotes = passDAO.getAllNotes();
        allBanks = passDAO.getAllBanks();
        allCredits = passDAO.getAllCredit();
        allDebits = passDAO.getAllDebit();
        allDrivings = passDAO.getAllDriving();
        allIdCards = passDAO.getAllIdCards();
        allPassports = passDAO.getAllPassport();
        allSocials = passDAO.getAllSocial();
        allTaxes = passDAO.getAllTax();

    }

    //For Notes Table

    public void insert(PassModel pass)
    {
        new InsertPassAsyncTask(passDAO).execute(pass);
    }

    public void update(PassModel pass){
        new UpdatePassAsyncTask(passDAO).execute(pass);
    }

    public void delete(PassModel pass){
        new DeletePassAsyncTask(passDAO).execute(pass);
    }

    public LiveData<List<PassModel>> getAll(){
        return allPass;
    }



    private static class InsertPassAsyncTask extends AsyncTask<PassModel, Void, Void>{

        private PassDAO passDAO;

        private InsertPassAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassModel... passModels) {
            passDAO.insert(passModels[0]);
            return null;
        }
    }

    private static class UpdatePassAsyncTask extends AsyncTask<PassModel, Void, Void>{

        private PassDAO passDAO;

        private UpdatePassAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassModel... passModels) {
            passDAO.update(passModels[0]);
            return null;
        }
    }

    private static class DeletePassAsyncTask extends AsyncTask<PassModel, Void, Void>{

        private PassDAO passDAO;

        private DeletePassAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassModel... passModels) {
            passDAO.delete(passModels[0]);
            return null;
        }
    }

    //For Notes Table

    public void insertNote(noteModel note){
        new InsertNoteAsyncTask(passDAO).execute(note);
    }

    public void updateNote(noteModel note){
        new UpdateNoteAsyncTask(passDAO).execute(note);
    }

    public void deleteNote(noteModel note){
        new DeleteNoteAsyncTask(passDAO).execute(note);
    }

    public LiveData<List<noteModel>> getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<noteModel,Void, Void>{

        private PassDAO passDAO;

        private InsertNoteAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(noteModel... noteModels) {
            passDAO.insertNote(noteModels[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<noteModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateNoteAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(noteModel... noteModels) {
            passDAO.updateNote(noteModels[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<noteModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteNoteAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(noteModel... noteModels) {
            passDAO.deleteNote(noteModels[0]);
            return null;
        }
    }

    //For Bank table

    public void insertBank(BankModel bank){
        new InsertBankAsyncTask(passDAO).execute(bank);
    }

    public void updateBank(BankModel bank){
        new UpdateBankAsyncTask(passDAO).execute(bank);
    }

    public void deleteBank(BankModel bank){
        new DeleteBankAsyncTask(passDAO).execute(bank);
    }

    public LiveData<List<BankModel>> getAllBank(){
        return allBanks;
    }

    private static class InsertBankAsyncTask extends AsyncTask<BankModel,Void, Void>{

        private PassDAO passDAO;

        private InsertBankAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(BankModel... bankModels) {
            passDAO.insertBank(bankModels[0]);
            return null;
        }

    }

    private static class UpdateBankAsyncTask extends AsyncTask<BankModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateBankAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(BankModel... bankModels) {
            passDAO.updateBank(bankModels[0]);
            return null;
        }
    }

    private static class DeleteBankAsyncTask extends AsyncTask<BankModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteBankAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(BankModel... bankModels) {
            passDAO.deleteBank(bankModels[0]);
            return null;
        }
    }

    //For Credit table

    public void insertCredit(CreditModel credit){
        new InsertCreditAsyncTask(passDAO).execute(credit);
    }

    public void updateCredit(CreditModel credit){
        new UpdateCreditAsyncTask(passDAO).execute(credit);
    }

    public void deleteCredit(CreditModel credit){
        new DeleteCreditAsyncTask(passDAO).execute(credit);
    }

    public LiveData<List<CreditModel>> getAllCredit(){
        return allCredits;
    }

    private static class InsertCreditAsyncTask extends AsyncTask<CreditModel,Void, Void>{

        private PassDAO passDAO;

        private InsertCreditAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(CreditModel... creditModels) {
            passDAO.insertCredit(creditModels[0]);
            return null;
        }
    }

    private static class UpdateCreditAsyncTask extends AsyncTask<CreditModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateCreditAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(CreditModel... creditModels) {
            passDAO.updateCredit(creditModels[0]);
            return null;
        }
    }

    private static class DeleteCreditAsyncTask extends AsyncTask<CreditModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteCreditAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(CreditModel... creditModels) {
            passDAO.deleteCredit(creditModels[0]);
            return null;
        }
    }

    //For Debit Table

    public void insertDebit(DebitModel debit){
        new InsertDebitAsyncTask(passDAO).execute(debit);
    }

    public void updateDebit(DebitModel debit){
        new UpdateDebitAsyncTask(passDAO).execute(debit);
    }

    public void deleteDebit(DebitModel debit){
        new DeleteDebitAsyncTask(passDAO).execute(debit);
    }

    public LiveData<List<DebitModel>> getAllDebit(){
        return allDebits;
    }

    private static class InsertDebitAsyncTask extends AsyncTask<DebitModel,Void, Void>{

        private PassDAO passDAO;

        private InsertDebitAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DebitModel... debitModels) {
            passDAO.insertDebit(debitModels[0]);
            return null;
        }
    }

    private static class UpdateDebitAsyncTask extends AsyncTask<DebitModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateDebitAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DebitModel... debitModels) {
            passDAO.updateDebit(debitModels[0]);
            return null;
        }
    }

    private static class DeleteDebitAsyncTask extends AsyncTask<DebitModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteDebitAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DebitModel... debitModels) {
            passDAO.deleteDebit(debitModels[0]);
            return null;
        }
    }

    //For Driving Table

    public void insertDriving(DrivingModel driving){
        new InsertDrivingAsyncTask(passDAO).execute(driving);
    }

    public void updateDriving(DrivingModel driving){
        new UpdateDrivingAsyncTask(passDAO).execute(driving);
    }

    public void deleteDriving(DrivingModel driving){
        new DeleteDrivingAsyncTask(passDAO).execute(driving);
    }

    public LiveData<List<DrivingModel>> getAllDriving(){
        return allDrivings;
    }

    private static class InsertDrivingAsyncTask extends AsyncTask<DrivingModel,Void, Void>{

        private PassDAO passDAO;

        private InsertDrivingAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DrivingModel... drivingModels) {
            passDAO.insertDriving(drivingModels[0]);
            return null;
        }
    }

    private static class UpdateDrivingAsyncTask extends AsyncTask<DrivingModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateDrivingAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DrivingModel... drivingModels) {
            passDAO.updateDriving(drivingModels[0]);
            return null;
        }
    }

    private static class DeleteDrivingAsyncTask extends AsyncTask<DrivingModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteDrivingAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(DrivingModel... drivingModels) {
            passDAO.deleteDriving(drivingModels[0]);
            return null;
        }
    }

    //For Id Card Table

    public void insertIdCard(IdCardModel idCardModel){
        new InsertIdCardAsyncTask(passDAO).execute(idCardModel);
    }

    public void updateIdCard(IdCardModel idCardModel){
        new UpdateIdCardAsyncTask(passDAO).execute(idCardModel);
    }

    public void deleteIdCard(IdCardModel idCardModel){
        new DeleteIdCardAsyncTask(passDAO).execute(idCardModel);
    }

    public LiveData<List<IdCardModel>> getAllIdCard(){
        return allIdCards;
    }

    private static class InsertIdCardAsyncTask extends AsyncTask<IdCardModel,Void, Void>{

        private PassDAO passDAO;

        private InsertIdCardAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(IdCardModel... idCardModels) {
            passDAO.insertIdCard(idCardModels[0]);
            return null;
        }
    }

    private static class UpdateIdCardAsyncTask extends AsyncTask<IdCardModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateIdCardAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(IdCardModel... idCardModels) {
            passDAO.updateIdCard(idCardModels[0]);
            return null;
        }
    }

    private static class DeleteIdCardAsyncTask extends AsyncTask<IdCardModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteIdCardAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(IdCardModel... idCardModels) {
            passDAO.deleteIdCard(idCardModels[0]);
            return null;
        }
    }

    //For Passport Table

    public void insertPassport(PassportModel passportModel){
        new InsertPassportAsyncTask(passDAO).execute(passportModel);
    }

    public void updatePassport(PassportModel passportModel){
        new UpdatePassportAsyncTask(passDAO).execute(passportModel);
    }

    public void deletePassport(PassportModel passportModel){
        new DeletePassportAsyncTask(passDAO).execute(passportModel);
    }

    public LiveData<List<PassportModel>> getAllPassport(){
        return allPassports;
    }

    private static class InsertPassportAsyncTask extends AsyncTask<PassportModel,Void, Void>{

        private PassDAO passDAO;

        private InsertPassportAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassportModel... passportModels) {
            passDAO.insertPassport(passportModels[0]);
            return null;
        }
    }

    private static class UpdatePassportAsyncTask extends AsyncTask<PassportModel,Void, Void>{

        private PassDAO passDAO;

        private UpdatePassportAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassportModel... passportModels) {
            passDAO.updatePassport(passportModels[0]);
            return null;
        }
    }

    private static class DeletePassportAsyncTask extends AsyncTask<PassportModel,Void, Void>{

        private PassDAO passDAO;

        private DeletePassportAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(PassportModel... passportModels) {
            passDAO.deletePassport(passportModels[0]);
            return null;
        }
    }

    //For Social Table

    public void insertSocial(SocialModel socialModel){
        new InsertSocialAsyncTask(passDAO).execute(socialModel);
    }

    public void updateSocial(SocialModel socialModel){
        new UpdateSocialAsyncTask(passDAO).execute(socialModel);
    }

    public void deleteSocial(SocialModel socialModel){
        new DeleteSocialAsyncTask(passDAO).execute(socialModel);
    }

    public LiveData<List<SocialModel>> getAllSocial(){
        return allSocials;
    }

    private static class InsertSocialAsyncTask extends AsyncTask<SocialModel,Void, Void>{

        private PassDAO passDAO;

        private InsertSocialAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(SocialModel... socialModels) {
            passDAO.insertSocial(socialModels[0]);
            return null;
        }
    }

    private static class UpdateSocialAsyncTask extends AsyncTask<SocialModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateSocialAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(SocialModel... socialModels) {
            passDAO.updateSocial(socialModels[0]);
            return null;
        }
    }

    private static class DeleteSocialAsyncTask extends AsyncTask<SocialModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteSocialAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(SocialModel... socialModels) {
            passDAO.deleteSocial(socialModels[0]);
            return null;
        }
    }

    //For Tax Table

    public void insertTax(TaxModel taxModel){
        new InsertTaxAsyncTask(passDAO).execute(taxModel);
    }

    public void updateTax(TaxModel taxModel){
        new UpdateTaxAsyncTask(passDAO).execute(taxModel);
    }

    public void deleteTax(TaxModel taxModel){
        new DeleteTaxAsyncTask(passDAO).execute(taxModel);
    }

    public LiveData<List<TaxModel>> getAllTax(){
        return allTaxes;
    }

    private static class InsertTaxAsyncTask extends AsyncTask<TaxModel,Void, Void>{

        private PassDAO passDAO;

        private InsertTaxAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(TaxModel... taxModels) {
            passDAO.insertTax(taxModels[0]);
            return null;
        }
    }

    private static class UpdateTaxAsyncTask extends AsyncTask<TaxModel,Void, Void>{

        private PassDAO passDAO;

        private UpdateTaxAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(TaxModel... taxModels) {
            passDAO.updateTax(taxModels[0]);
            return null;
        }
    }

    private static class DeleteTaxAsyncTask extends AsyncTask<TaxModel,Void, Void>{

        private PassDAO passDAO;

        private DeleteTaxAsyncTask(PassDAO passDAO)
        {
            this.passDAO = passDAO;
        }
        @Override
        protected Void doInBackground(TaxModel... taxModels) {
            passDAO.deleteTax(taxModels[0]);
            return null;
        }
    }


}
