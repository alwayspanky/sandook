package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sandook.Adapter.BankAdapter;
import com.example.sandook.Adapter.CreditAdapter;
import com.example.sandook.Adapter.DebitAdapter;
import com.example.sandook.Database.Model.BankModel;
import com.example.sandook.Database.Model.CreditModel;
import com.example.sandook.Database.Model.DebitModel;
import com.example.sandook.Database.PassViewModel;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PaymentActivity extends AppCompatActivity {

    public static final int ADD_BANK_REQUEST_CODE = 1;
    public static final int ADD_CREDIT_REQUEST_CODE = 2;
    public static final int ADD_DEBIT_REQUEST_CODE = 3;
    public static final int EDIT_BANK_REQUEST_CODE = 4;
    public static final int EDIT_CREDIT_REQUEST_CODE = 5;
    public static final int EDIT_DEBIT_REQUEST_CODE = 6;


    Toolbar toolbar;
    FloatingActionButton btnFab1, btnFab2, btnFab3;
    PassViewModel passViewModel;
    RecyclerView recyclerViewBank, recyclerViewCredit, recyclerViewDebit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnFab1 = findViewById(R.id.fab1);
        btnFab2 = findViewById(R.id.fab2);
        btnFab3 = findViewById(R.id.fab3);

        btnFab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent debitIntent = new Intent(PaymentActivity.this, DebitCardActivity.class);
                startActivityForResult(debitIntent,ADD_DEBIT_REQUEST_CODE);
            }
        });

        btnFab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creditIntent = new Intent(PaymentActivity.this, CreditCardActivity.class);
                startActivityForResult(creditIntent,ADD_CREDIT_REQUEST_CODE);
            }
        });

        btnFab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bankIntent = new Intent(PaymentActivity.this, BankAccountActivity.class);
                startActivityForResult(bankIntent,ADD_BANK_REQUEST_CODE);
            }
        });

        toolbar = findViewById(R.id.paymentToolbar);

        setSupportActionBar(toolbar);
        setTitle("Payments");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewBank = findViewById(R.id.recycler_paymentBank);
        recyclerViewCredit = findViewById(R.id.recycler_paymentCredit);
        recyclerViewDebit = findViewById(R.id.recycler_paymentDebit);

        //Bank Model view
        recyclerViewBank.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBank.setHasFixedSize(true);
        final BankAdapter bankAdapter = new BankAdapter();
        recyclerViewBank.setAdapter(bankAdapter);
        passViewModel = new ViewModelProvider(PaymentActivity.this).get(PassViewModel.class);
        passViewModel.getAllBanks().observe(this, new Observer<List<BankModel>>() {
            @Override
            public void onChanged(List<BankModel> bankModels) {
                bankAdapter.setBanks(bankModels);
            }
        });

        bankAdapter.setOnItemclickListener(new BankAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(BankModel bankModel) {
                Intent bankIntent = new Intent(PaymentActivity.this,BankAccountActivity.class);
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_ID, bankModel.getId());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_NAME, bankModel.getbName());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_BANK, bankModel.getBankName());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_HOLDER, bankModel.getbAcHolder());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_NUMBER, bankModel.getbAc());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_IFSC, bankModel.getbIfsc());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_IBAN, bankModel.getbIban());
                bankIntent.putExtra(BankAccountActivity.EXTRA_B_BIC, bankModel.getbBic());
                startActivityForResult(bankIntent,EDIT_BANK_REQUEST_CODE);
            }
        });

        //Credit Model view
        recyclerViewCredit.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCredit.setHasFixedSize(true);
        final CreditAdapter creditAdapter = new CreditAdapter();
        recyclerViewCredit.setAdapter(creditAdapter);
        passViewModel.getAllCredits().observe(this, new Observer<List<CreditModel>>() {
            @Override
            public void onChanged(List<CreditModel> creditModels) {
                creditAdapter.setCredits(creditModels);
            }
        });

        creditAdapter.setOnItemclickListener(new CreditAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(CreditModel creditModel) {
                Intent creditIntent = new Intent(PaymentActivity.this,CreditCardActivity.class);
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_ID,creditModel.getId());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_BANK,creditModel.getcBank());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_HOLDER,creditModel.getcAcHolder());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_CARD,creditModel.getcNumber());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_SECURITY,creditModel.getcSecurity());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_CVV,creditModel.getcCvv());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_EXP,creditModel.getcExpiration());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_NAME,creditModel.getcName());
                creditIntent.putExtra(CreditCardActivity.EXTRA_C_ADDRESS,creditModel.getcAddress());
                startActivityForResult(creditIntent,EDIT_CREDIT_REQUEST_CODE);
            }
        });

        //Debit Model view
        recyclerViewDebit.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDebit.setHasFixedSize(true);
        final DebitAdapter debitAdapter = new DebitAdapter();
        recyclerViewDebit.setAdapter(debitAdapter);
        passViewModel.getAllDebits().observe(this, new Observer<List<DebitModel>>() {
            @Override
            public void onChanged(List<DebitModel> debitModels) {
                debitAdapter.setDebits(debitModels);
            }
        });

        debitAdapter.setOnItemclickListener(new DebitAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(DebitModel debitModel) {
                Intent debitIntent = new Intent(PaymentActivity.this,DebitCardActivity.class);
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_ID,debitModel.getId());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_BANK,debitModel.getdBank());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_HOLDER,debitModel.getdAcHolder());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_CARD,debitModel.getdNumber());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_SECURITY,debitModel.getdSecurity());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_CVV,debitModel.getdCvv());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_EXP,debitModel.getdExpiration());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_NAME,debitModel.getdName());
                debitIntent.putExtra(DebitCardActivity.EXTRA_D_ADDRESS,debitModel.getdAddress());
                startActivityForResult(debitIntent,EDIT_DEBIT_REQUEST_CODE);

            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                passViewModel.deleteBank(bankAdapter.getBankAt(viewHolder.getAdapterPosition()));
                passViewModel.deleteCredit(creditAdapter.getCreditAt(viewHolder.getAdapterPosition()));
                passViewModel.deleteDebit(debitAdapter.getDebitAt(viewHolder.getAdapterPosition()));
                Toast.makeText(PaymentActivity.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerViewBank);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_BANK_REQUEST_CODE && resultCode == RESULT_OK){
            String bName = data.getStringExtra(BankAccountActivity.EXTRA_B_NAME);
            String bBankName = data.getStringExtra(BankAccountActivity.EXTRA_B_BANK);
            String bAccountHolder = data.getStringExtra(BankAccountActivity.EXTRA_B_HOLDER);
            String bAcNo = data.getStringExtra(BankAccountActivity.EXTRA_B_NUMBER);
            String bIfsc = data.getStringExtra(BankAccountActivity.EXTRA_B_IFSC);
            String bIban = data.getStringExtra(BankAccountActivity.EXTRA_B_IBAN);
            String bBic = data.getStringExtra(BankAccountActivity.EXTRA_B_BIC);

            BankModel bankModel = new BankModel(bName,bBankName,bAccountHolder,bAcNo,bIfsc,bIban,bBic);
            passViewModel.insertBank(bankModel);

            Toast.makeText(this,"Bank inserted",Toast.LENGTH_SHORT).show();

        }else if(requestCode == EDIT_BANK_REQUEST_CODE && resultCode == RESULT_OK){
            int id = data.getIntExtra(BankAccountActivity.EXTRA_B_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String bName = data.getStringExtra(BankAccountActivity.EXTRA_B_NAME);
            String bBankName = data.getStringExtra(BankAccountActivity.EXTRA_B_BANK);
            String bAccountHolder = data.getStringExtra(BankAccountActivity.EXTRA_B_HOLDER);
            String bAcNo = data.getStringExtra(BankAccountActivity.EXTRA_B_NUMBER);
            String bIfsc = data.getStringExtra(BankAccountActivity.EXTRA_B_IFSC);
            String bIban = data.getStringExtra(BankAccountActivity.EXTRA_B_IBAN);
            String bBic = data.getStringExtra(BankAccountActivity.EXTRA_B_BIC);

            BankModel bankModel = new BankModel(bName,bBankName,bAccountHolder,bAcNo,bIfsc,bIban,bBic);
            bankModel.setId(id);
            passViewModel.updateBank(bankModel);

            Toast.makeText(this,"Bank updated",Toast.LENGTH_SHORT).show();


        }else if (requestCode == ADD_DEBIT_REQUEST_CODE && resultCode == RESULT_OK){

                String dBankName = data.getStringExtra(DebitCardActivity.EXTRA_D_BANK);
                String dAccountHolder = data.getStringExtra(DebitCardActivity.EXTRA_D_HOLDER);
                String dCardNo = data.getStringExtra(DebitCardActivity.EXTRA_D_CARD);
                String dSecurity = data.getStringExtra(DebitCardActivity.EXTRA_D_SECURITY);
                String dCVV = data.getStringExtra(DebitCardActivity.EXTRA_D_CVV);
                String dName = data.getStringExtra(DebitCardActivity.EXTRA_D_NAME);
                String dAddress = data.getStringExtra(DebitCardActivity.EXTRA_D_ADDRESS);
                String dExpDate = data.getStringExtra(DebitCardActivity.EXTRA_D_EXP);

                DebitModel debitModel = new DebitModel(dBankName,dAccountHolder,dCardNo,dSecurity,dCVV,dName,dAddress,dExpDate);
                passViewModel.insertDebit(debitModel);

                Toast.makeText(this,"Debit inserted",Toast.LENGTH_SHORT).show();

            }else if(requestCode == EDIT_DEBIT_REQUEST_CODE && resultCode == RESULT_OK) {
            int id = data.getIntExtra(DebitCardActivity.EXTRA_D_ID, -1);

            if(id == -1){
                Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String dBankName = data.getStringExtra(DebitCardActivity.EXTRA_D_BANK);
            String dAccountHolder = data.getStringExtra(DebitCardActivity.EXTRA_D_HOLDER);
            String dCardNo = data.getStringExtra(DebitCardActivity.EXTRA_D_CARD);
            String dSecurity = data.getStringExtra(DebitCardActivity.EXTRA_D_SECURITY);
            String dCVV = data.getStringExtra(DebitCardActivity.EXTRA_D_CVV);
            String dName = data.getStringExtra(DebitCardActivity.EXTRA_D_NAME);
            String dAddress = data.getStringExtra(DebitCardActivity.EXTRA_D_ADDRESS);
            String dExpDate = data.getStringExtra(DebitCardActivity.EXTRA_D_EXP);

            DebitModel debitModel = new DebitModel(dBankName,dAccountHolder,dCardNo,dSecurity,dCVV,dName,dAddress,dExpDate);
            debitModel.setId(id);
            passViewModel.updateDebit(debitModel);

            Toast.makeText(this,"Debit updated",Toast.LENGTH_SHORT).show();

        } else if(requestCode == ADD_CREDIT_REQUEST_CODE && resultCode == RESULT_OK){

                String cBankName = data.getStringExtra(CreditCardActivity.EXTRA_C_NAME);
                String cAccountHolder = data.getStringExtra(CreditCardActivity.EXTRA_C_HOLDER);
                String cCardNo = data.getStringExtra(CreditCardActivity.EXTRA_C_CARD);
                String cSecurity = data.getStringExtra(CreditCardActivity.EXTRA_C_SECURITY);
                String cCVV = data.getStringExtra(CreditCardActivity.EXTRA_C_CVV);
                String cName = data.getStringExtra(CreditCardActivity.EXTRA_C_NAME);
                String cAddress = data.getStringExtra(CreditCardActivity.EXTRA_C_ADDRESS);
                String cExpDate = data.getStringExtra(CreditCardActivity.EXTRA_C_EXP);

                CreditModel creditModel = new CreditModel(cBankName,cAccountHolder,cCardNo,cSecurity,cCVV,cName,cAddress,cExpDate);
                passViewModel.insertCredit(creditModel);

                Toast.makeText(this,"Credit inserted",Toast.LENGTH_SHORT).show();

            }else if(requestCode == EDIT_CREDIT_REQUEST_CODE && resultCode == RESULT_OK){
                int id = data.getIntExtra(CreditCardActivity.EXTRA_C_ID, -1);

                if(id == -1){
                    Toast.makeText(this,"can't be updated",Toast.LENGTH_SHORT).show();
                    return;
                }

            String cBankName = data.getStringExtra(CreditCardActivity.EXTRA_C_NAME);
            String cAccountHolder = data.getStringExtra(CreditCardActivity.EXTRA_C_HOLDER);
            String cCardNo = data.getStringExtra(CreditCardActivity.EXTRA_C_CARD);
            String cSecurity = data.getStringExtra(CreditCardActivity.EXTRA_C_SECURITY);
            String cCVV = data.getStringExtra(CreditCardActivity.EXTRA_C_CVV);
            String cName = data.getStringExtra(CreditCardActivity.EXTRA_C_NAME);
            String cAddress = data.getStringExtra(CreditCardActivity.EXTRA_C_ADDRESS);
            String cExpDate = data.getStringExtra(CreditCardActivity.EXTRA_C_EXP);

            CreditModel creditModel = new CreditModel(cBankName,cAccountHolder,cCardNo,cSecurity,cCVV,cName,cAddress,cExpDate);
            creditModel.setId(id);
            passViewModel.updateCredit(creditModel);

            Toast.makeText(this,"Credit updated",Toast.LENGTH_SHORT).show();
        }
        else {
                Toast.makeText(this,"Not saved",Toast.LENGTH_SHORT).show();
            }
        }


    }

