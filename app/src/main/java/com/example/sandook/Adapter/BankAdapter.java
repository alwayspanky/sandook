package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.BankModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.viewHolder> {

    List<BankModel> allBanks = new ArrayList<>();
    private OnItemClickListener listener;


    @NonNull
    @Override
    public BankAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankAdapter.viewHolder holder, int position) {
        BankModel model = allBanks.get(position);
        holder.txtTitle.setText(model.getbName());
        holder.txtName.setText(model.getBankName());
    }

    @Override
    public int getItemCount() {
        return allBanks.size() ;
    }

    public void setBanks(List<BankModel> bank){
        this.allBanks = bank;
        notifyDataSetChanged();
    }

    public BankModel getBankAt(int position){
        return allBanks.get(position);
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
                        listener.onItemClickListener(allBanks.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(BankModel bankModel);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
