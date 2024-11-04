package com.example.lab1_ph37478;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_ph37478.Adapter.ProductAdapter;
import com.example.lab1_ph37478.DAO.ProductDAO;
import com.example.lab1_ph37478.DTO.ProductDTO;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private Button btn_add, btn_update, btn_delete;
    private EditText editTextProductName;
    private ListView listView;
    private ArrayList<ProductDTO> products;
    private ProductAdapter adapter;
    private ProductDTO selectedProduct; // Store selected product for update/delete

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        listView = findViewById(R.id.listViewProducts);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        editTextProductName = findViewById(R.id.ed_catname);


        products = new ArrayList<>();
        addSampleData();

        adapter = new ProductAdapter(this, products);
        listView.setAdapter(adapter);

        btn_add.setOnClickListener(v -> addProduct());
        btn_update.setOnClickListener(v -> {
            if (selectedProduct != null) {
                updateProduct(selectedProduct);
            }
        });
        btn_delete.setOnClickListener(v -> {
            if (selectedProduct != null) {
                deleteProduct(selectedProduct.getId());
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedProduct = products.get(position);
            editTextProductName.setText(selectedProduct.getName());
        });


    }

    private void addProduct() {
        ProductDTO newProduct = new ProductDTO(0, "New Product", 50.0, 1);
        new ProductDAO(this).insert(newProduct);
        products.add(newProduct);
        adapter.notifyDataSetChanged();
    }

    private void updateProduct(ProductDTO product) {
        product.setName("Updated Product");
        product.setPrice(60.0);
        new ProductDAO(this).update(product);
        adapter.notifyDataSetChanged();
    }

    private void deleteProduct(int productId) {
        new ProductDAO(this).delete(productId);
        products.removeIf(p -> p.getId() == productId);
        adapter.notifyDataSetChanged();
    }

    private void addSampleData() {
        // Sample data
        products.add(new ProductDTO(1, "Product 1", 100.0, 1));
        products.add(new ProductDTO(2, "Product 2", 200.0, 1));
        products.add(new ProductDTO(3, "Product 3", 150.0, 2));
    }
}
