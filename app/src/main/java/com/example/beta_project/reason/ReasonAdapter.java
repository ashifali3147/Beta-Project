package com.example.beta_project.reason;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beta_project.R;
import com.example.beta_project.reason.model.CancelOrderModel;
import com.example.beta_project.reason.model.CancelReason;

import java.util.ArrayList;
import java.util.List;

public class ReasonAdapter extends RecyclerView.Adapter<ReasonAdapter.MyViewAdapter> {
    Context ctx;
    List<CancelReason> cancelReasonsList;

    public ReasonAdapter(Context context, List<CancelReason> cancelReasons) {
        this.cancelReasonsList = cancelReasons;
        this.ctx = context;
    }

    @NonNull
    @Override
    public ReasonAdapter.MyViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.radio_reason, (ViewGroup) parent, false);
        MyViewAdapter vh = new MyViewAdapter(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReasonAdapter.MyViewAdapter holder, int position) {

        holder.radioButton.setText(cancelReasonsList.get(position).reason);

        if (cancelReasonsList.get(position).radio) {
            holder.radioButton.setChecked(true);
        } else holder.radioButton.setChecked(false);
        holder.rad_lay.setOnClickListener(view -> {
            for (CancelReason cancelReason : cancelReasonsList){
                cancelReason.radio = false;

            }
//            cancelReasonsList.get(position).radio = true;



            notifyDataSetChanged();
        });


    }

    @Override
    public int getItemCount() {
        return cancelReasonsList.size(); //cancelOrderModel.cancelReasons.size();
    }

    public class MyViewAdapter extends RecyclerView.ViewHolder {
        LinearLayout rad_lay;
        RadioButton radioButton;


        public MyViewAdapter(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.rdBtn_reason);
            rad_lay = itemView.findViewById(R.id.rad_lay);
        }
    }
}
