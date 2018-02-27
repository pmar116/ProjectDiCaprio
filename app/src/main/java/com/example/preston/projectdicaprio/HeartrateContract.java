package com.example.preston.projectdicaprio;

import android.provider.BaseColumns;

public final class HeartrateContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private HeartrateContract() {}
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Heartrate.TABLE_NAME + " (" +
                    Heartrate._ID + " INTEGER PRIMARY KEY," +
                    Heartrate.COLUMN_NAME_username + " TEXT," +
                    Heartrate.COLUMN_NAME_heartrate + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Heartrate.TABLE_NAME;
    /* Inner class that defines the table contents */
    public static class Heartrate implements BaseColumns {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_NAME_username = "username";
        public static final String COLUMN_NAME_heartrate = "heartrate";
    }
}
