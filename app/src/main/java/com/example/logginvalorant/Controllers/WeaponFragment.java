package com.example.logginvalorant.Controllers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;


public class WeaponFragment extends Fragment implements SelectListner {
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
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(arrayWeapon,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }
    @Override
    public void onItemClicked(Agent agent) {

    }

    @Override
    public void onItemClicked(Map map) {

    }

    @Override
    public void onItemClicked(Weapon weapon) {
        Bundle bundle = new Bundle();
        //transfer Data Via bundle after on click fucntion that we used in Adaptor
        bundle.putSerializable("Weapon", weapon);
        WeaponDetails weapons= new WeaponDetails();
        weapons.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, weapons).commit();

    }
}