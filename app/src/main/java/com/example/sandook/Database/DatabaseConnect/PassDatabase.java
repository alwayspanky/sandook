package com.example.sandook.Database.DatabaseConnect;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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

@Database(entities = {PassModel.class, noteModel.class, BankModel.class, CreditModel.class, DebitModel.class,
        DrivingModel.class, IdCardModel.class, PassportModel.class, SocialModel.class, TaxModel.class}, version = 1)
public abstract class PassDatabase extends RoomDatabase {

    private static PassDatabase instance;

    public abstract PassDAO passDAO();

    public static synchronized PassDatabase getInstance(Context context){

        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PassDatabase.class,"sandook_db.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }




}
