package com.example.myfruits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Fruit> list;
    RecyclerCustomAdapter adapter;
    String[] fruitNames= {"apple", "apricot", "banana", "cherry", "coconut", "grapes",
            "kiwi","mango", "melon","orange", "peach","pear",
            "pineapple","strawberry", "watermelon"};
    int[] imageResourceArray= {R.drawable.apple,R.drawable.apricot,R.drawable.banana,
            R.drawable.cherry,R.drawable.coconut,R.drawable.grapes,
            R.drawable.kiwi,R.drawable.mango,R.drawable.melon,R.drawable.orange,
            R.drawable.peach,R.drawable.pear,R.drawable.pineapple,
            R.drawable.strawberry,R.drawable.watermelon};

    String fruitName;
    int fruitWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);
        recyclerView=findViewById(R.id.rv);
        list=new ArrayList<>();
        for(int i=0; i<fruitNames.length;i++)
            list.add(new Fruit(fruitNames[i],
                    (int)((Math.random() * (100 - 10 + 1)) + 10),
                    imageResourceArray[i]));

        adapter = new RecyclerCustomAdapter(list);

        recyclerView.setAdapter(adapter);

        // Choose one of these
        // vertical list
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // table list, number of colomns
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));// number of colomns
        // horizontal list
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        ItemClickListener itemClickListener = new ItemClickListener();
        RecyclerItemClickListener listener = new RecyclerItemClickListener(this, recyclerView, itemClickListener);
        recyclerView.addOnItemTouchListener(listener);
    }

    /**
     * Listener class for the RecyclerView.
     */
    public class ItemClickListener implements RecyclerItemClickListener.OnItemClickListener {
        /**
         * the onCLick method for a specific item the RecyclerView.
         * @param view
         * @param position
         */
        @Override
        public void onItemClick(View view, int position)
        {
            fruitName = list.get(position).getFruitName();
            fruitWeight = list.get(position).getFruitWeight();
            Toast.makeText(RecyclerViewList.this, "name: "+fruitName+"\nweight: "+fruitWeight,
                                    Toast.LENGTH_LONG).show();
        }

        /**
         * the onCLick method for a specific item the RecyclerView for a long click (not used).
         * @param view
         * @param position
         */
        @Override
        public void onLongItemClick(View view, int position)
        {

        }
    }
    }