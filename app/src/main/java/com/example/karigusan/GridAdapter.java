package com.example.karigusan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private int[] image;
    private String[] imageNames;

    public GridAdapter(Context context, int[] image, String[] imageNames) {
        this.context = context;
        this.image = image;
        this.imageNames = imageNames;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return image[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.image_name_text);

        imageView.setImageResource(image[position]); // Set the image resource
        textView.setText(imageNames[position]); // Set the text based on the position of the image

        return convertView;
    }
}
