package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView txtTenTruyen, txtNoiDung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtNoiDung = findViewById(R.id.NoiDung);
        txtTenTruyen = findViewById(R.id.TenTruyen);

        Intent intent = getIntent();
        String nameComic = intent.getStringExtra("TenTruyen");
        String details = intent.getStringExtra("NoiDung");

        txtTenTruyen.setText(nameComic);
        txtNoiDung.setText(details);

        //cuộn nội dung
        txtNoiDung.setMovementMethod(new ScrollingMovementMethod());
    }
}