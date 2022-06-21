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
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.sandook.Adapter.PassAdapter;
import com.example.sandook.Database.Model.PassModel;
import com.example.sandook.Database.PassViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PassActivity extends AppCompatActivity {

    public static final int ADD_PASS_REQUEST = 1;
    public static final int EDIT_PASS_REQUEST = 2;

    private FloatingActionButton btnFloat;
    Toolbar toolbar;
    PassViewModel passViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);

        toolbar = findViewById(R.id.passToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnFloat = findViewById(R.id.floating);

        btnFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPassIntent = new Intent(PassActivity.this, AddPasswordActivity.class);
                startActivityForResult(addPassIntent, ADD_PASS_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_pass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final PassAdapter passAdapter = new PassAdapter();
        recyclerView.setAdapter(passAdapter);

        passViewModel = new ViewModelProvider(PassActivity.this).get(PassViewModel.class);
        passViewModel.getAllPass().observe(this, new Observer<List<PassModel>>() {
            @Override
            public void onChanged(List<PassModel> passModels) {

                passAdapter.setPass(passModels);
            }
        });

        passAdapter.setOnItemclickListener(new PassAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(PassModel pass) {
                Intent intent = new Intent(PassActivity.this,AddPasswordActivity.class);
                intent.putExtra(AddPasswordActivity.EXTRA_ID,pass.getId());
                intent.putExtra(AddPasswordActivity.EXTRA_NAME, pass.getName());
                intent.putExtra(AddPasswordActivity.EXTRA_LOGIN,pass.getLogin());
                intent.putExtra(AddPasswordActivity.EXTRA_PASS,pass.getPassword());
                intent.putExtra(AddPasswordActivity.EXTRA_WEBSITE,pass.getWebsite());
                intent.putExtra(AddPasswordActivity.EXTRA_CATEGORY,pass.getCategory());
                intent.putExtra(AddPasswordActivity.EXTRA_NOTES,pass.getNotes());
                startActivityForResult(intent,EDIT_PASS_REQUEST);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                passViewModel.delete(passAdapter.getPassAt(viewHolder.getAdapterPosition()));
                Toast.makeText(PassActivity.this,"Pass Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_PASS_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(AddPasswordActivity.EXTRA_NAME);
            String login = data.getStringExtra(AddPasswordActivity.EXTRA_LOGIN);
            String pass = data.getStringExtra(AddPasswordActivity.EXTRA_PASS);
            String website = data.getStringExtra(AddPasswordActivity.EXTRA_WEBSITE);
            String category = data.getStringExtra(AddPasswordActivity.EXTRA_CATEGORY);
            String notes = data.getStringExtra(AddPasswordActivity.EXTRA_NOTES);

            PassModel passModel = new PassModel(name,login,pass,website,category,notes);
            passViewModel.insert(passModel);

            Toast.makeText(this,"Pass saved",Toast.LENGTH_SHORT).show();
        }else if(requestCode == EDIT_PASS_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(AddPasswordActivity.EXTRA_ID, -1);

            if(id == -1){
                Toast.makeText(this,"Pass can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String name = data.getStringExtra(AddPasswordActivity.EXTRA_NAME);
            String login = data.getStringExtra(AddPasswordActivity.EXTRA_LOGIN);
            String pass = data.getStringExtra(AddPasswordActivity.EXTRA_PASS);
            String website = data.getStringExtra(AddPasswordActivity.EXTRA_WEBSITE);
            String category = data.getStringExtra(AddPasswordActivity.EXTRA_CATEGORY);
            String notes = data.getStringExtra(AddPasswordActivity.EXTRA_NOTES);

            PassModel passModel = new PassModel(name,login,pass,website,category,notes);
            passModel.setId(id);
            passViewModel.update(passModel);

            Toast.makeText(this,"Pass Updated",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Pass not saved",Toast.LENGTH_SHORT).show();
        }
    }
}
