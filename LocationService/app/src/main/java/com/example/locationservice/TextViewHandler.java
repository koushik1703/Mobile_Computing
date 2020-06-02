package com.example.locationservice;

import android.widget.TextView;

public class TextViewHandler {

    String defaultText = "";
    TextView textView = null;

    public TextViewHandler(String defaultText , TextView textView) {
        this.defaultText = defaultText;
        this.textView = textView;
    }

    public void updateWith(String value) {
        textView.setText(defaultText + value);
    }
}
