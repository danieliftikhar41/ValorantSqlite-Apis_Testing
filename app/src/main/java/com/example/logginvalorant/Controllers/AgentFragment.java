package com.example.logginvalorant.Controllers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.R;

import java.util.ArrayList;

/**

 */
public class AgentFragment extends Fragment implements SelectListner {

    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;
    public AgentFragment(ValorantDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agent, container, false);
        ArrayList<Agent> arrayAgent = new ArrayList<>();
        dbHelper.selectData_Agent(db,arrayAgent);


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        AgentAdaptor adapter = new AgentAdaptor(arrayAgent,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Seleccion "+arrayAgent.get(recyclerView.getChildAdapterPosition(view)).getName(),Toast.LENGTH_SHORT ).show();
                Toast.makeText(getContext(),"Seleccion heww",Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));


        return view;

    }

    @Override
    public void onItemClicked(Agent agent) {
        Toast.makeText(getContext(),"Selected: "+agent.getName(),Toast.LENGTH_SHORT).show();
    }
}