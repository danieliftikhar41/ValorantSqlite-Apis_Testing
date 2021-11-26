package com.example.logginvalorant.Controllers;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.logginvalorant.DB.ValorantDBHelper;
import com.example.logginvalorant.R;

public class MainMenu extends AppCompatActivity {
    private ValorantDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        dbHelper = new ValorantDBHelper(this);
        db = dbHelper.getWritableDatabase();

        BottomNavigationView bottomNav = findViewById(R.id.main_menu);
        //Bottom Menu on Switch change fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AgentFragment(dbHelper, db)).commit();
        bottomNav.setOnNavigationItemSelectedListener(item -> {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_agent:
                            selectedFragment = new AgentFragment(dbHelper, db);
                            break;
                        case R.id.nav_map:
                            selectedFragment = new MapFragment(dbHelper, db);
                            break;
                        case R.id.nav_weapon:
                            selectedFragment = new WeaponFragment(dbHelper, db);
                            break;
                        case R.id.nav_add:
                            selectedFragment = new AddFragment(dbHelper, db);
                            break;
                    }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}

