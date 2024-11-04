package com.example.lab1_ph37478.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lab1_ph37478.DTO.ProductDTO;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductDTO> {
    private final Context context;
    private final List<ProductDTO> products;

    public ProductAdapter(Context context, List<ProductDTO> products) {
        super(context, android.R.layout.simple_list_item_1, products);
        this.context = context;
        this.products = products;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        TextView textViewName = rowView.findViewById(android.R.id.text1);
        TextView textViewPrice = rowView.findViewById(android.R.id.text2);

        ProductDTO product = products.get(position);
        textViewName.setText(product.getName());
        textViewPrice.setText(String.format("Price: %.2f", product.getPrice()));

        return rowView;
    }
}