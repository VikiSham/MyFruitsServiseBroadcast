package com.example.myfruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bSimple, bCustom, bRecycler;
    Intent musicIntent;
    MyCallReceiver phoneReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();

        bSimple=findViewById(R.id.bSimple);
        bCustom=findViewById(R.id.bCustom);
        bRecycler=findViewById(R.id.bCustom3);
        bSimple.setOnClickListener(this);
        bCustom.setOnClickListener(this);
        bRecycler.setOnClickListener(this);

        phoneReceiver=new MyCallReceiver();
        musicIntent = new Intent(this, MyServiceMusic.class);
        registerReceiver(phoneReceiver,
                new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED));
    }
    @Override
    protected void onDestroy() {
        unregisterReceiver(phoneReceiver);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            int itemID=item.getItemId();

            if(itemID==R.id.back){
                finish();
            }
            if(itemID==R.id.on){
                startService(musicIntent);
            }
            if(itemID==R.id.off){
                stopService(musicIntent);
            }
            return super.onOptionsItemSelected(item);
        }

    @Override
    public void onClick(View v) {
        if(v==bSimple)
        {
            Intent go=new Intent(this, SimpleDesignList.class);
            startActivity(go);
        }

        if(v==bCustom)
        {
            Intent go=new Intent(this, CustomDesignList.class);
            startActivity(go);
        }
        if(v==bRecycler)
        {
            Intent go=new Intent(this, RecyclerViewList.class);
            startActivity(go);
        }
    }

    // בדיקת הרשאות בזמן ריצה
    private void checkPermissions() {
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) ||
                (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED)) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG},
                    1);
        }
    }
}