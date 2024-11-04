package com.example.lab1_ph37478;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_ph37478.Adapter.ProductAdapter;
import com.example.lab1_ph37478.DTO.ProductDTO;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ProductDTO> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listView = findViewById(R.id.listViewProducts);
        products = new ArrayList<ProductDTO>();

        // Tạm thêm dữ liệu
        addSampleData();

        // Sử dụng ProductAdapter
        ProductAdapter adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Xử lý nhấn chọn sản phẩm
        });
    }

    private void addSampleData() {
        // Thêm dữ liệu tạm cho sản phẩm
        products.add(new ProductDTO(1, "Product 1", 100.0, 1));
        products.add(new ProductDTO(2, "Product 2", 200.0, 1));
        products.add(new ProductDTO(3, "Product 3", 150.0, 2));
    }
}