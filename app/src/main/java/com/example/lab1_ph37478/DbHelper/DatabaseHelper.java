package com.example.lab1_ph37478.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "qlbanhang.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCategory = "CREATE TABLE tb_cat (\n" +
                "    id   INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "    name         UNIQUE\n" +
                "                 NOT NULL\n" +
                ");\n";
        String sqlProduct = "CREATE TABLE tb_product (\n" +
                "    id     INTEGER REFERENCES tb_cat (id),\n" +
                "    name   TEXT    UNIQUE\n" +
                "                   NOT NULL,\n" +
                "    price  INTEGER NOT NULL,\n" +
                "    id_cat INTEGER NOT NULL\n" +
                ");\n";
        db.execSQL(sqlProduct);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion){
            db.execSQL("DROP TABLE IF EXISTS tb_cat");
            db.execSQL("DROP TABLE IF EXISTS tb_product");
            onCreate(db);
        }
    }
}