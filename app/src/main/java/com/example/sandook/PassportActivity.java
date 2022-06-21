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

public class PassportActivity extends AppCompatActivity {

    public static final String EXTRA_P_ID = "com.example.sandook.EXTRA_P_ID";
    public static final String EXTRA_P_NAME = "com.example.sandook.EXTRA_P_NAME";
    public static final String EXTRA_P_GENDER = "com.example.sandook.EXTRA_P_GENDER";
    public static final String EXTRA_P_DOB = "com.example.sandook.EXTRA_P_DOB";
    public static final String EXTRA_P_COUNTRY = "com.example.sandook.EXTRA_P_COUNTRY";
    public static final String EXTRA_P_NUMBER = "com.example.sandook.EXTRA_P_NUMBER";
    public static final String EXTRA_P_ISSUEDATE = "com.example.sandook.EXTRA_P_ISSUEDATE";
    public static final String EXTRA_P_EXPRY = "com.example.sandook.EXTRA_P_EXPRY";
    public static final String EXTRA_P_PLACE = "com.example.sandook.EXTRA_P_PLACE";

    Toolbar toolbar;
    private EditText name, dob, number, issueDate, expirationDate, placeIssue;
    private Spinner gender,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);

        name = findViewById(R.id.txtPassName);
        gender = findViewById(R.id.genderPassSpinner);
        dob = findViewById(R.id.txtPassDob);
        country = findViewById(R.id.CountryPassSpinner);
        number = findViewById(R.id.txtPassNumber);
        issueDate = findViewById(R.id.txtPassIssue);
        expirationDate = findViewById(R.id.txtPassExpiration);
        placeIssue = findViewById(R.id.txtPassPlace);

        toolbar = findViewById(R.id.passportToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_P_ID)){
            setTitle("Edit Passport");
            name.setText(intent.getStringExtra(EXTRA_P_NAME));
            //gender.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_P_GENDER)));
            dob.setText(intent.getStringExtra(EXTRA_P_DOB));
            //country.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_P_COUNTRY)));
            number.setText(intent.getStringExtra(EXTRA_P_NUMBER));
            issueDate.setText(intent.getStringExtra(EXTRA_P_ISSUEDATE));
            expirationDate.setText(intent.getStringExtra(EXTRA_P_EXPRY));
            placeIssue.setText(intent.getStringExtra(EXTRA_P_PLACE));

        }else {
            setTitle("Passport");
        }
    }

    private void savePassport() {
        String passName = name.getText().toString();
        String passGender = gender.getSelectedItem().toString();
        String passDob = dob.getText().toString();
        String passCountry = country.getSelectedItem().toString();
        String passNumber = number.getText().toString();
        String passIssueDate = issueDate.getText().toString();
        String passExpirationDate = expirationDate.getText().toString();
        String passPlace = placeIssue.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_P_NAME,passName);
        data.putExtra(EXTRA_P_GENDER,passGender);
        data.putExtra(EXTRA_P_DOB,passDob);
        data.putExtra(EXTRA_P_COUNTRY,passCountry);
        data.putExtra(EXTRA_P_NUMBER,passNumber);
        data.putExtra(EXTRA_P_ISSUEDATE,passIssueDate);
        data.putExtra(EXTRA_P_EXPRY,passExpirationDate);
        data.putExtra(EXTRA_P_PLACE,passPlace);

        int id = getIntent().getIntExtra(EXTRA_P_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_P_ID,id);
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
                savePassport();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
