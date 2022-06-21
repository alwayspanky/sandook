package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.TaxModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class TaxAdapter extends RecyclerView.Adapter<TaxAdapter.viewHolder> {

    List<TaxModel> allTaxes = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public TaxAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaxAdapter.viewHolder holder, int position) {

        TaxModel  taxModel = allTaxes.get(position);
        holder.txtTitle.setText(taxModel.getName());
        holder.txtName.setText(taxModel.getNumber());
    }

    @Override
    public int getItemCount() {
        return allTaxes.size();
    }

    public void setTaxes(List<TaxModel> tax){
        this.allTaxes = tax;
        notifyDataSetChanged();
    }

    public TaxModel getTaxesAt(int position){
        return allTaxes.get(position);
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
                        listener.onItemClickListener(allTaxes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(TaxModel taxModel);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
