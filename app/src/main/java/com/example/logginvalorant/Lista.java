package com.example.logginvalorant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
}