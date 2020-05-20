package com.example.calculator;

import android.view.View;
import android.widget.Button;

//Class for equal to button action
public class EqualButton implements IButton {

    Button button = null;

    public EqualButton(View button) {
        this.button = (Button)button;
        ButtonList.getInstance().addButton(this);
    }

    public void onClickAction() {
        String queryText = MainActivity.queryTextHandler.getText();
        Calculation calc = Calculation.getInstance();
        MainActivity.resultTextHandler.setText("= " + calc.calculate(queryText));
    }

    public Button getButton() {
        return this.button;
    }
}
