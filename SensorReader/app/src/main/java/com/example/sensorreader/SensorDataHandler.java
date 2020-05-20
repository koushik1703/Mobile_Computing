package com.example.sensorreader;

import android.hardware.SensorEvent;

public class SensorDataHandler {

    float[] gyroscopeValue = null;
    float[] acceleroValue = null;
    static SensorDataHandler sensorDataHandler = null;

    public SensorDataHandler() {
        gyroscopeValue = new float[3];
        acceleroValue = new float[3];
    }

    public static SensorDataHandler getInstance() {
        if(sensorDataHandler == null) {
            sensorDataHandler = new SensorDataHandler();
        }
        return sensorDataHandler;
    }

    public float[] getDataGyroscope() {
        return this.gyroscopeValue;
    }

    public float[] getDataAccelerometer() {
        return this.acceleroValue;
    }

    public void updateDataGyroscope(SensorEvent event) {
        for(int i = 0; i < 3; i++) {
            gyroscopeValue[i] = event.values[i];
        }
    }

    public void updateDataAccelerometer(SensorEvent event) {
        for(int i = 0; i < 3; i++) {
            acceleroValue[i] = event.values[i];
        }
    }
}
