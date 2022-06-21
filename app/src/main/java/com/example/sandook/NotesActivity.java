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

import com.example.sandook.Adapter.NotesAdapter;
import com.example.sandook.Database.Model.noteModel;
import com.example.sandook.Database.PassViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotesActivity extends AppCompatActivity {

    public static final int ADD_NOTES_REQUEST = 1;
    public static final int EDIT_NOTES_REQUEST = 2;

    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    PassViewModel passViewModel;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        floatingActionButton = findViewById(R.id.notes_floating);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addintent = new Intent(NotesActivity.this, AddNotesActivity.class);
                startActivityForResult(addintent, ADD_NOTES_REQUEST);
            }
        });

        toolbar = findViewById(R.id.notesToolbar);

        setSupportActionBar(toolbar);
        setTitle("Notes");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final NotesAdapter notesAdapter = new NotesAdapter();
        recyclerView.setAdapter(notesAdapter);

        passViewModel = new ViewModelProvider(NotesActivity.this).get(PassViewModel.class);
        passViewModel.getAllNotes().observe(NotesActivity.this, new Observer<List<noteModel>>() {
            @Override
            public void onChanged(List<noteModel> noteModels) {
                notesAdapter.setNotes(noteModels);
            }
        });

        notesAdapter.setOnItemclickListener(new NotesAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(noteModel note) {
                Intent noteIntent = new Intent(NotesActivity.this,AddNotesActivity.class);
                noteIntent.putExtra(AddNotesActivity.EXTRA_NOTE_ID,note.getId());
                noteIntent.putExtra(AddNotesActivity.EXTRA_NOTE_TITLE,note.getNoteTitle());
                noteIntent.putExtra(AddNotesActivity.EXTRA_NOTE_CATEGORY,note.getCategory());
                noteIntent.putExtra(AddNotesActivity.EXTRA_NOTE_NAME,note.getNote());
                startActivityForResult(noteIntent,EDIT_NOTES_REQUEST);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                passViewModel.deleteNotes(notesAdapter.getNotesAt(viewHolder.getAdapterPosition()));
                Toast.makeText(NotesActivity.this,"Note deleted",Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NOTES_REQUEST && resultCode == RESULT_OK){

            String title = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_TITLE);
            String note = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_NAME);
            String category = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_CATEGORY);

            noteModel notes = new noteModel(title,note,category);
            passViewModel.insertNotes(notes);

            Toast.makeText(this,"Note Saved",Toast.LENGTH_SHORT).show();

        }else if(requestCode == EDIT_NOTES_REQUEST && resultCode == RESULT_OK){
            int id = data.getIntExtra(AddNotesActivity.EXTRA_NOTE_ID, -1);

            if(id == -1){
                Toast.makeText(this,"Note can't be updated",Toast.LENGTH_SHORT).show();
                return;
            }

            String title = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_TITLE);
            String note = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_NAME);
            String category = data.getStringExtra(AddNotesActivity.EXTRA_NOTE_CATEGORY);

            noteModel notes = new noteModel(title,note,category);
            notes.setId(id);
            passViewModel.updateNotes(notes);

            Toast.makeText(this,"Note Updated",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this,"Note not saved",Toast.LENGTH_SHORT).show();
        }
    }
}
