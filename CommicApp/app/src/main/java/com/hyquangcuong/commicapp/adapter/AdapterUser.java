package com.hyquangcuong.commicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hyquangcuong.commicapp.Model.User;
import com.hyquangcuong.commicapp.R;

import java.util.List;

public class AdapterUser extends BaseAdapter {

    private Context context;
    private int layout;
    private List<User> userList;

    public AdapterUser(Context context, int layout, List<User> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txtNameUser = (TextView) view.findViewById(R.id.text_name);
        TextView txtEmail = (TextView) view.findViewById(R.id.txtGmail);

        User user = userList.get(i);

        txtNameUser.setText(user.getName());
        txtEmail.setText(user.getEmail());

        return view;
    }
}
