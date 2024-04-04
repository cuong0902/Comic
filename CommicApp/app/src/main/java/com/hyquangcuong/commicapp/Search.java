package com.hyquangcuong.commicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.hyquangcuong.commicapp.Model.Truyen;
import com.hyquangcuong.commicapp.adapter.AdapterComic;
import com.hyquangcuong.commicapp.database.MySQLiteHelper;

import java.util.ArrayList;

public class Search extends AppCompatActivity {

    ListView listView;
    EditText edit;
    ArrayList<Truyen> truyenArrayList;
    ArrayList<Truyen> arrayList;

    AdapterComic adapterComic;
    MySQLiteHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = findViewById(R.id.ListViewTimKiem);
        edit = findViewById(R.id.timKiem);

        initList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Search.this,DetailsActivity.class);
                String nameCommic = arrayList.get(i).getTenTruyen();
                String noiDung = arrayList.get(i).getNoiDung();
                intent.putExtra("TenTruyen",nameCommic);
                intent.putExtra("NoiDung",noiDung);
                startActivity(intent);

            }
        });
        //search
        edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });
    }
    private void filter(String text){
        arrayList.clear();
        ArrayList<Truyen> filterList = new ArrayList<>();
        for(Truyen iTruyen: truyenArrayList){
            if(iTruyen.getTenTruyen().toLowerCase().contains(text.toLowerCase())){
                filterList.add(iTruyen);
                arrayList.add(iTruyen);
            }

        }
        adapterComic.filterList(filterList);
    }

    private void initList(){
        truyenArrayList = new ArrayList<>();
        arrayList = new ArrayList<>();

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

            arrayList.add(new Truyen(id,name,noiDung,anh,id_tk));


            listView.setAdapter(adapterComic);
        }
        cursor.moveToFirst();
        cursor.close();
    }

}