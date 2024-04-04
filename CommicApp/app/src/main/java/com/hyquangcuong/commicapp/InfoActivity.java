package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView txtThongTinapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        txtThongTinapp = findViewById(R.id.textviewThongTin);
        String thongtin = "Ứng Dụng Đọc Truyện - Đề Tài 6 \n"+
                "Build: Quang - Hy - Cuong \n" +
                "GVHD: Duong Thai Bao";
        txtThongTinapp.setText(thongtin);
    }
}