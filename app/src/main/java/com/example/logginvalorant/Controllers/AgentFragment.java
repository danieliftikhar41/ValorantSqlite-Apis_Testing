package com.example.logginvalorant.Controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.logginvalorant.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agent, container, false);
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
        array_noms.add("item16");
        array_noms.add("item17");
        array_noms.add("item18");
        array_noms.add("item19");
        array_noms.add("item20");
        array_noms.add("item21");
        array_noms.add("item22");
        array_noms.add("item23");


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
       /*
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
        */
        return view;

    }
}