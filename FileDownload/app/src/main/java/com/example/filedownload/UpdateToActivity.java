package com.example.filedownload;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

public class UpdateToActivity extends ContextWrapper {

    Intent intent = null;

    public UpdateToActivity(Context base) {
        super(base);
    }

    public void updateToUI(String status) {
        intent = new Intent("com.example.filedownload");
        intent.putExtra("Status", status);
        sendBroadcast(intent);
    }
}
