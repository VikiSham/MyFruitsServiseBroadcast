package com.example.myfruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class FruitAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Fruit> list;
    private int layout;

    public FruitAdapter(@NonNull Context context, int layout, @NonNull ArrayList<Fruit> list)
    {
        super(context, layout, list);
        this.context=context;
        this.layout=layout;
        this.list=list;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        //inflate XML into visual
        LayoutInflater layoutInflater= ((AppCompatActivity)context).getLayoutInflater();
        //create view object from custom Layout XML
        View view = layoutInflater.inflate(layout,parent,false);

        //get a reference to a fruit object
        Fruit fruit=this.list.get(position);

        //reference to inflated view elements
        //custom layout views
        TextView tvName=view.findViewById(R.id.tvName);
        TextView tvWeight=view.findViewById(R.id.tvWeight);
        ImageView ivCustom=view.findViewById(R.id.ivCustom);
        LinearLayout idLinear=view.findViewById(R.id.idLinear);

        //placement of *data* from the department to the elements
        tvName.setText(fruit.getFruitName());
        //string element
        tvWeight.setText(String.valueOf(fruit.getFruitWeight())+" gramm");
        ivCustom.setImageResource(fruit.getFruitImageId());
        idLinear.setBackgroundColor(fruit.getColor());

        return view;//return view with data the list
    }


}
