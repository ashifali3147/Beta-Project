package com.example.beta_project.reason.model;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beta_project.R;
import com.example.beta_project.reason.ReasonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ReasonPopup {
    List<CancelReason> list = new ArrayList<>();
    CancelReason cancelReason = new CancelReason();
    ReasonAdapter reasonAdapter;
    RecyclerView rv;
    EditText edtOtherReason;

    RadioButton rdBtnOthers;

    public void showPopup(Context context, View view) {

        final Dialog dialog2 = new Dialog(context);
        dialog2.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog2.setContentView(R.layout.cancel_reason_custom);
        rv = (RecyclerView) dialog2.findViewById(R.id.rv_reason);
        dialog2.show();
        CancelReason cancelReason = new CancelReason();
        cancelReason.id = "5678";
        cancelReason.reason = "VALO LAGCHE NA";

        CancelReason cancelReason2 = new CancelReason();
        cancelReason2.id = "56478";
        cancelReason2.reason = "VALO LAGCHE NA BAl";

        CancelReason cancelReason3 = new CancelReason();
        cancelReason3.id = "56728";
        cancelReason3.reason = "OTHERS";

        list.add(cancelReason);
        list.add(cancelReason2);
        list.add(cancelReason3);
        rv.setLayoutManager(new LinearLayoutManager(dialog2.getLayoutInflater().getContext()));
        reasonAdapter = new ReasonAdapter(dialog2.getLayoutInflater().getContext(),list, dialog2);
        rv.setAdapter(reasonAdapter);

        edtOtherReason = dialog2.findViewById(R.id.edt_other_reason);
//        rdBtnOthers = dialog2.findViewById(R.id.rdBtn_other);


    }
}
