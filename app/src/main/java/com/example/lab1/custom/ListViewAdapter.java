package com.example.lab1.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab1.R;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] listFruit;
    int[] listImages;
    LayoutInflater inflater;

    public ListViewAdapter(Context ctx, String[] fruitList, int[] images) {
        this.context = ctx;
        this.listFruit = fruitList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return this.listFruit.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = convertView.findViewById(R.id.itemText);
        ImageView fruitImage = convertView.findViewById(R.id.imageIcon);

        txtView.setText(listFruit[position]);
        fruitImage.setImageResource(listImages[position]);

        return convertView;
    }
}