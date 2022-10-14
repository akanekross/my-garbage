/*package com.example.mygarbage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adaptador1 extends BaseAdapter {
    private Context contexto;
    private ArrayList<Dispositivo1> listItems;

    public Adaptador1(Context contexto, ArrayList<Dispositivo1> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {//Cuantas veces se tiene que replicar un item para un listview determinado
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {//permite recuperar un item especicfico
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_listview, null);
        ImageView ivFoto=(ImageView) view.findViewById(R.id.ivFoto);
        TextView tvDispositivos=(TextView)  view.findViewById(R.id.tvDispositivos);
        Dispositivo1 D=(Dispositivo1) getItem(position);
        Glide.with(contexto)
                .load(D.getDispositivo())
                .centerCrop()
                .fitCenter()
                .into(ivFoto);
        tvDispositivos.setText(D.getDispositivo());
        return view;



    }
}*/
