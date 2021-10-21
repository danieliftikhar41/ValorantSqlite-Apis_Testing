package com.example.logginvalorant.DB;

import android.provider.BaseColumns;

public class ValorantContract {
    private ValorantContract(){}
    public static class WeaponEntry implements BaseColumns {
        public static final String TABLE_NAME ="Weapons";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_Des_TITLE = "Text";
    }
}