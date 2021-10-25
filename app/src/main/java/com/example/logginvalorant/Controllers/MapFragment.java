package com.example.logginvalorant.Controllers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.R;

import java.util.ArrayList;

public class MapFragment extends Fragment {
    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;
    public MapFragment(ValorantDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_map, container, false);
        /*ArrayList<String> array_noms = new ArrayList<String>();

        array_noms.add("Map1");
        array_noms.add("Map2");
        array_noms.add("Map3");
        array_noms.add("Map4");
        array_noms.add("Map5");
        array_noms.add("Map6");
        array_noms.add("Map7");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));*/
        return view;

    }
}