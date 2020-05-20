package com.example.calculator;

import android.view.View;
import android.widget.Button;

//Class for reset button action
public class ResetButton implements IButton {

    Button button = null;

    public ResetButton(View button) {
        this.button = (Button)button;
        ButtonList.getInstance().addButton(this);
    }

    public void onClickAction() {
        MainActivity.queryTextHandler.setText("");
        MainActivity.resultTextHandler.setText("");
    }

    public Button getButton() {
        return this.button;
    }
}
