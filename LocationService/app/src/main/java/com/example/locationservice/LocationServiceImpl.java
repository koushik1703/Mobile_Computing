package com.example.locationservice;

import android.os.RemoteException;

public class LocationServiceImpl extends ILocationService.Stub {

    static float longitude = 0;
    static float latitude = 0;
    static float distance = 0;
    static float speed = 0;

    @Override
    public float getLatitude() throws RemoteException {
        return longitude;
    }

    @Override
    public float getLongitude() throws RemoteException {
        return latitude;
    }

    @Override
    public float getDistance() throws RemoteException {
        return distance;
    }

    @Override
    public float getAverageSpeed() throws RemoteException {
        return speed;
    }
}
