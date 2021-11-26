package com.example.logginvalorant.Controllers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.R;


public class MapDetails extends Fragment {



    public MapDetails() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_map_details, container, false);
        //Getting bundle Data that we transfer
        Bundle bundle = getArguments();
        TextView Name = (TextView) view.findViewById(R.id.MapName);
        Map map = (Map) bundle.getSerializable("Map");

        Name.setText(map.getName());
        return view;
    }
}