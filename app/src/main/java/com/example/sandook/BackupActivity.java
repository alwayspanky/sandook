package com.example.sandook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.RoomDatabase;


import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackupActivity extends AppCompatActivity {

    public static final String PACKAGE_NAME = "com.example.sandook";
    public static final String DATABASE_NAME = "sandook_db";
    public static final String TABLE_NAME = "orgs_table";
    private static final String DATABASE_PATH = "/data/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME;
    private static final File DATA_DIRECTORY_DATABASE =
            new File(Environment.getDataDirectory() + "/data/" + PACKAGE_NAME + "/databases/" + DATABASE_NAME);

    Toolbar toolbar;
    private Button bckupBtn, restoreBtn;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        bckupBtn = findViewById(R.id.btn_backup);
        restoreBtn = findViewById(R.id.btn_restore);

        toolbar = findViewById(R.id.backupToolbar);

        setSupportActionBar(toolbar);
        setTitle("Backup & Restore");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bckupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Backup","button Clicked");
                ExportDB("sandook_db.db",PACKAGE_NAME,"/sandookDb");
            }
        });

        restoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Restore","button Clicked");
              // restore();
            }
        });
    }

    public Boolean ExportDB(String DATABASE_NAME, String packageName, String folderName){
        //DATABASE_NAME including ".db" at the end like "mayApp.db"
        String DBName = DATABASE_NAME.substring(0, DATABASE_NAME.length() - 3);
        File data = Environment.getDataDirectory();
        FileChannel source=null;
        FileChannel destination=null;
        String currentDBPath = "/data/"+"/data/"+ packageName +"/databases/"+DATABASE_NAME;// getting app db path

        File sd = getFilesDir(); // getting phone SD card path
        String backupPath = sd.getAbsolutePath() + folderName; // if you want to set backup in specific folder name
        /* be careful , foldername must initial like this : "/myFolder" . dont forget "/" at begin of folder name
            you could define foldername like this : "/myOutterFolder/MyInnerFolder" and so on ...
        */
        File dir = new File(backupPath);
        if(!dir.exists()) // if there was no folder at this path , it create it .
        {
            dir.mkdirs();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        /* use date including file name for arrange them and preventing to make file with the same*/
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(backupPath, DBName +"("+ dateFormat.format(date)+").db");
        try {
            if (currentDB.exists() && !backupDB.exists()) {
                source = new FileInputStream(currentDB).getChannel();
                destination = new FileOutputStream(backupDB).getChannel();
                destination.transferFrom(source, 0, source.size());
                source.close();
                destination.close();
                Log.i("database","exported successfully");
                Toast.makeText(BackupActivity.this,"Database Backup successfully",Toast.LENGTH_SHORT).show();
                return true;

            }
            return false;
        } catch(IOException e) {
            e.printStackTrace();
            Log.e("database error", String.valueOf(e));
            return false;
        }
    }


    public void restore() {
        try {
            File sd = getFilesDir();
            //File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "/data/data/com.example.sandook/databases/sandook_db.db";
                String backupDBPath = "sandook_db.db";
                File currentDB = new File( currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(backupDB).getChannel();
                    FileChannel dst = new FileOutputStream(currentDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();

                    Toast.makeText(BackupActivity.this, "Database Restored successfully", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
