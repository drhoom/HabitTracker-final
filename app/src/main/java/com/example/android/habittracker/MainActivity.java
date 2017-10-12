package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.habittracker.data.RunningDbHelper;
import com.example.android.habittracker.data.RunningContract.RunningEntry;

public class MainActivity extends AppCompatActivity {

    private RunningDbHelper mDbHelper;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new RunningDbHelper(this);
        insertRunningActivity();
        Cursor c = readFromDatabase();
    }

    private Cursor readFromDatabase() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                RunningEntry._ID,
                RunningEntry.COLUMN_PLACE_NAME,
                RunningEntry.COLUMN_RUNNING_TIME};

        Cursor cursor = db.query(
                RunningEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        try {
            int idColumnIndex = cursor.getColumnIndex(RunningEntry._ID);
            int placeColumnIndex = cursor.getColumnIndex(RunningEntry.COLUMN_PLACE_NAME);
            int timeColumnIndex = cursor.getColumnIndex(RunningEntry.COLUMN_RUNNING_TIME);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentPlace = cursor.getString(placeColumnIndex);
                int currentTime = cursor.getInt(timeColumnIndex);

                Log.i(TAG, currentID + ". Running Place: " + currentPlace + ", Duration: " + currentTime + "min");
            }
        } finally {
            cursor.close();
        }

        return cursor;
    }

    private void insertRunningActivity() {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RunningEntry.COLUMN_PLACE_NAME, "Riyadh");
        values.put(RunningEntry.COLUMN_RUNNING_TIME, "30");

        long newRowId = db.insert(RunningEntry.TABLE_NAME, null, values);
        Log.i(TAG, "New row inserted with id: " + newRowId);
    }
}
