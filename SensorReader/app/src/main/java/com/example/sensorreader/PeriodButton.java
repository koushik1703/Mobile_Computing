package com.example.sensorreader;

import android.view.View;
import android.widget.Button;

public class PeriodButton {

    Button button = null;

    public PeriodButton(Button button) {
        this.button = button;
    }

    public void setOnClickListner() {
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doUpdate();
            }
        });
    }

    public void doUpdate() {
        this.doUpdate();
    }
}
