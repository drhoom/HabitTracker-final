package com.example.android.habittracker.data;

import android.provider.BaseColumns;

public final class RunningContract {

    private RunningContract() {
    }

    public static final class RunningEntry implements BaseColumns {

        public final static String TABLE_NAME = "running";

        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the place to do the running activity.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_PLACE_NAME = "name";


        /**
         * Running time in minutes.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_RUNNING_TIME = "time";
    }
}