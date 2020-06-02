package com.example.locationservice;

import android.widget.Button;

public class StopButton implements IButton {

    Button button = null;

    public StopButton(Button button) {
        this.button = button;
    }

    @Override
    public Button getButton() {
        return this.button;
    }

    @Override
    public void actionOnClick() {
        MainActivity.context.stopService(MainActivity.intent);
    }
}
