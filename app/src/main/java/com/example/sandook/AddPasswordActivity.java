package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sandook.Database.Model.PassModel;
import com.example.sandook.Database.PassViewModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class AddPasswordActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.sandook.EXTRA_ID";
    public static final String EXTRA_NAME =
            "com.example.sandook.EXTRA_NAME";
    public static final String EXTRA_LOGIN =
            "com.example.sandook.EXTRA_LOGIN";
    public static final String EXTRA_PASS =
            "com.example.sandook.EXTRA_PASS";
    public static final String EXTRA_WEBSITE =
            "com.example.sandook.EXTRA_WEBSITE";
    public static final String EXTRA_CATEGORY =
            "com.example.sandook.EXTRA_CATEGORY";
    public static final String EXTRA_NOTES =
            "com.example.sandook.EXTRA_NOTES";

    Toolbar toolbar;
    private EditText name, login, website, category, notes;
    private TextInputEditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);

        name = findViewById(R.id.txtName);
        login = findViewById(R.id.txtLogin);
        pass = findViewById(R.id.txtPass);
        website = findViewById(R.id.txtwebsite);
        category = findViewById(R.id.txtCategory);
        notes = findViewById(R.id.txtNotes);

        toolbar = findViewById(R.id.addPassToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Password");
            name.setText(intent.getStringExtra(EXTRA_NAME));
            login.setText(intent.getStringExtra(EXTRA_LOGIN));
            pass.setText(intent.getStringExtra(EXTRA_PASS));
            website.setText(intent.getStringExtra(EXTRA_WEBSITE));
            category.setText(intent.getStringExtra(EXTRA_CATEGORY));
            notes.setText(intent.getStringExtra(EXTRA_NOTES));
        }else {
            setTitle("Add Password");
        }


    }

    private void savePass() {
        String pName = name.getText().toString();
        String pLogin = login.getText().toString();
        String pPass = pass.getText().toString();
        String pWebsite = website.getText().toString();
        String pCategory = category.getText().toString();
        String pNotes = notes.getText().toString();

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, pName);
        data.putExtra(EXTRA_LOGIN, pLogin);
        data.putExtra(EXTRA_PASS, pPass);
        data.putExtra(EXTRA_WEBSITE, pWebsite);
        data.putExtra(EXTRA_CATEGORY, pCategory);
        data.putExtra(EXTRA_NOTES, pNotes);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1){
            data.putExtra(EXTRA_ID,id);
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
                savePass();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


}
