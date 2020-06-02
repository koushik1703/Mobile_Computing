package com.example.locationservice;

import android.view.View;

import java.util.ArrayList;

public class ButtonList {

    static ArrayList<IButton> buttons = null;
    static ButtonList buttonList = null;

    public static ButtonList getInstance() {
        if(buttonList == null) {
            buttonList = new ButtonList();
            buttons = new ArrayList<IButton>();
        }
        return buttonList;
    }

    public void addButton(IButton button) {
        buttons.add(button);
    }

    public void setOnClickListener() {
        for(final IButton button : buttons) {
            button.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    button.actionOnClick();
                }
            });
        }
    }
}
