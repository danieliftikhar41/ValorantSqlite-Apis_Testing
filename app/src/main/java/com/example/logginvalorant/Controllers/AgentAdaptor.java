package com.example.logginvalorant.Controllers;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Agent;

import com.example.logginvalorant.R;

import java.util.ArrayList;

public class AgentAdaptor extends RecyclerView.Adapter<AgentAdaptor.ViewHolder> {
    private ArrayList<Agent> arrayAgent;
    private SelectListner lisnter;
    public AgentAdaptor(ArrayList<Agent> arrW,SelectListner lisnter){
        arrayAgent = arrW;
        this.lisnter=lisnter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agent_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(arrayAgent.get(position).getName());
        //Making Container clickAble
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lisnter.onItemClicked(arrayAgent.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayAgent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        ConstraintLayout container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userNameagent);
            container=itemView.findViewById(R.id.main_container_agent);
        }
    }
}
