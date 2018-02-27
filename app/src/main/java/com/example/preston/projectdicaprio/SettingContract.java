package com.example.preston.projectdicaprio;

import android.provider.BaseColumns;

public final class SettingContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private SettingContract() {}
     public static final String SQL_CREATE_ENTRIES =
         "CREATE TABLE " + Setting.TABLE_NAME + " (" +
                 Setting._ID + " INTEGER PRIMARY KEY," +
                 Setting.COLUMN_NAME_name + " TEXT," +
                 Setting.COLUMN_NAME_age + " TEXT,"+
                 Setting.COLUMN_NAME_weight + " TEXT," +
                 Setting.COLUMN_NAME_height + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Setting.TABLE_NAME;
    /* Inner class that defines the table contents */
    public static class Setting implements BaseColumns {
        public static final String TABLE_NAME = "settings";
        public static final String COLUMN_NAME_name = "name";
        public static final String COLUMN_NAME_age = "age";
        public static final String COLUMN_NAME_weight = "weight";
        public static final String COLUMN_NAME_height = "height";
    }
}
