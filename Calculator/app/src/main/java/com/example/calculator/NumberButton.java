package com.example.calculator;

import android.view.View;
import android.widget.Button;

//Class for Number and Operation button action
public class NumberButton implements IButton {

    Button button = null;

    public NumberButton(View button) {
        this.button = (Button) button;
        ButtonList.getInstance().addButton(this);
    }
    public void onClickAction() {
        MainActivity.queryTextHandler.appendText(this.button.getText().toString());
    }

    public Button getButton() {
        return this.button;
    }
}
