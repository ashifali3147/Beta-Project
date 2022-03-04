package com.example.beta_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.beta_project.reason.model.ReasonPopup;

public class MainActivity extends AppCompatActivity {
    Button btn_cancelOrder;
    ReasonPopup reasonPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reasonPopup = new ReasonPopup();
        btn_cancelOrder = (Button) findViewById(R.id.btn_cancel);
        btn_cancelOrder.setOnClickListener(view -> {
            reasonPopup.showPopup(MainActivity.this, view);
        });
    }
}