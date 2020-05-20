package com.example.sensorreader;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    static ISensorService sensorService = null;
    static int period = 1000;
    static TextView periodView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        periodView = findViewById(R.id.period);
        periodView.setText(""+period);

        PeriodButton plusButton = new PlusButton((Button)findViewById(R.id.plus));
        PeriodButton minusButton = new MinusButton((Button)findViewById(R.id.minus));

        plusButton.setOnClickListner();
        minusButton.setOnClickListner();

        Intent intent = new Intent(this, SensorService.class);

        startService(intent);

        bindService(intent, this, BIND_AUTO_CREATE);

        GyroscopeTextViewHandler.getInstance().setView(findViewById(R.id.gyroscope1), findViewById(R.id.gyroscope2), findViewById(R.id.gyroscope3));

        AccelerometerTextViewHandler.getInstance().setView(findViewById(R.id.accelero1), findViewById(R.id.accelero2), findViewById(R.id.accelero3));
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        sensorService = ISensorService.Stub.asInterface(service);
        registerReceiver();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        sensorService = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(sensorService != null)
            registerReceiver();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(BroadCastReceiverImpl.getInstance());
    }

    public void registerReceiver() {
        registerReceiver(BroadCastReceiverImpl.getInstance(), new IntentFilter("com.example.sensorreader"));
    }

    public static void setPeriod() {
        try {
            sensorService.setPeriod(period);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
