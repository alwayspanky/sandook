package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class BankAccountActivity extends AppCompatActivity {

    public static final String EXTRA_B_ID = "com.example.sandook.EXTRA_B_ID";
    public static final String EXTRA_B_NAME ="com.example.sandook.EXTRA_B_NAME";
    public static final String EXTRA_B_BANK ="com.example.sandook.EXTRA_B_BANK";
    public static final String EXTRA_B_HOLDER ="com.example.sandook.EXTRA_B_HOLDER";
    public static final String EXTRA_B_NUMBER ="com.example.sandook.EXTRA_B_NUMBER";
    public static final String EXTRA_B_BIC ="com.example.sandook.EXTRA_B_BIC";
    public static final String EXTRA_B_IBAN ="com.example.sandook.EXTRA_B_IBAN";
    public static final String EXTRA_B_IFSC ="com.example.sandook.EXTRA_B_IFSC";

    Toolbar toolbar;
    private EditText bankName, accountHolder,  name ;
    private TextInputEditText acNo, ifsc, iban, bic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account);

        name = findViewById(R.id.txtBankName);
        bankName = findViewById(R.id.txtBName);
        accountHolder = findViewById(R.id.txtBankHolder);
        acNo = findViewById(R.id.txtBankAc);
        ifsc = findViewById(R.id.txtBankIfsc);
        iban = findViewById(R.id.txtBankIban);
        bic = findViewById(R.id.txtBankBic);

        toolbar = findViewById(R.id.bankToolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_B_ID)){
            setTitle("Edit Bank Account");
            name.setText(intent.getStringExtra(EXTRA_B_NAME));
            bankName.setText(intent.getStringExtra(EXTRA_B_BANK));
            accountHolder.setText(intent.getStringExtra(EXTRA_B_HOLDER));
            acNo.setText(intent.getStringExtra(EXTRA_B_NUMBER));
            ifsc.setText(intent.getStringExtra(EXTRA_B_IFSC));
            iban.setText(intent.getStringExtra(EXTRA_B_IBAN));
            bic.setText(intent.getStringExtra(EXTRA_B_BIC));
        }else {
            setTitle("Bank Account");
        }
    }

    private void saveBank() {

        String bName = name.getText().toString();
        String bBankName = bankName.getText().toString();
        String bAccountHolder = accountHolder.getText().toString();
        String bAcNo = acNo.getText().toString();
        String bIfsc = ifsc.getText().toString();
        String bIban = iban.getText().toString();
        String bBic = bic.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_B_NAME,bName);
        data.putExtra(EXTRA_B_BANK,bBankName);
        data.putExtra(EXTRA_B_HOLDER,bAccountHolder);
        data.putExtra(EXTRA_B_NUMBER,bAcNo);
        data.putExtra(EXTRA_B_IFSC,bIfsc);
        data.putExtra(EXTRA_B_IBAN,bIban);
        data.putExtra(EXTRA_B_BIC,bBic);

        int id = getIntent().getIntExtra(EXTRA_B_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_B_ID,id);
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
                saveBank();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
