package com.example.beta_project.reason;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
    Dialog dialog;
    public ReasonAdapter(Context context, List<CancelReason> cancelReasons, Dialog dialog) {
        this.cancelReasonsList = cancelReasons;
        this.ctx = context;
        this.dialog = dialog;
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
            if (cancelReasonsList.get(position).reason == "OTHERS"){
                holder.edtOtherReason.setVisibility(View.VISIBLE);
                Toast.makeText(ctx, "HI" +cancelReasonsList.get(position).id, Toast.LENGTH_SHORT).show();
            }
            else {
                holder.edtOtherReason.setVisibility(View.GONE);
                Toast.makeText(ctx, "Bye" +cancelReasonsList.get(position).id, Toast.LENGTH_SHORT).show();
            }
            cancelReasonsList.get(position).radio = true;
            notifyDataSetChanged();
        });

//        holder.rad_lay.setOnClickListener(view -> {
//
//
//        });

    }

    @Override
    public int getItemCount() {
        return cancelReasonsList.size(); //cancelOrderModel.cancelReasons.size();
    }

    public class MyViewAdapter extends RecyclerView.ViewHolder {
        LinearLayout rad_lay;
        RadioButton radioButton;
        EditText edtOtherReason;

        public MyViewAdapter(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.rdBtn_reason);
            rad_lay = itemView.findViewById(R.id.rad_lay);
            edtOtherReason = (EditText) dialog.findViewById(R.id.edt_other_reason);
        }
    }
}
