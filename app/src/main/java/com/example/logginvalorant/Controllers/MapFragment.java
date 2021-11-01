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
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.Moduls.Weapon;
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
        ArrayList<Map> arrayMap = new ArrayList<>();
        dbHelper.selectData_Map(db,arrayMap);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        MapAdaptor adapter = new MapAdaptor(arrayMap);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;

    }
}