package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.noteModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.viewHolder> {

    List<noteModel> allNotes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NotesAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.viewHolder holder, int position) {
        noteModel notes = allNotes.get(position);
        holder.noteTitle.setText(notes.getNoteTitle());
        holder.noteName.setText(notes.getNote());
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    public void setNotes(List<noteModel> notes){
        this.allNotes = notes;
        notifyDataSetChanged();
    }

    public noteModel getNotesAt(int position){
        return allNotes.get(position);
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView noteTitle, noteName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            noteTitle = itemView.findViewById(R.id.txt_Title);
            noteName = itemView.findViewById(R.id.txt_Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClickListener(allNotes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(noteModel note);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
