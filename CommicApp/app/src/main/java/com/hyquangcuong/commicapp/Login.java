package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyquangcuong.commicapp.database.MySQLiteHelper;

public class Login extends AppCompatActivity {

    EditText txtUser, txtPassWord;
    Button btnLogin,btnRegister;

    //create database
    MySQLiteHelper database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.user);
        txtPassWord = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        //Object db
        database = new MySQLiteHelper(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameUser = txtUser.getText().toString();
                String password = txtPassWord.getText().toString();

                Cursor cursor = database.getAllUser();

                while(cursor.moveToNext()){
                    String dbUser = cursor.getString(1);
                    String dbPassWord = cursor.getString(2);

                    if(dbUser.equals(nameUser) && dbPassWord.equals(password)){

                        int dbRole = cursor.getInt(4);
                        int dbId = cursor.getInt(0);
                        String dbEmail = cursor.getString(3);

                        Intent intent = new Intent(Login.this,MainActivity.class);

                        intent.putExtra("Roles",dbRole);
                        intent.putExtra("Id",dbId);
                        intent.putExtra("Email",dbEmail);
                        intent.putExtra("User",dbUser);

                        startActivity(intent);
                    }
                    else{
                        Log.e("Thông Báo: ","Thông tin chưa chính xác");
                        Toast.makeText(Login.this,"Sai Thông Tin Đăng Nhập",Toast.LENGTH_SHORT).show();
                    }
                }
                cursor.moveToFirst();
                cursor.close();
            }
        });
    }
}