package com.example.phonecallenhancement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRequestPermission(View v)
    {
        ActivityCompat.requestPermissions(MainActivity.this, new String[] { "android.permission.MANAGE_OWN_CALLS", "android.permission.READ_PHONE_STATE", "android.permission.PROCESS_INCOMING_CALLS", "android.permission.PROCESS_OUTGOING_CALLS" }, 1);
    }
}