package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class CreditCardActivity extends AppCompatActivity {

    public static final String EXTRA_C_ID = "com.example.sandook.EXTRA_C_ID";
    public static final String EXTRA_C_BANK ="com.example.sandook.EXTRA_C_BANK";
    public static final String EXTRA_C_HOLDER ="com.example.sandook.EXTRA_C_HOLDER";
    public static final String EXTRA_C_CARD ="com.example.sandook.EXTRA_C_CARD";
    public static final String EXTRA_C_CVV ="com.example.sandook.EXTRA_C_CVV";
    public static final String EXTRA_C_SECURITY ="com.example.sandook.EXTRA_C_SECURITY";
    public static final String EXTRA_C_NAME ="com.example.sandook.EXTRA_C_NAME";
    public static final String EXTRA_C_ADDRESS ="com.example.sandook.EXTRA_C_ADDRESS";
    public static final String EXTRA_C_EXP ="com.example.sandook.EXTRA_C_EXP";

    Toolbar toolbar;
    private EditText bankName, accountHolder,  name, address, expDate;
    private TextInputEditText cardNo, securityCode, cvv;
    private DatePicker expirationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        bankName = findViewById(R.id.txtCBank);
        accountHolder = findViewById(R.id.txtCBankAc);
        cardNo = findViewById(R.id.txtCBankCard);
        securityCode = findViewById(R.id.txtCBankSecurity);
        cvv = findViewById(R.id.txtCBankCVV);
        name = findViewById(R.id.txtCBankName);
        address = findViewById(R.id.txtCBankAddress);
        expirationDate = findViewById(R.id.dtpCreditBank);
        expDate = findViewById(R.id.txtCdtp);

        toolbar = findViewById(R.id.creditToolbar);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_C_ID)){
            setTitle("Edit Credit Card");
            bankName.setText(intent.getStringExtra(EXTRA_C_BANK));
            accountHolder.setText(intent.getStringExtra(EXTRA_C_HOLDER));
            cardNo.setText(intent.getStringExtra(EXTRA_C_CARD));
            securityCode.setText(intent.getStringExtra(EXTRA_C_SECURITY));
            cvv.setText(intent.getStringExtra(EXTRA_C_CVV));
            name.setText(intent.getStringExtra(EXTRA_C_NAME));
            address.setText(intent.getStringExtra(EXTRA_C_ADDRESS));
            expDate.setText(intent.getStringExtra(EXTRA_C_EXP));

        }
        else {
            setTitle("Credit Card");
        }
    }

    private void saveCredit() {

        String cBankName = bankName.getText().toString();
        String cAccountHolder = accountHolder.getText().toString();
        String cCardNo = cardNo.getText().toString();
        String cSecurity = securityCode.getText().toString();
        String cCVV = cvv.getText().toString();
        String cName = name.getText().toString();
        String cAddress = address.getText().toString();
        String cExpDate = expDate.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_C_BANK,cBankName);
        data.putExtra(EXTRA_C_HOLDER,cAccountHolder);
        data.putExtra(EXTRA_C_CARD,cCardNo);
        data.putExtra(EXTRA_C_SECURITY,cSecurity);
        data.putExtra(EXTRA_C_CVV,cCVV);
        data.putExtra(EXTRA_C_EXP,cExpDate);
        data.putExtra(EXTRA_C_NAME,cName);
        data.putExtra(EXTRA_C_ADDRESS,cAddress);

        int id = getIntent().getIntExtra(EXTRA_C_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_C_ID,id);
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
                saveCredit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
