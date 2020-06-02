package com.example.locationservice;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;

public class LocationService extends Service implements android.location.LocationListener {

    LocationServiceImpl locationServiceImpl = null;
    Location previousLocation = null;
    LocationManager locationManager = null;
    long initialTime = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        locationServiceImpl = new LocationServiceImpl();
        return locationServiceImpl;
    }

    @Override
    public int onStartCommand(Intent intent, int a, int b) {
        GPXFileLogger.context = getApplicationContext();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
        }
        return a;
    }

    @Override
    public void onLocationChanged(Location location) {
        if(previousLocation == null) {
            previousLocation = location;
            initialTime = location.getTime();
        }
        else {
            LocationServiceImpl.longitude = (float) location.getLongitude();
            LocationServiceImpl.latitude = (float) location.getLatitude();
            LocationServiceImpl.distance = locationServiceImpl.distance + location.distanceTo(previousLocation);
            LocationServiceImpl.speed = LocationServiceImpl.distance * 1000 / (location.getTime() - initialTime);
        }
        previousLocation = location;

        try {
            GPXFileLogger.getInstance().log(location);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onDestroy() {
        locationManager.removeUpdates(this);
        previousLocation = null;
        initialTime = 0;
        try {
            GPXFileLogger.getInstance().closeWriter();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        GPXFileLogger.gpxFileLogger = null;
    }
}
