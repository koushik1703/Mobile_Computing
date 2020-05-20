package com.example.sensorreader;

import android.widget.Button;

public class MinusButton extends PeriodButton {

    public MinusButton(Button button) {
        super(button);
    }

    @Override
    public void doUpdate() {
        if(MainActivity.sensorService != null) {
            MainActivity.period = MainActivity.period - 1;
            MainActivity.periodView.setText(""+MainActivity.period);
            MainActivity.setPeriod();
        }
    }
}
