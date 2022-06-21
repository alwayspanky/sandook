package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.SocialModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.viewHolder> {

    List<SocialModel> allSocials = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public SocialAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.viewHolder holder, int position) {
        SocialModel socialModel = allSocials.get(position);
        holder.txtTitle.setText(socialModel.getName());
        holder.txtName.setText(socialModel.getNumber());
    }

    @Override
    public int getItemCount() {
        return allSocials.size();
    }

    public void setSocials(List<SocialModel> socials){
        this.allSocials = socials;
        notifyDataSetChanged();
    }

    public SocialModel getSocialAt(int position){
        return allSocials.get(position);
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
                        listener.onItemClickListener(allSocials.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(SocialModel social);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
