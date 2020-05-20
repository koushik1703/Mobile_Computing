package com.example.sensorreader;

import android.view.View;
import android.widget.TextView;

public class AccelerometerTextViewHandler {

    TextView xAxis = null;
    TextView yAxis = null;
    TextView zAxis = null;
    static AccelerometerTextViewHandler accelerometerTextViewHandler = null;

    public static AccelerometerTextViewHandler getInstance() {
        if(accelerometerTextViewHandler == null) {
            accelerometerTextViewHandler = new AccelerometerTextViewHandler();
        }
        return  accelerometerTextViewHandler;
    }

    public void setView(View xAxisView, View yAxisView, View zAxisView) {
        this.xAxis = (TextView) xAxisView;
        this.yAxis = (TextView) yAxisView;
        this.zAxis = (TextView) zAxisView;
    }

    public void updateValue(float[] value) {
        this.xAxis.setText(""+value[0]);
        this.yAxis.setText(""+value[1]);
        this.zAxis.setText(""+value[2]);
    }
}
