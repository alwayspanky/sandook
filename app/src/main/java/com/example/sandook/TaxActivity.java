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

public class TaxActivity extends AppCompatActivity {

    public static final String EXTRA_T_ID = "com.example.sandook.EXTRA_T_ID";
    public static final String EXTRA_T_NAME = "com.example.sandook.EXTRA_T_NAME";
    public static final String EXTRA_T_COUNTRY = "com.example.sandook.EXTRA_T_COUNTRY";
    public static final String EXTRA_T_NUMBER = "com.example.sandook.EXTRA_T_NUMBER";

    Toolbar toolbar;
    private EditText name, number;
    private Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax);

        name = findViewById(R.id.txtTaxName);
        country = findViewById(R.id.CountryTaxSpinner);
        number = findViewById(R.id.txtTaxIdNumber);

        toolbar = findViewById(R.id.taxToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_T_ID)){
            setTitle("Edit Tax Number");
            name.setText(intent.getStringExtra(EXTRA_T_NAME));
            //country.setSelection(Integer.parseInt(intent.getStringExtra(EXTRA_T_COUNTRY)));
            number.setText(intent.getStringExtra(EXTRA_T_NUMBER));

        }else{
            setTitle("Tax Number");
        }
    }

    private void saveTax() {

        String tName = name.getText().toString();
        String tCountry = country.getSelectedItem().toString();
        String tNumber = number.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_T_NAME,tName);
        data.putExtra(EXTRA_T_COUNTRY,tCountry);
        data.putExtra(EXTRA_T_NUMBER,tNumber);

        int id = getIntent().getIntExtra(EXTRA_T_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_T_ID,id);
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
                saveTax();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
