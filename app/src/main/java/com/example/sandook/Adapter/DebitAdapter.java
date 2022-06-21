package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.DebitModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class DebitAdapter extends RecyclerView.Adapter<DebitAdapter.viewHolder> {

    List<DebitModel> allDebits = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public DebitAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DebitAdapter.viewHolder holder, int position) {

        DebitModel debitModel = allDebits.get(position);
        holder.txtTitle.setText(debitModel.getdName());
        holder.txtName.setText(debitModel.getdNumber());
    }

    @Override
    public int getItemCount() {
        return allDebits.size();
    }

    public void setDebits(List<DebitModel> debit){
        this.allDebits = debit;
        notifyDataSetChanged();
    }

    public DebitModel getDebitAt(int position){
        return allDebits.get(position);
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
                        listener.onItemClickListener(allDebits.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(DebitModel debitModel);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
