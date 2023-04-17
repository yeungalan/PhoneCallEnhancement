package com.example.phonecallenhancement;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class ReceivingCall  extends BroadcastReceiver {
    MediaRecorder callrecorder;

    public void onReceive(Context context, Intent intent) {

        Log.d("call", "call coming: ");
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, "Hey! Calling Number : " + incomingNumber, Toast.LENGTH_LONG).show();

            String fname="rec"+System.currentTimeMillis()+".amr";
            File file=new File(context.getFilesDir(),fname);

            callrecorder=new MediaRecorder();
            callrecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION);
            callrecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            callrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            callrecorder.setOutputFile(file.getAbsolutePath());
            try {
                callrecorder.prepare();
                callrecorder.start();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            if(callrecorder != null) {
                callrecorder.stop();
                callrecorder.reset();
            }
            Toast.makeText(context, "Hanged!", Toast.LENGTH_LONG).show();
        }
    }

    }
