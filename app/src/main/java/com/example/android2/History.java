package com.example.android2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class History extends AppCompatActivity {
    String historytext;
    ImageButton delete;
    TextView hienthi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        hienthi = findViewById(R.id.History);
        delete = findViewById(R.id.DeleteHistory);
        ArrayList<String> History = new ArrayList<>();
        historytext = "";
        Bundle bundle = getIntent().getExtras();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                History= null;
            } else {
                History= extras.getStringArrayList("history");
            }
        } else {
            History= (ArrayList) savedInstanceState.getSerializable("history");
        }
        for (String str:History) {
            historytext += str + "\n";
        }
        if(historytext != ""){
            hienthi.setText(historytext);
        }
        else{
            hienthi.setText("Không có lịch sử!");
        }
        delete.setOnClickListener(Xoa);
    }



    private View.OnClickListener Xoa = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hienthi.setText("Không có lịch sử!");
        }
    };
}