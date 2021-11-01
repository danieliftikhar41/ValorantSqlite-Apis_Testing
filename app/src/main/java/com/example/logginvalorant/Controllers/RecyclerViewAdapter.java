package com.example.logginvalorant.Controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<Weapon> arrayWeapon;

    public RecyclerViewAdapter(ArrayList<Weapon> arrW){
        arrayWeapon = arrW;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weapon_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(arrayWeapon.get(position).getName());
        holder.etiquetacost.setText(arrayWeapon.get(position).getCost());
        holder.etiquetaType.setText(arrayWeapon.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return arrayWeapon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        TextView etiquetacost;
        TextView etiquetaType;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userNameWeapon);
            etiquetacost = itemView.findViewById(R.id.costid);
            etiquetaType = itemView.findViewById(R.id.weapontipo);


        }
    }
}
