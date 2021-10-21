package com.example.logginvalorant.Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logginvalorant.Controllers.RecyclerViewAdapter;
import com.example.logginvalorant.R;

import java.util.ArrayList;


public class WeaponFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view= inflater.inflate(R.layout.fragment_weapon, container, false);
        ArrayList<String> array_noms = new ArrayList<String>();


        array_noms.add("item1");
        array_noms.add("item2");
        array_noms.add("item3");
        array_noms.add("item4");
        array_noms.add("item5");
        array_noms.add("item6");
        array_noms.add("item7");
        array_noms.add("item8");
        array_noms.add("item9");
        array_noms.add("item10");
        array_noms.add("item11");
        array_noms.add("item12");
        array_noms.add("item13");
        array_noms.add("item14");
        array_noms.add("item15");



        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }
}