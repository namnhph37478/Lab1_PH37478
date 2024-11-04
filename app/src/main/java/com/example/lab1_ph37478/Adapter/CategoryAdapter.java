package com.example.lab1_ph37478.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> categories;

    public CategoryAdapter(Context context, List<String> categories) {
        super(context, android.R.layout.simple_list_item_1, categories);
        this.context = context;
        this.categories = categories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        TextView textView = rowView.findViewById(android.R.id.text1);
        textView.setText(categories.get(position));
        return rowView;
    }
}