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

public class IdCardActivity extends AppCompatActivity {

    public static final String EXTRA_I_ID = "com.example.sandook.EXTRA_I_ID";
    public static final String EXTRA_I_NAME = "com.example.sandook.EXTRA_I_NAME";
    public static final String EXTRA_I_GENDER = "com.example.sandook.EXTRA_I_GENDER";
    public static final String EXTRA_I_DOB = "com.example.sandook.EXTRA_I_DOB";
    public static final String EXTRA_I_COUNTRY = "com.example.sandook.EXTRA_I_COUNTRY";
    public static final String EXTRA_I_NUMBER = "com.example.sandook.EXTRA_I_NUMBER";
    public static final String EXTRA_I_ISSUEDATE = "com.example.sandook.EXTRA_I_ISSUEDATE";
    public static final String EXTRA_I_EXPRY = "com.example.sandook.EXTRA_I_EXPRY";
    public static final String EXTRA_I_ADDRESS = "com.example.sandook.EXTRA_I_ADDRESS";


    Toolbar toolbar;
    private EditText name, dob, number, issueDate, expirationDate, address;
    private Spinner gender,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);

        name = findViewById(R.id.txtIdName);
        gender = findViewById(R.id.idGenderSpinner);
        dob = findViewById(R.id.txtIdDob);
        country = findViewById(R.id.idCountrySpinner);
        number = findViewById(R.id.txtIdNumber);
        issueDate = findViewById(R.id.txtIdIssue);
        expirationDate = findViewById(R.id.txtIdExpiration);
        address = findViewById(R.id.txtIdAddress);


        toolbar = findViewById(R.id.idCardToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_I_ID)){
            setTitle("Edit ID Cards");
            name.setText(intent.getStringExtra(EXTRA_I_NAME));
            //gender.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_I_GENDER)));
            dob.setText(intent.getStringExtra(EXTRA_I_DOB));
            //country.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_I_COUNTRY)));
            number.setText(intent.getStringExtra(EXTRA_I_NUMBER));
            issueDate.setText(intent.getStringExtra(EXTRA_I_ISSUEDATE));
            expirationDate.setText(intent.getStringExtra(EXTRA_I_EXPRY));
            address.setText(intent.getStringExtra(EXTRA_I_ADDRESS));
        }
        else{
            setTitle("ID Cards");
        }
    }

    private void saveIdCard() {

        String iName = name.getText().toString();
        String iGender = gender.getSelectedItem().toString();
        String iDob = dob.getText().toString();
        String iCountry = country.getSelectedItem().toString();
        String iNumber = number.getText().toString();
        String iIssueDate = issueDate.getText().toString();
        String iExpirationDate = expirationDate.getText().toString();
        String iAddress = address.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_I_NAME,iName);
        data.putExtra(EXTRA_I_GENDER,iGender);
        data.putExtra(EXTRA_I_DOB,iDob);
        data.putExtra(EXTRA_I_COUNTRY,iCountry);
        data.putExtra(EXTRA_I_NUMBER,iNumber);
        data.putExtra(EXTRA_I_ISSUEDATE,iIssueDate);
        data.putExtra(EXTRA_I_EXPRY,iExpirationDate);
        data.putExtra(EXTRA_I_ADDRESS,iAddress);

        int id = getIntent().getIntExtra(EXTRA_I_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_I_ID,id);
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
                saveIdCard();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
