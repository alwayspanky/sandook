package com.example.sandook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AddNotesActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE_ID = "com.example.sandook.EXTRA_NOTE_ID";
    public static final String EXTRA_NOTE_TITLE = "com.example.sandook.EXTRA_NOTE_TITLE";
    public static final String EXTRA_NOTE_NAME = "com.example.sandook.EXTRA_NOTE_NAME";
    public static final String EXTRA_NOTE_CATEGORY = "com.example.sandook.EXTRA_CATEGORY";


    Toolbar toolbar;
    private EditText noteTitle, noteName, noteCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        noteTitle = findViewById(R.id.txtNotesTitle);
        noteName = findViewById(R.id.txtNotesName);
        noteCategory = findViewById(R.id.txtNotesCategory);

        toolbar = findViewById(R.id.addNotesToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_NOTE_ID)){
            setTitle("Edit Note");
            noteTitle.setText(intent.getStringExtra(EXTRA_NOTE_TITLE));
            noteName.setText(intent.getStringExtra(EXTRA_NOTE_NAME));
            noteCategory.setText(intent.getStringExtra(EXTRA_NOTE_CATEGORY));
        }
        else{
            setTitle("Add Note");
        }
    }

    private void saveNotes() {

        String nTitle = noteTitle.getText().toString();
        String nName = noteName.getText().toString();
        String nCategory = noteCategory.getText().toString();

        Intent data = new Intent();

        data.putExtra(EXTRA_NOTE_TITLE,nTitle);
        data.putExtra(EXTRA_NOTE_NAME,nName);
        data.putExtra(EXTRA_NOTE_CATEGORY,nCategory);

        int id = getIntent().getIntExtra(EXTRA_NOTE_ID,-1);
        if (id != -1){
            data.putExtra(EXTRA_NOTE_ID,id);
        }

        setResult(RESULT_OK, data);
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
                saveNotes();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
