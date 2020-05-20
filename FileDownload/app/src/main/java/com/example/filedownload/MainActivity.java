package com.example.filedownload;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ServiceConnection{

    IFileDownloadService fileDownloadService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button downloadButton = findViewById(R.id.download);
        Button okButton = findViewById(R.id.ok);

        TextViewHandler.textView = findViewById(R.id.status);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    fileDownloadService.downloadFile();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewHandler.setText("");
            }
        });

        Intent intent = new Intent(this, FileDownloadService.class);
        startService(intent);
        bindService(intent, this, BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.fileDownloadService = IFileDownloadService.Stub.asInterface(service);
        registerReceiver(BroadCastReceiverImpl.getInstance(), new IntentFilter("com.example.filedownload"));
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        this.fileDownloadService = null;
    }
}
