package com.hyquangcuong.commicapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyquangcuong.commicapp.Model.Truyen;
import com.hyquangcuong.commicapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterComic extends BaseAdapter {

    private Context context;
    private ArrayList<Truyen> listTruyen;

    public AdapterComic(Context context, ArrayList<Truyen> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
    }

    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int i) {
        return listTruyen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void filterList(ArrayList<Truyen> filterList) {
        listTruyen = filterList;
        notifyDataSetChanged();
    }

    public class viewHolder{
        TextView txtNameTruyen;
        ImageView imgtruyen;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        viewHolder viewHolder = new viewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.newcomic,null);

        viewHolder.txtNameTruyen = view.findViewById(R.id.textViewNameCommic);
        viewHolder.imgtruyen = view.findViewById(R.id.imgNewComic);
        view.setTag(viewHolder);

        Truyen truyen = (Truyen) getItem(i);
        viewHolder.txtNameTruyen.setText(truyen.getTenTruyen());

        Picasso.get().load(truyen.getAnh()).placeholder(R.drawable.ic_load).error(R.drawable.ic_baseline_image_24).into(viewHolder.imgtruyen);

        return view;
    }
}
