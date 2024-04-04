package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hyquangcuong.commicapp.Model.User;
import com.hyquangcuong.commicapp.database.MySQLiteHelper;

public class Register extends AppCompatActivity {

    EditText txtUser, txtPassWord,txtEmail;
    Button btnRegister, btnBack;

    MySQLiteHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        database = new MySQLiteHelper(this);

        txtUser = findViewById(R.id.dktaikhoan);
        txtPassWord = findViewById(R.id.dkmatkhau);
        txtEmail = findViewById(R.id.dkemail);
        btnRegister = findViewById(R.id.dkdangky);
        btnBack = findViewById(R.id.dkquaylai);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtUser.getText().toString();
                String pass = txtPassWord.getText().toString();
                String email = txtEmail.getText().toString();

                User user1 = createUser();
                if(user.equals("") || pass.equals("") || email.equals("")){
                    Log.e("Thông Báo: ","Chưa nhập đầy đủ thông tin");
                }
                else{
                    database.AddUser(user1);
                    Toast.makeText(Register.this,"Đăng Ký Thành Công",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private User createUser(){
        String user = txtUser.getText().toString();
        String pass = txtPassWord.getText().toString();
        String email = txtEmail.getText().toString();
        int role = 2;

        User users = new User(user,pass,email,role);
        return users;

    }
}