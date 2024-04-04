package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyquangcuong.commicapp.Model.Truyen;
import com.hyquangcuong.commicapp.database.MySQLiteHelper;

public class AddCommic extends AppCompatActivity {

    EditText editTentruyen,editNoiDung,editAnh;
    Button btAdd;
    MySQLiteHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_commic);

        editAnh = findViewById(R.id.dbImg);
        editTentruyen = findViewById(R.id.dbTenTruyen);
        editNoiDung = findViewById(R.id.dbNoiDung);
        btAdd = findViewById(R.id.dbDangBai);

        database = new MySQLiteHelper(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenTruyen = editTentruyen.getText().toString();
                String noiDung = editNoiDung.getText().toString();
                String img = editAnh.getText().toString();

                Truyen truyen = createTruyen();
                if(tenTruyen.equals("") || noiDung.equals("") || img.equals("")){
                    Toast.makeText(AddCommic.this, "Yêu Cầu Nhập Đầy Đủ!", Toast.LENGTH_SHORT).show();
                    Log.e("ERR","Nhập đủ thông tin");
                }
                else
                {
                    database.AddCommic(truyen);
                    Intent intent = new Intent(AddCommic.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                }
            }
        });

    }
    private Truyen createTruyen(){
        String tenTruyen = editTentruyen.getText().toString();
        String noiDung = editNoiDung.getText().toString();
        String img = editAnh.getText().toString();

        Intent intent = getIntent();
        int id = intent.getIntExtra("Id",0);
        Truyen truyen = new Truyen(tenTruyen,noiDung,img,id);
        return truyen;
    }
}