package com.example.lab1_ph37478.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab1_ph37478.DTO.ProductDTO;
import com.example.lab1_ph37478.DbHelper.DatabaseHelper;

import java.util.ArrayList;

public class ProductDAO {
    private DatabaseHelper dbHelper;

    public ProductDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long insert(ProductDTO product) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("price", product.getPrice());
        values.put("id_cat", product.getIdCat());
        return db.insert("tb_product", null, values);
    }

    public ArrayList<ProductDTO> getAll() {
        ArrayList<ProductDTO> products = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tb_product", null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                double price = cursor.getDouble(2);
                int idCat = cursor.getInt(3);
                products.add(new ProductDTO(id, name, price, idCat));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return products;
    }
}