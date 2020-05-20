package com.example.sensorreader;

import android.os.RemoteException;

public class Period extends ISensorService.Stub {

    UpdateToActivity updateToActivity = null;
    static Period period = null;

    public static Period getInstance() {
        if(period == null) {
            period = new Period();
        }
        return period;
    }

    @Override
    public void setPeriod(int period) throws RemoteException {
        if(updateToActivity != null)
            updateToActivity.timer.cancel();
        updateToActivity = new UpdateToActivity(period);
    }
}
