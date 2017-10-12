package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.RunningContract.RunningEntry;


public class RunningDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = RunningDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "habit.db";

    private static final int DATABASE_VERSION = 1;

    public RunningDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + RunningEntry.TABLE_NAME + " ("
                + RunningEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + RunningEntry.COLUMN_PLACE_NAME + " TEXT NOT NULL, "
                + RunningEntry.COLUMN_RUNNING_TIME + " INTEGER NOT NULL);";

        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}