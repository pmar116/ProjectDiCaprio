package com.example.preston.projectdicaprio;

import android.provider.BaseColumns;

public final class LoginContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private LoginContract() {}
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Login.TABLE_NAME + " (" +
                    Login._ID + " INTEGER PRIMARY KEY," +
                    Login.COLUMN_NAME_username + " TEXT," +
                    Login.COLUMN_NAME_password + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Login.TABLE_NAME;
    /* Inner class that defines the table contents */
    public static class Login implements BaseColumns {
        public static final String TABLE_NAME = "login";
        public static final String COLUMN_NAME_username = "username";
        public static final String COLUMN_NAME_password = "password";
    }
}
