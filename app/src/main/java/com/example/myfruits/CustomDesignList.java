package com.example.myfruits;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * This activity create design list with text and images
 * @author Viktorya Shamagov
 */
public class CustomDesignList extends AppCompatActivity {
     ArrayList<Fruit> list;
     ListView listView;
     FruitAdapter adapter;
     String[] fruitNames= {"apple", "apricot", "banana", "cherry", "coconut", "grapes",
                           "kiwi","mango", "melon","orange", "peach","pear",
                           "pineapple","strawberry", "watermelon"};
     int[] imageResourceArray= {R.drawable.apple,R.drawable.apricot,R.drawable.banana,
                                R.drawable.cherry,R.drawable.coconut,R.drawable.grapes,
                                R.drawable.kiwi,R.drawable.mango,R.drawable.melon,R.drawable.orange,
                                R.drawable.peach,R.drawable.pear,R.drawable.pineapple,
                                R.drawable.strawberry,R.drawable.watermelon};
     int[] arrCounter=new int[15];// array counters to check rows
     int sum=0;

    /**
     * This is first method that create and start activity
     * In this method initialize properties of class and
     * view all graphics objects
     * @param savedInstanceState help the activity to start UI
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_design_list);

        for(int i = 0; i< arrCounter.length;i++)
            arrCounter[i] = 0;

        listView=findViewById(R.id.lvCustom);
        list=new ArrayList<>();
        for(int i=0; i<fruitNames.length;i++)
          list.add(new Fruit(fruitNames[i],
                   (int)((Math.random() * (100 - 10 + 1)) + 10),
                    imageResourceArray[i]));

        //Connect all data to all elements in the list
        //Layout where we defined what one element in the list would look like
        adapter=new FruitAdapter(this,R.layout.my_custom_list,this.list);
        //Connect the full list of data to xml
        this.listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrCounter[position]++;
                if( arrCounter[position] %2==1)
                {
                    view.setBackgroundColor(Color.parseColor("#EBBEF3"));
                    list.get(position).setColor(Color.parseColor("#EBBEF3"));
                    sum+=list.get(position).getFruitWeight();
                }
                else
                {
                    view.setBackgroundColor(Color.TRANSPARENT);
                    list.get(position).setColor(Color.TRANSPARENT);
                    sum-=list.get(position).getFruitWeight();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(0,1,0,"Main");
        menu.add(0,2,0,"Total Weight");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID=item.getItemId();

        if(itemID==R.id.back){
            finish();
        }

        if(itemID==1)
        {
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if(itemID==2) {
            Toast.makeText(this, "Total Weight = "+sum+" gramm", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}