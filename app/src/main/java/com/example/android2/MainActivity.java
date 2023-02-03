package com.example.android2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtKetQua;
    String Soa,Sob;
    Character dau = null;

    Button Cong;
    Button Tru;
    Button Nhan;
    Button Chia;
    Button Bang;
    Button Xoa;

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
    private View.OnClickListener TinhToan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double a =0, b = 0,kq = 0;
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
            Soa = String.valueOf(kq);
            Sob = "";
            txtKetQua.setText(String.valueOf(kq));
        }
    };
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Soa = Sob="";
        txtKetQua =(TextView)findViewById(R.id.ketQua);

        Cong = (Button) findViewById(R.id.phepCong);
        Tru = (Button) findViewById(R.id.phepTru);
        Nhan = (Button) findViewById(R.id.phepNhan);
        Chia = (Button) findViewById(R.id.phepChia);
        Bang= (Button) findViewById(R.id.dauBang);
        Xoa = (Button) findViewById(R.id.nutXoa);

        Cong.setOnClickListener(PhepToan);
        Tru.setOnClickListener(PhepToan);
        Nhan.setOnClickListener(PhepToan);
        Chia.setOnClickListener(PhepToan);
        Bang.setOnClickListener(TinhToan);
        Xoa.setOnClickListener(XoaToanBo);



    }

    public void so(View view) {
        Button button = (Button) view;
        Soa += button.getText().toString();
        txtKetQua.setText(Soa);
    }
}