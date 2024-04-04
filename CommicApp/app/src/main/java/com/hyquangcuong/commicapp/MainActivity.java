package com.hyquangcuong.commicapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.hyquangcuong.commicapp.Model.Category;
import com.hyquangcuong.commicapp.Model.Truyen;
import com.hyquangcuong.commicapp.Model.User;
import com.hyquangcuong.commicapp.adapter.AdapterCategory;
import com.hyquangcuong.commicapp.adapter.AdapterComic;
import com.hyquangcuong.commicapp.adapter.AdapterUser;
import com.hyquangcuong.commicapp.database.MySQLiteHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MySQLiteHelper database;
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView, listViewNew,listViewThongTin;
    DrawerLayout drawerLayout;

    String email;
    String nameUser;
    ArrayList<Truyen> truyenArrayList;
    ArrayList<Category> categories;
    ArrayList<User> userArrayList;
    AdapterComic adapterComic;

    AdapterCategory adapterCategory;
    AdapterUser adapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new MySQLiteHelper(this);

        Intent intent = getIntent();
        int role = intent.getIntExtra("Roles",0);
        int id = intent.getIntExtra("Id",0);
        email = intent.getStringExtra("Email");
        nameUser = intent.getStringExtra("User");

        toolbar = findViewById(R.id.toolbarViewMain);
        viewFlipper = findViewById(R.id.viewFlipper);
        listView = findViewById(R.id.ListViewMain);
        listViewThongTin = findViewById(R.id.ListViewThongTin);
        listViewNew = findViewById(R.id.lisstViewNew);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerlayout);

        truyenArrayList = new ArrayList<>();
        Cursor cursor = database.getAllComic();

        while (cursor.moveToNext())
        {
            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            String noiDung = cursor.getString(2);
            String anh = cursor.getString(3);
            int id_user = cursor.getInt(4);

            truyenArrayList.add(new Truyen(_id,name,noiDung,anh,id_user));
            adapterComic = new AdapterComic(getApplicationContext(),truyenArrayList);
            listViewNew.setAdapter(adapterComic);
        }
        cursor.moveToFirst();
        cursor.close();

        //Đừng Viết đè lên nữa Pleasesssssss,tách hàm ra dùm em!!
        userArrayList = new ArrayList<>();
        userArrayList.add(new User(nameUser,email));

        adapterUser = new AdapterUser(this,R.layout.navigation_thongtin,userArrayList);
        listViewThongTin.setAdapter(adapterUser);




        categories = new ArrayList<>();
        categories.add(new Category("Thêm Truyện",R.drawable.ic_post_add_24));
        categories.add(new Category("Xóa Truyện",R.drawable.ic_post_add_24));
        categories.add(new Category("Thông Tin",R.drawable.ic_faces_24));
        categories.add(new Category("Đăng Xuất",R.drawable.ic_login_24));

        adapterCategory = new AdapterCategory(this,R.layout.category,categories);

        listView.setAdapter(adapterCategory);



        ActionViewFlipper();
        ActionBar();

        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(MainActivity.this,DetailsActivity.class);

                String tent = truyenArrayList.get(i).getTenTruyen();
                String noiDungt = truyenArrayList.get(i).getNoiDung();
                intent1.putExtra("TenTruyen",tent);
                intent1.putExtra("NoiDung",noiDungt);
                startActivity(intent1);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos == 0){
                    if(role == 1 ){
                        Intent intent1 = new Intent(MainActivity.this,AddCommic.class);
                        intent1.putExtra("Id",id);
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Bạn Không có quyền Thêm!",Toast.LENGTH_SHORT).show();
                        Log.e("Thêm Truyện: ","Chỉ Admin mới có quyền");
                    }
                }
                else if(pos == 1){
                    if(role == 1 ){
                        Intent intent1 = new Intent(MainActivity.this,Admin.class);
                        intent1.putExtra("Id",id);
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"Bạn Không có quyền Xóa!",Toast.LENGTH_SHORT).show();
                        Log.e("Thêm Truyện: ","Chỉ Admin mới có quyền");
                    }
                }
                else if(pos == 2){
                    Intent intent1 = new Intent(MainActivity.this,InfoActivity.class);
                    startActivity(intent1);
                }
                else if(pos == 3){
                    finish();
                }
            }
        });
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void ActionViewFlipper(){
        ArrayList<String> viewHome = new ArrayList<>();
        viewHome.add("https://images.toplist.vn/images/800px/coc-kien-troi-636013.jpg");
        viewHome.add("https://images.toplist.vn/images/800px/co-be-quang-khan-do-636016.jpg");
        viewHome.add("https://images.toplist.vn/images/800px/su-tich-cay-vu-sua-137640.jpg");
        viewHome.add("https://images.toplist.vn/images/800px/su-tich-dua-hau-137645.jpg");

        for (int i=0; i<viewHome.size();i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());

            Picasso.get().load(viewHome.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        //Tu dong chay
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);

        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setInAnimation(slide_out);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(MainActivity.this,Search.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}