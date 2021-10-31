package com.example.logginvalorant.Controllers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;

import com.example.logginvalorant.R;

import java.util.ArrayList;

public class AgentAdaptor extends RecyclerView.Adapter<AgentAdaptor.ViewHolder> {
    private ArrayList<Agent> arrayAgent;

    public AgentAdaptor(ArrayList<Agent> arrW){
        arrayAgent = arrW;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.etiquetaNom.setText(arrayAgent.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayAgent.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetaNom;
        TextView etiquetaDes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetaNom = itemView.findViewById(R.id.userName);
            etiquetaDes = itemView.findViewById(R.id.DesCamp);
        }
    }
}
