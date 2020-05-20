package com.example.filedownload;

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
                    String status = intent.getStringExtra("Status");
                    TextViewHandler.setText(status);
                }
            };
        }
        return broadcastReceiver;
    }

}
