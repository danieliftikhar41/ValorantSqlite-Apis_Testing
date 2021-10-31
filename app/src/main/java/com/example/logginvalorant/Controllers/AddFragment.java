package com.example.logginvalorant.Controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.ArrayList;

public class AddFragment extends Fragment {
    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;

    public AddFragment(ValorantDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper=dbHelper;
        this.db=db;
    }
    public void AddFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<String> ContentValue=new ArrayList<String>();
        ContentValue.add("Agent");
        ContentValue.add("Map");
        ContentValue.add("Weapon");
        ArrayList<String> WeaponValue=new ArrayList<String>();
        WeaponValue.add("Sidearm");
        WeaponValue.add("SMG");
        WeaponValue.add("Shotgun");
        WeaponValue.add("Rifle");
        WeaponValue.add("Sniper");
        WeaponValue.add("Heavy");
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        EditText name = (EditText) view.findViewById(R.id.Name);
        Button btn = (Button) view.findViewById(R.id.btn_add);
        Spinner Content=(Spinner) view.findViewById(R.id.Content);
        Spinner WeaponType=(Spinner) view.findViewById(R.id.WeaponType);
        EditText cost = (EditText) view.findViewById(R.id.Cost);
        Button Delete = (Button) view.findViewById(R.id.formateW);
        name.setEnabled(false);
        btn.setEnabled(false);
        Delete.setEnabled(false);
        WeaponType.setEnabled(false);
        cost.setEnabled(false);





        btn.setOnClickListener(new View.OnClickListener() {
            /* we add an event on click ,it will work only when we click on botton */
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();

                Weapon c =new Weapon(Name);
                dbHelper.insertContact(db, c);

                Toast.makeText(getContext(), "Added!", Toast.LENGTH_LONG).show();

                name.setText("");


            }    });


        Delete.setOnClickListener(new View.OnClickListener() {
            /* we add an event on click ,it will work only when we click on botton */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Are you sure!");
                builder.setMessage("Do you want to formate ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbHelper.DeleteTable(db);

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();


            }    });
        return view;
    }
}