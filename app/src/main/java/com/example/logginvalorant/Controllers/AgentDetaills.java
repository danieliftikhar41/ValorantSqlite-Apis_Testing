package com.example.logginvalorant.Controllers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.R;


public class AgentDetaills extends Fragment {


    public AgentDetaills() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_detaillsagent, container, false);
        Bundle bundle = getArguments();
        TextView Name = (TextView) view.findViewById(R.id.Namedetaill);
        Agent agent = (Agent) bundle.getSerializable("Agent");

        Name.setText(agent.getName());
        return view;

    }
}