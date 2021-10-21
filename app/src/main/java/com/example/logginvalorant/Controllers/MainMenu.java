package com.example.logginvalorant.Controllers;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.logginvalorant.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AgentFragment()).commit();
        bottomNav.setOnNavigationItemSelectedListener(item -> {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_agent:
                            selectedFragment = new AgentFragment();
                            break;
                        case R.id.nav_map:
                            selectedFragment = new MapFragment();
                            break;
                        case R.id.nav_weapon:
                            selectedFragment = new WeaponFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragment = new AddFragment();
                            break;
                    }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });

    }}

