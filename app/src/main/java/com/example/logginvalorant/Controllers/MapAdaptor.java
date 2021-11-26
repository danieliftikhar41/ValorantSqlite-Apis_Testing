package com.example.logginvalorant.Controllers;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Map;

import com.example.logginvalorant.R;

import java.util.ArrayList;

public class MapAdaptor extends RecyclerView.Adapter<MapAdaptor.ViewHolder> {
    private ArrayList<Map> arrayMap;
    private SelectListner lisnter;
    public MapAdaptor(ArrayList<Map> arrW,SelectListner ltn){
        arrayMap = arrW;
        this.lisnter=ltn;
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
        //Making Container clickAble
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisnter.onItemClicked(arrayMap.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;

        ConstraintLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userNamemap);
            container=itemView.findViewById(R.id.mapcontainer);
        }
    }
}
