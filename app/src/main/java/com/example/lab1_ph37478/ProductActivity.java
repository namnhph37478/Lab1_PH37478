package com.example.lab1_ph37478;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listView = findViewById(R.id.listViewProducts);
        products = new ArrayList<>();

        addSampleData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
        });
    }

    private void addSampleData() {
        products.add("Product 1");
        products.add("Product 2");
        products.add("Product 3");
    }
}