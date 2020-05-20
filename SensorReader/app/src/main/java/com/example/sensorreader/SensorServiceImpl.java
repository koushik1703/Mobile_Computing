package com.example.sensorreader;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class SensorServiceImpl {

    SensorManager sensorManager;
    Sensor sensorGyro;
    Sensor sensorAccelero;

    public SensorServiceImpl(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        sensorGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorAccelero = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void setListener() {
        final SensorDataHandler sensorDataHandler = SensorDataHandler.getInstance();
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                    sensorDataHandler.updateDataGyroscope(event);
                } else {
                    sensorDataHandler.updateDataAccelerometer(event);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener((SensorEventListener) sensorEventListener, sensorGyro, 10000);
        sensorManager.registerListener((SensorEventListener) sensorEventListener, sensorAccelero, 10000);
    }
}
