package com.example.logginvalorant.Controllers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.logginvalorant.DB.ValorantContract;
import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

public class AddFragment extends Fragment {
    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;

    public void AddFragment(ValorantDBHelper dbHelper,SQLiteDatabase db){
        this.dbHelper=dbHelper;
        this.db=db;
    }
    public void AddFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        dbHelper = new ValorantDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
        EditText edtText = (EditText) view.findViewById(R.id.NameWeapon);
        EditText Des = (EditText) view.findViewById(R.id.Details);
        Button btn = (Button) view.findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            /* we add an event on click ,it will work only when we click on botton */
            @Override
            public void onClick(View v) {

                String Name = edtText.getText().toString();
                String Details = Des.getText().toString();
                Weapon c =new Weapon(Name,Details);
                dbHelper.insertContact(db, c);


            }    });
        return view;
    }
}