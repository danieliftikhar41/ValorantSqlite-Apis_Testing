package com.example.logginvalorant.Controllers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.logginvalorant.Moduls.Agent;
import com.example.logginvalorant.Moduls.Weapon;
import com.example.logginvalorant.R;

import java.util.Locale;


public class WeaponDetails extends Fragment {

    public WeaponDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Getting bundle Data that we transfer
        View view=inflater.inflate(R.layout.fragment_weapon_details, container, false);
        Bundle bundle = getArguments();
        TextView Name = (TextView) view.findViewById(R.id.WeaponName);
        TextView cost = (TextView) view.findViewById(R.id.CostWeapon);
        TextView category = (TextView) view.findViewById(R.id.CategoryWeapon);
        Weapon weapon = (Weapon) bundle.getSerializable("Weapon");

        Name.setText(weapon.getName());
        cost.setText("Cost: "+weapon.getCost());
        category.setText("Type: "+weapon.getType());
        return view;
    }
}