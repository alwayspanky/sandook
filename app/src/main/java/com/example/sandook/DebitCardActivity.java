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

public class DebitCardActivity extends AppCompatActivity {

    public static final String EXTRA_D_ID = "com.example.sandook.EXTRA_D_ID";
    public static final String EXTRA_D_BANK ="com.example.sandook.EXTRA_D_BANK";
    public static final String EXTRA_D_HOLDER ="com.example.sandook.EXTRA_D_HOLDER";
    public static final String EXTRA_D_CARD ="com.example.sandook.EXTRA_D_CARD";
    public static final String EXTRA_D_CVV ="com.example.sandook.EXTRA_D_CVV";
    public static final String EXTRA_D_SECURITY ="com.example.sandook.EXTRA_D_SECURITY";
    public static final String EXTRA_D_NAME ="com.example.sandook.EXTRA_D_NAME";
    public static final String EXTRA_D_ADDRESS ="com.example.sandook.EXTRA_D_ADDRESS";
    public static final String EXTRA_D_EXP ="com.example.sandook.EXTRA_D_EXP";

    Toolbar toolbar;
    private EditText bankName, accountHolder,  name, address, expDate;
    private TextInputEditText cardNo, securityCode, cvv;
    private DatePicker expirationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);

        bankName = findViewById(R.id.txtDBank);
        accountHolder = findViewById(R.id.txtDBankAc);
        cardNo = findViewById(R.id.txtDBankCard);
        securityCode = findViewById(R.id.txtDBankSecurity);
        cvv = findViewById(R.id.txtDBankCVV);
        name = findViewById(R.id.txtDBankName);
        address = findViewById(R.id.txtDBankAddress);
        expirationDate = findViewById(R.id.dtpDebitBank);
        expDate = findViewById(R.id.txtDdtp);

        toolbar = findViewById(R.id.debitToolbar);

        setSupportActionBar(toolbar);
        setTitle("Debit Card");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        if(intent.hasExtra(EXTRA_D_ID)){
            setTitle("Edit Debit Card");
            bankName.setText(intent.getStringExtra(EXTRA_D_BANK));
            accountHolder.setText(intent.getStringExtra(EXTRA_D_HOLDER));
            cardNo.setText(intent.getStringExtra(EXTRA_D_CARD));
            securityCode.setText(intent.getStringExtra(EXTRA_D_SECURITY));
            cvv.setText(intent.getStringExtra(EXTRA_D_CVV));
            name.setText(intent.getStringExtra(EXTRA_D_NAME));
            address.setText(intent.getStringExtra(EXTRA_D_ADDRESS));
            expDate.setText(intent.getStringExtra(EXTRA_D_EXP));

        }
        else {
            setTitle("Debit Card");
        }
    }

    private void saveDebit() {

        String dBankName = bankName.getText().toString();
        String dAccountHolder = accountHolder.getText().toString();
        String dCardNo = cardNo.getText().toString();
        String dSecurity = securityCode.getText().toString();
        String dCVV = cvv.getText().toString();
        String dName = name.getText().toString();
        String dAddress = address.getText().toString();
        String dExpDate = expDate.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_D_BANK,dBankName);
        data.putExtra(EXTRA_D_HOLDER,dAccountHolder);
        data.putExtra(EXTRA_D_CARD,dCardNo);
        data.putExtra(EXTRA_D_SECURITY,dSecurity);
        data.putExtra(EXTRA_D_CVV,dCVV);
        data.putExtra(EXTRA_D_EXP,dExpDate);
        data.putExtra(EXTRA_D_NAME,dName);
        data.putExtra(EXTRA_D_ADDRESS,dAddress);

        int id = getIntent().getIntExtra(EXTRA_D_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_D_ID,id);
        }

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_button,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveMenu:
                saveDebit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
