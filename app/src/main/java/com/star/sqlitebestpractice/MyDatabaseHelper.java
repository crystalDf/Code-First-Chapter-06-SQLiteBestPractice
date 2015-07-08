package com.star.sqlitebestpractice;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "CREATE TABLE BOOK(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "author TEXT, " +
            "price REAL, " +
            "pages INTEGER, " +
            "name TEXT)";

    public static final String CREATE_CATEGORY = "CREATE TABLE CATEGORY(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "category_name TEXT, " +
            "category_code INTEGER)";

    public static final String DROP_BOOK = "DROP TABLE IF EXISTS BOOK";

    public static final String DROP_CATEGORY = "DROP TABLE IF EXISTS CATEGORY";

    public static final String ALTER_BOOK = "ALTER TABLE BOOK ADD COLUMN category_id INTEGER";

    private Context mContext;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(CREATE_CATEGORY);
            case 2:
                db.execSQL(ALTER_BOOK);
            default:
        }
    }
}
