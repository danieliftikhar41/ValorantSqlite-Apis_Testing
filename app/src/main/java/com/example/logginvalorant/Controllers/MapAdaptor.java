package com.example.logginvalorant.Controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Map;

import com.example.logginvalorant.R;

import java.util.ArrayList;

public class MapAdaptor extends RecyclerView.Adapter<MapAdaptor.ViewHolder> {
    private ArrayList<Map> arrayMap;

    public MapAdaptor(ArrayList<Map> arrW){
        arrayMap = arrW;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(arrayMap.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        TextView etiquetaDes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userNamemap);

        }
    }
}
