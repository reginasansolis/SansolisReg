package com.mlabs.bbm.firstandroidapp_morningclass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by reginasansolis on 10/8/16.
 */

public class MySQL extends SQLiteOpenHelper {

    public static final String TABLE_USER = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FNAME = "fnames";
    public static final String COLUMN_LNAME = "lnames";
    public static final String COLUMN_UNAME = "unames";
    public static final String COLUMN_EMAIL = "emails";
    public static final String COLUMN_PASSWORD = "passwords";
    public static final String COLUMN_DATE = "dates";

    private static final String DATABASE_NAME = "username.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_USER + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_FNAME
            + " text not null, " + COLUMN_LNAME
            + " text not null, " + COLUMN_UNAME
            + " text not null, " + COLUMN_EMAIL
            + " text not null, " + COLUMN_PASSWORD
            + " text not null, " + COLUMN_DATE
            + " text not null);";

    public MySQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQL.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

}
