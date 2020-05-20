package com.example.sensorreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadCastReceiverImpl {

    static BroadcastReceiver broadcastReceiver = null;

    public static BroadcastReceiver getInstance() {
        if(broadcastReceiver == null) {
            broadcastReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    float[] gyroscopeValues = intent.getFloatArrayExtra("GyroscopeValues");
                    float[] acceleroValues = intent.getFloatArrayExtra("AcceleroValues");

                    GyroscopeTextViewHandler.getInstance().updateValue(gyroscopeValues);
                    AccelerometerTextViewHandler.getInstance().updateValue(acceleroValues);
                }
            };
        }
        return broadcastReceiver;
    }

}
