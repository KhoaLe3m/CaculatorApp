package com.example.android2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtKetQua;
    String Soa,Sob;
    ArrayList<String> full;
    Character dau = null;
    Button Cong;
    Button Tru;
    Button Nhan;
    Button Chia;
    Button Bang;
    Button Xoa;
    ImageButton imgHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Gán giá trị
        full = new ArrayList<String>();
        Soa = Sob="";
        txtKetQua =(TextView)findViewById(R.id.ketQua);
        Cong = (Button) findViewById(R.id.phepCong);
        Tru = (Button) findViewById(R.id.phepTru);
        Nhan = (Button) findViewById(R.id.phepNhan);
        Chia = (Button) findViewById(R.id.phepChia);
        Bang= (Button) findViewById(R.id.dauBang);
        Xoa = (Button) findViewById(R.id.nutXoa);
        imgHistory = findViewById(R.id.imgHistory);

        // Đặt lệnh
        Cong.setOnClickListener(PhepToan);
        Tru.setOnClickListener(PhepToan);
        Nhan.setOnClickListener(PhepToan);
        Chia.setOnClickListener(PhepToan);
        Bang.setOnClickListener(TinhToan);
        Xoa.setOnClickListener(XoaToanBo);
        imgHistory.setOnClickListener(History);
    }

    // Phương thức lấy số
    public void so(View view) {
        Button button = (Button) view;
        Soa += button.getText().toString();
        txtKetQua.setText(Soa);
    }
    // Phương thức xóa
    private View.OnClickListener XoaToanBo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()== R.id.nutXoa){
                Soa="";
                Sob="";
                txtKetQua.setText("");
            }
        }
    };
    // Phương thức Tính toán
    private View.OnClickListener TinhToan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a =0, b = 0,kq = 0;
            String s = "";
            a = Double.valueOf(Soa);
            b = Double.valueOf(Sob);
            switch (dau){
                case '+':
                    kq = a+b;
                    break;
                case '-':
                    kq = b-a;
                    break;
                case '*':
                    kq = a*b;
                    break;
                case '/':
                    kq = b/a;
                    break;
                default:kq = 0;
            }
            s = String.valueOf(b) + " " + dau.toString() + " " + String.valueOf(a) + " = " +String.valueOf(kq);
            full.add(s);
            Soa = String.valueOf(kq);
            Sob = "";
            txtKetQua.setText(String.valueOf(kq));
        }
    };
//      Phương thức nhận dấu
    private View.OnClickListener PhepToan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Sob = Soa;
            Soa="";
            Button tinh = (Button) view;
            String tam2 = tinh.getText().toString();
            dau = tam2.charAt(0);
        }
    };
//    Phương thức lịch sử
    private View.OnClickListener History = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, com.example.android2.History.class);
            intent.putStringArrayListExtra("history",full);
            startActivity(intent);
        }
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("history",full);
        outState.putString("Number1",Sob);
        outState.putString("Number2",Soa);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        full = savedInstanceState.getStringArrayList("history");
        Soa = savedInstanceState.getString("Number2");
        Sob = savedInstanceState.getString("Number1");
        txtKetQua.setText(Soa);
    }
}