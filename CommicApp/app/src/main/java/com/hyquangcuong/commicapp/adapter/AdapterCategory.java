package com.hyquangcuong.commicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyquangcuong.commicapp.Model.Category;
import com.hyquangcuong.commicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ConcurrentModificationException;
import java.util.List;

public class AdapterCategory  extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Category> categories;

    public AdapterCategory(Context context, int layout, List<Category> categories) {
        this.context = context;
        this.layout = layout;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView img = (ImageView) view.findViewById(R.id.imgCates);
        TextView txt = (TextView) view.findViewById(R.id.txtCate);

        Category cate = categories.get(i);

        txt.setText(cate.getName());

        Picasso.get().load(cate.getImg()).placeholder(R.drawable.ic_load).error(R.drawable.ic_post_add_24).into(img);
        return view;
    }
}
