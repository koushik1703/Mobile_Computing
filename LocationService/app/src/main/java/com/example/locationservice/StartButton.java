package com.example.locationservice;

import android.widget.Button;

public class StartButton implements IButton {

    Button button = null;

    public StartButton(Button button) {
        this.button = button;
    }

    @Override
    public Button getButton() {
        return this.button;
    }

    @Override
    public void actionOnClick() {
        MainActivity.context.startService(MainActivity.intent);
    }
}
