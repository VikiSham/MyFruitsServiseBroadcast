package com.example.myfruits.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfruits.Models.MyServiceMusic;
import com.example.myfruits.R;

public class MyMenu extends AppCompatActivity {
    Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicIntent = new Intent(this, MyServiceMusic.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.back) {
            finish();
        }
        if (itemID == R.id.on) {
            startService(musicIntent);
        }
        if (itemID == R.id.off) {
            stopService(musicIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
