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

import com.example.logginvalorant.Controllers.RecyclerViewAdapter;
import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;


public class WeaponFragment extends Fragment {
    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;

    public WeaponFragment(ValorantDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }


    public void WeaponFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_weapon, container, false);
        ArrayList<Weapon> arrayWeapon = new ArrayList<>();
        dbHelper.selectData_Weapon(db,arrayWeapon);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayWeapon);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }
}