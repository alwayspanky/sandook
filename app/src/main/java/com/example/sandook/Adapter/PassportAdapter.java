package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.sandook.Database.Model.PassportModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class PassportAdapter extends RecyclerView.Adapter<PassportAdapter.viewHolder> {

    List<PassportModel> allPassports = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public PassportAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PassportAdapter.viewHolder holder, int position) {
        PassportModel passportModel = allPassports.get(position);
        holder.txtTitle.setText(passportModel.getpName());
        holder.txtName.setText(passportModel.getpNumber());
    }

    @Override
    public int getItemCount() {
        return allPassports.size();
    }

    public void setPassports(List<PassportModel> passports){
        this.allPassports = passports;
        notifyDataSetChanged();
    }

    public PassportModel getPassportAt(int position){
        return allPassports.get(position);
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle, txtName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_Name);
            txtTitle = itemView.findViewById(R.id.txt_Title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION){
                        listener.onItemClickListener(allPassports.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(PassportModel passport);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
