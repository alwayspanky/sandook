package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.IdCardModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class IdsAdapter extends RecyclerView.Adapter<IdsAdapter.viewHolder> {

    List<IdCardModel> allIds = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public IdsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IdsAdapter.viewHolder holder, int position) {

        IdCardModel idCardModel = allIds.get(position);
        holder.txtTitle.setText(idCardModel.getiName());
        holder.txtName.setText(idCardModel.getiNumber());
    }

    @Override
    public int getItemCount() {
        return allIds.size();
    }

    public void setIds(List<IdCardModel> card){
        this.allIds = card;
        notifyDataSetChanged();
    }

    public IdCardModel getIdsAt(int position){
        return allIds.get(position);
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
                        listener.onItemClickListener(allIds.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(IdCardModel id);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
