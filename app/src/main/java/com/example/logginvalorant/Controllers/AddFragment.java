package com.example.logginvalorant.Controllers;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.Moduls.Map;
import com.example.logginvalorant.R;

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
        String[] ContentValue={"Content","Agent","Weapons","Map"};
        String[] WeaponValue={"Weapons Type","Sidearm","SMG","Shotgun","Rifle","Sniper","Heavy"};
        View view= inflater.inflate(R.layout.fragment_add, container, false);
        EditText name = (EditText) view.findViewById(R.id.Name);
        Button btn = (Button) view.findViewById(R.id.btn_add);
        Spinner Content=(Spinner) view.findViewById(R.id.Content);
        Spinner WeaponType=(Spinner) view.findViewById(R.id.WeaponType);
        EditText cost = (EditText) view.findViewById(R.id.Cost);
        Button Delete = (Button) view.findViewById(R.id.formateW);
        Button Upload = (Button) view.findViewById(R.id.UploadImage);
        Upload.setOnClickListener(new View.OnClickListener() {
            /* we add an event on click ,it will work only when we click on botton */
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("not implamented!");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();


            }    });

        name.setEnabled(false);
        btn.setEnabled(false);
        Delete.setEnabled(false);
        WeaponType.setEnabled(false);
        cost.setEnabled(false);

        ArrayAdapter<String> Contentadaptor=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,ContentValue);
        Content.setAdapter(Contentadaptor);
        ArrayAdapter<String> Weaponadaptor=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,WeaponValue);
        WeaponType.setAdapter(Weaponadaptor);
        Content.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String SelectContent=Content.getSelectedItem().toString();
                if(SelectContent.equals("Agent")){
                    name.setEnabled(true);
                    btn.setEnabled(true);
                    Delete.setEnabled(true);
                    WeaponType.setEnabled(false);
                    cost.setEnabled(false);
                    btn.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {
                            String Name = name.getText().toString();
                            Agent c =new Agent(Name);
                            dbHelper.insertAgent(db, c);
                            Toast.makeText(getContext(), "Added!", Toast.LENGTH_LONG).show();
                            name.setText("");
                        }});
                    Delete.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Are you sure!");
                            builder.setMessage("Do you want to formate data from table "+SelectContent)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dbHelper.DeleteTable(db,SelectContent);
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        }    });

                }else if(SelectContent.equals("Weapons")){
                    name.setEnabled(true);
                    btn.setEnabled(true);
                    Delete.setEnabled(true);
                    WeaponType.setEnabled(true);
                    cost.setEnabled(true);
                    btn.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {

                            String Name = name.getText().toString();
                            String wt = WeaponType.getSelectedItem().toString();
                            String  Cost= cost.getText().toString();

                            Weapon c =new Weapon(Name,wt,Cost);
                            dbHelper.insertWeapon(db, c);

                            Toast.makeText(getContext(), "Added!", Toast.LENGTH_LONG).show();

                            name.setText("");


                        }    });

                    Delete.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Are you sure!");
                            builder.setMessage("Do you want to formate data from table "+SelectContent)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dbHelper.DeleteTable(db,SelectContent);

                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        }    });
                }else if(SelectContent.equals("Map")){
                    name.setEnabled(true);
                    btn.setEnabled(true);
                    Delete.setEnabled(true);
                    WeaponType.setEnabled(false);
                    cost.setEnabled(false);
                    btn.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {

                            String Name = name.getText().toString();

                            Map c =new Map(Name);
                            dbHelper.insertMap(db, c);

                            Toast.makeText(getContext(), "Added!", Toast.LENGTH_LONG).show();

                            name.setText("");


                        }    });


                    Delete.setOnClickListener(new View.OnClickListener() {
                        /* we add an event on click ,it will work only when we click on botton */
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                            builder.setTitle("Are you sure!");
                            builder.setMessage("Do you want to formate data from table "+SelectContent)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dbHelper.DeleteTable(db,SelectContent);

                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        }    });
                }else{
                    name.setEnabled(false);
                    btn.setEnabled(false);
                    Delete.setEnabled(false);
                    WeaponType.setEnabled(false);
                    cost.setEnabled(false);
                    Toast.makeText(getContext(),"Plz select Content: ",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                String SelectContent=Content.getSelectedItem().toString();
                Toast.makeText(getContext(),"Valor: "+SelectContent,Toast.LENGTH_LONG);
            }

        });


        return view;
    }

}