package com.example.logginvalorant.DB;

import android.provider.BaseColumns;

public class ValorantContract {
    private ValorantContract(){}
    public static class ValorantEntry implements BaseColumns {
        public static final String TABLE_Weapon ="Weapons";
        public static final String TABLE_Agent ="Agent";
        public static final String TABLE_Map ="Map";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "Name";
        public static final String COLUMN_WeaponType_TITLE = "WeaponType";
        public static final String COLUMN_Cost_TITLE = "Cost";

    }
}