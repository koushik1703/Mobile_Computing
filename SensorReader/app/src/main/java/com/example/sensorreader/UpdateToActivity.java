package com.example.sensorreader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;

public class UpdateToActivity extends ContextWrapper {

    static Intent intent = null;
    static Context context = null;
    Timer timer = null;
    SensorDataHandler sensorDataHandler = SensorDataHandler.getInstance();

    TimerTask updateToActivity = new TimerTask() {
        public void run() {
            intent.putExtra("GyroscopeValues", sensorDataHandler.getDataGyroscope());
            intent.putExtra("AcceleroValues", sensorDataHandler.getDataAccelerometer());
            sendBroadcast(intent);
        }
    };

    public UpdateToActivity(int period) {
        super(context);
        timer = new Timer(true);
        timer.scheduleAtFixedRate(updateToActivity, 0, period);
    }
}
