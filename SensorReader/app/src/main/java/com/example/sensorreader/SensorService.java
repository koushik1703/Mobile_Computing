package com.example.sensorreader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;

public class SensorService extends Service{

    Period period = null;
    Intent intent = null;
    Context context = null;
    SensorDataHandler sensorDataHandler = null;

    @Override
    public void onCreate() {
        super.onCreate();

        intent = new Intent("com.example.sensorreader");
        context = getApplicationContext();

        UpdateToActivity.intent = intent;
        UpdateToActivity.context = context;
        
        SensorServiceImpl sensorServiceImpl = new SensorServiceImpl((SensorManager) getSystemService(context.SENSOR_SERVICE));
        sensorServiceImpl.setListener();

        period = Period.getInstance();
        try {
            period.setPeriod(1000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return this.period;
    }
}
