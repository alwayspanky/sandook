package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

public class DrivingActivity extends AppCompatActivity {

    public static final String EXTRA_DR_ID = "com.example.sandook.EXTRA_DR_ID";
    public static final String EXTRA_DR_NAME = "com.example.sandook.EXTRA_DR_NAME";
    public static final String EXTRA_DR_GENDER = "com.example.sandook.EXTRA_DR_GENDER";
    public static final String EXTRA_DR_DOB = "com.example.sandook.EXTRA_DR_DOB";
    public static final String EXTRA_DR_COUNTRY = "com.example.sandook.EXTRA_DR_COUNTRY";
    public static final String EXTRA_DR_NUMBER = "com.example.sandook.EXTRA_DR_NUMBER";
    public static final String EXTRA_DR_ISSUEDATE = "com.example.sandook.EXTRA_DR_ISSUEDATE";
    public static final String EXTRA_DR_EXPRY = "com.example.sandook.EXTRA_DR_EXPRY";

    Toolbar toolbar;
    private EditText name, dob, number, issueDate, expirationDate;
    private Spinner gender,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);

        name = findViewById(R.id.txtDriveName);
        gender = findViewById(R.id.genderDriveSpinner);
        dob = findViewById(R.id.txtDriveDob);
        country = findViewById(R.id.CountryDriveSpinner);
        number = findViewById(R.id.txtDriveNumber);
        issueDate = findViewById(R.id.txtDriveIssue);
        expirationDate = findViewById(R.id.txtDriveExpiration);


        toolbar = findViewById(R.id.driveToolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_DR_ID)){
            setTitle("Edit Driving License");
            name.setText(intent.getStringExtra(EXTRA_DR_NAME));
           // gender.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_DR_GENDER)));
            dob.setText(intent.getStringExtra(EXTRA_DR_DOB));
            //country.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_DR_COUNTRY)));
            number.setText(intent.getStringExtra(EXTRA_DR_NUMBER));
            issueDate.setText(intent.getStringExtra(EXTRA_DR_ISSUEDATE));
            expirationDate.setText(intent.getStringExtra(EXTRA_DR_EXPRY));
        }else{
            setTitle("Driving License");
        }
    }

    private void saveDrive() {

        String driveName = name.getText().toString();
        String driveGender = gender.getSelectedItem().toString();
        String driveDob = dob.getText().toString();
        String driveCountry = country.getSelectedItem().toString();
        String driveNumber = number.getText().toString();
        String driveIssueDate = issueDate.getText().toString();
        String driveExpirationDate = expirationDate.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_DR_NAME,driveName);
        data.putExtra(EXTRA_DR_GENDER,driveGender);
        data.putExtra(EXTRA_DR_DOB,driveDob);
        data.putExtra(EXTRA_DR_COUNTRY,driveCountry);
        data.putExtra(EXTRA_DR_NUMBER,driveNumber);
        data.putExtra(EXTRA_DR_ISSUEDATE,driveIssueDate);
        data.putExtra(EXTRA_DR_EXPRY,driveExpirationDate);

        int id = getIntent().getIntExtra(EXTRA_DR_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_DR_ID,id);
        }

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_button,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveMenu:
                saveDrive();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
