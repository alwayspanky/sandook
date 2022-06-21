package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.CreditModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class CreditAdapter extends RecyclerView.Adapter<CreditAdapter.viewHolder> {

    List<CreditModel> allCredits = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        CreditModel model = allCredits.get(position);
        holder.txtTitle.setText(model.getcName());
        holder.txtName.setText(model.getcNumber());
    }

    @Override
    public int getItemCount() {
        return allCredits.size();
    }

    public void setCredits(List<CreditModel> credit){
        this.allCredits = credit;
        notifyDataSetChanged();
    }

    public CreditModel getCreditAt(int position){
        return allCredits.get(position);
    }

    public class viewHolder extends RecyclerView.ViewHolder {

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
                        listener.onItemClickListener(allCredits.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(CreditModel creditModel);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
