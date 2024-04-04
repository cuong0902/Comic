package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.hyquangcuong.commicapp.Model.Truyen;
import com.hyquangcuong.commicapp.adapter.AdapterComic;
import com.hyquangcuong.commicapp.database.MySQLiteHelper;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    ArrayList<Truyen> truyenArrayList;
    AdapterComic adapterComic;
    
    MySQLiteHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        
        listView = findViewById(R.id.ListViewAdmin);
//        btnAdd = findViewById(R.id.btnThemTruyen);
        
        initList();
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent1 = getIntent();
//                int id = intent1.getIntExtra("Id",0);
//
//
//                Intent intent = new Intent(Admin.this,AddCommic.class);
//                intent.putExtra("Id",id);
//                startActivity(intent);
//            }
//        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int idTruyen = truyenArrayList.get(i).getId();
                database.DeleteCommic(idTruyen);

                //cap nhat laai activity
                Intent intent = new Intent(Admin.this,Admin.class);
                finish();
                startActivity(intent);
                Toast.makeText(Admin.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initList() {
        truyenArrayList = new ArrayList<>();
        database = new MySQLiteHelper(this);

        Cursor cursor = database.getAllComic();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String noiDung = cursor.getString(2);
            String anh = cursor.getString(3);
            int id_tk = cursor.getInt(4);

            truyenArrayList.add(new Truyen(id,name,noiDung,anh,id_tk));
            adapterComic = new AdapterComic(getApplicationContext(),truyenArrayList);

            listView.setAdapter(adapterComic);
        }
        cursor.moveToFirst();
        cursor.close();
    }
}