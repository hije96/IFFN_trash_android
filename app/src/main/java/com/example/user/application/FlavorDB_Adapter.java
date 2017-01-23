package com.example.user.application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by User on 2017-01-21.
 */
public class FlavorDB_Adapter {
    private static final String DATABASE_NAME = "FlavorHistory.db";
    private static final String DATABASE_TABLE = "FH_DB";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;
    public final class DataBases {
        //static
        public final class CreateDB implements BaseColumns {

            public static final String _TABLENAME = "history";
            public static final String _CREATE =
                    "create table "+_TABLENAME+ "( " +
                            "NUMBER    INTEGER PRIMARY    KEY AUTOINCREMENT," +
                            "FLAVOR_1 INTEGER,   " +
                            "FLAVOR_2 INTEGER,  " +
                            "FLAVOR_3 INTEGER,   " +
                            "FLAVOR_4 INTEGER)";

        }
    }

    private class DatabaseHelper extends SQLiteOpenHelper {

        // 생성자
        public DatabaseHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases.CreateDB._CREATE);

        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._TABLENAME);
            onCreate(db);
        }
    }

    public   FlavorDB_Adapter(Context context){
        this.mCtx = context;
    }

    public   FlavorDB_Adapter open() throws SQLException {
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        Log.d("TEST","open");
        return this;

    }

    public void close(){
        mDB.close();
    }

    public long insert(int idx,int flavor_1,  int flavor_2, int flavor_3, int flavor_4) {
        ContentValues insertValues = new ContentValues();
        insertValues.put("IDX", idx);
        insertValues.put("FLAVOR_1", flavor_1);
        insertValues.put("FLAVOR_2", flavor_2);
        insertValues.put("FLAVOR_3", flavor_3);
        insertValues.put("FLAVOR_4", flavor_4);
        Log.d("TEST", "insert success");
        return mDB.insert(DATABASE_TABLE, null, insertValues);
    }
    public boolean deleteAll() {

        return mDB.delete(DATABASE_TABLE, null, null) > 0;
    }
    public Cursor AllRows() {

        return mDB.query(DATABASE_TABLE, null, null, null, null, null, null);

    }
}

