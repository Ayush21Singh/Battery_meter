package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView BaterryLevel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaterryLevel=findViewById(R.id.txt_battery_level);

        this.registerReceiver(this.myBatteyReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    BroadcastReceiver myBatteyReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            double  batteylevel= intent.getIntExtra("level",0);
            BaterryLevel.setText("Battery Status:"+batteylevel);
        }
    };
}