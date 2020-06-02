package com.example.locationservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Button;

public class UpdateButton implements IButton, ServiceConnection {

    Button button = null;
    ILocationService locationServiceImpl = null;

    public UpdateButton(Button button) {
        this.button = button;
    }

    @Override
    public Button getButton() {
        return this.button;
    }

    @Override
    public void actionOnClick() {
        MainActivity.context.bindService(MainActivity.intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.locationServiceImpl = ILocationService.Stub.asInterface(service);
        try {
            MainActivity.longitudeTextViewHandler.updateWith(locationServiceImpl.getLongitude() + "");
            MainActivity.latitudeTextViewHandler.updateWith(locationServiceImpl.getLatitude() + "");
            MainActivity.speedTextViewHandler.updateWith(locationServiceImpl.getAverageSpeed() + " m/s");
            MainActivity.distanceTextViewHandler.updateWith(locationServiceImpl.getDistance() + " m");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
        MainActivity.context.unbindService(this);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
