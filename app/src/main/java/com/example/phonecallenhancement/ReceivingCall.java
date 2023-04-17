package com.example.phonecallenhancement;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class ReceivingCall {
    public void onReceive(Context context, Intent intent) {

        Log.d("call", "call coming: ");
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Hey! Calling Number : " + incomingNumber, Toast.LENGTH_LONG).show();
        }
    }

    }
