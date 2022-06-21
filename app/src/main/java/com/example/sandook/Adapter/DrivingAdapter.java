package com.example.sandook.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sandook.Database.Model.DrivingModel;
import com.example.sandook.R;

import java.util.ArrayList;
import java.util.List;

public class DrivingAdapter extends RecyclerView.Adapter<DrivingAdapter.viewHolder> {

    List<DrivingModel> allDrivings = new ArrayList<>();
    private OnItemClickListener listener;


    @NonNull
    @Override
    public DrivingAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrivingAdapter.viewHolder holder, int position) {

        DrivingModel drivingModel = allDrivings.get(position);
        holder.txtTitle.setText(drivingModel.getdName());
        holder.txtName.setText(drivingModel.getdNumber());

    }

    @Override
    public int getItemCount() {
        return allDrivings.size();
    }

    public void setDrivings(List<DrivingModel> driving){
        this.allDrivings = driving;
        notifyDataSetChanged();
    }

    public DrivingModel getDrivingAt(int position){
        return allDrivings.get(position);
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
                        listener.onItemClickListener(allDrivings.get(position));
                    }
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClickListener(DrivingModel driving);
    }

    public void setOnItemclickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
