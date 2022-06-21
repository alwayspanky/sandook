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

import com.google.android.material.textfield.TextInputEditText;

public class SocialSecurityActivity extends AppCompatActivity {

    public static final String EXTRA_S_ID = "com.example.sandook.EXTRA_S_ID";
    public static final String EXTRA_S_NAME = "com.example.sandook.EXTRA_S_NAME";
    public static final String EXTRA_S_GENDER = "com.example.sandook.EXTRA_S_GENDER";
    public static final String EXTRA_S_DOB = "com.example.sandook.EXTRA_S_DOB";
    public static final String EXTRA_S_COUNTRY = "com.example.sandook.EXTRA_S_COUNTRY";
    public static final String EXTRA_S_NUMBER = "com.example.sandook.EXTRA_S_NUMBER";

    Toolbar toolbar;
    private EditText name, dob ;
    private TextInputEditText number;
    private Spinner gender,country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_security);

        name = findViewById(R.id.txtSocialName);
        gender = findViewById(R.id.genderSocialSpinner);
        dob = findViewById(R.id.txtSocialDob);
        country = findViewById(R.id.CountrySocialSpinner);
        number = findViewById(R.id.txtSocialNumber);

        toolbar = findViewById(R.id.socialToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_S_ID)){
            setTitle("Edit Social Security");
            name.setText(intent.getStringExtra(EXTRA_S_NAME));
            //gender.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_S_GENDER)));
            dob.setText(intent.getStringExtra(EXTRA_S_DOB));
            //country.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_S_COUNTRY)));
            number.setText(intent.getStringExtra(EXTRA_S_NUMBER));

        }else{
            setTitle("Social Security");
        }
    }

    private void saveSocial() {

        String sName = name.getText().toString();
        String sGender = gender.getSelectedItem().toString();
        String sDob = dob.getText().toString();
        String sCountry = country.getSelectedItem().toString();
        String sNumber = number.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_S_NAME,sName);
        data.putExtra(EXTRA_S_GENDER,sGender);
        data.putExtra(EXTRA_S_DOB,sDob);
        data.putExtra(EXTRA_S_COUNTRY,sCountry);
        data.putExtra(EXTRA_S_NUMBER,sNumber);

        int id = getIntent().getIntExtra(EXTRA_S_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_S_ID,id);
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
                saveSocial();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
