package com.example.myfruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SimpleDesignList extends AppCompatActivity {
    ListView lvSimple;
    ArrayAdapter<String>adapter;
    String[] fruitNames= { "apple", "apricot", "banana", "cherry", "coconut", "grapes", "kiwi", "mango",
                           "melon","orange", "peach","pear","pineapple","strawberry", "watermelon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_design_list);

        lvSimple=findViewById(R.id.lvSimple);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>( this,R.layout.my_simple_list, R.id.tvSimple, fruitNames);
        lvSimple.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        menu.add(0,1,0,"Main");
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
        return super.onOptionsItemSelected(item);
    }
}