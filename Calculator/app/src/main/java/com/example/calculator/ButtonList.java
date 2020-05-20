package com.example.calculator;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

// Class to store all buttons
public class ButtonList {

    ArrayList<IButton> buttons = new ArrayList<IButton>();
    static ButtonList buttonList = null;

    public static ButtonList getInstance() {
        if(buttonList == null) {
            buttonList = new ButtonList();
        }
        return buttonList;
    }

    public void addButton(IButton button) {
        buttons.add(button);
    }

    public void setListener() {
        for(final IButton button : buttons) {
            button.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.onClickAction();
                }
            });
        }
    }
}
