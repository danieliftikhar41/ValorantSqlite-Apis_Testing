package com.example.logginvalorant.Controllers;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<Weapon> arrayWeapon;

    private SelectListner lisnter;

    public RecyclerViewAdapter(ArrayList<Weapon> arrW,SelectListner ltn){
        arrayWeapon = arrW;
        this.lisnter=ltn;
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

        //Making Container clickAble
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisnter.onItemClicked(arrayWeapon.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayWeapon.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        TextView etiquetacost;
        TextView etiquetaType;
        ConstraintLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userNameWeapon);
            etiquetacost = itemView.findViewById(R.id.costid);
            etiquetaType = itemView.findViewById(R.id.weapontipo);
            container=itemView.findViewById(R.id.weapon_container);


        }
    }
    
}
