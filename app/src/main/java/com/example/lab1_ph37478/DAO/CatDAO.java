package com.example.lab1_ph37478.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_ph37478.DTO.CatDTO;
import com.example.lab1_ph37478.DbHelper.DatabaseHelper;

import java.util.ArrayList;

    public class CatDAO {
        private DatabaseHelper dbHelper;

        public CatDAO(Context context) {
            dbHelper = new DatabaseHelper(context);
        }

        public long insert(CatDTO cat) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("name", cat.getName());
            return db.insert("tb_cat", null, values);
        }

        public ArrayList<CatDTO> getAll() {
            ArrayList<CatDTO> cats = new ArrayList<>();
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM tb_cat", null);
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    cats.add(new CatDTO(id, name));
                } while (cursor.moveToNext());
            }
            cursor.close();
            return cats;
        }
    }
