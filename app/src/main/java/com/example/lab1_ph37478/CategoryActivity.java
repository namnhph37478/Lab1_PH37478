package com.example.lab1_ph37478;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_ph37478.Adapter.CategoryAdapter;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = findViewById(R.id.listViewCategories);
        categories = new ArrayList<>();

        addSampleData();

        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
                intent.putExtra("categoryId", position);
                startActivity(intent);
            }
        });
    }

    private void addSampleData() {
        categories.add("Category 1");
        categories.add("Category 2");
        categories.add("Category 3");
    }
}