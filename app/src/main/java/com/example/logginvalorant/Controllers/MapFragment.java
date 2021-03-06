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

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;

public class MapFragment extends Fragment implements SelectListner{
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
        MapAdaptor adapter = new MapAdaptor(arrayMap,this);
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
        //transfer Data Via bundle after on click fucntion that we used in Adaptor
        Bundle bundle = new Bundle();
        bundle.putSerializable("Map", map);
        MapDetails details= new MapDetails();
        details.setArguments(bundle);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, details).commit();

    }

    @Override
    public void onItemClicked(Weapon weapon) {


    }
}