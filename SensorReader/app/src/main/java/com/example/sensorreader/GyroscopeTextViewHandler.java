package com.example.sensorreader;

import android.view.View;
import android.widget.TextView;

public class GyroscopeTextViewHandler {

    TextView xAxis = null;
    TextView yAxis = null;
    TextView zAxis = null;
    static GyroscopeTextViewHandler gyroscopeTextViewHandler = null;

    public static GyroscopeTextViewHandler getInstance() {
        if(gyroscopeTextViewHandler == null) {
            gyroscopeTextViewHandler = new GyroscopeTextViewHandler();
        }
        return  gyroscopeTextViewHandler;
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
