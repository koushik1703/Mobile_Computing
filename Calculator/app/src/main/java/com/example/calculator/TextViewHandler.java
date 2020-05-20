package com.example.calculator;

import android.widget.TextView;

// Class to handle text view
public class TextViewHandler {

    TextView textView;
    String value;

    public TextViewHandler(TextView textView) {
        this.textView = textView;
        this.value = "";
    }

    // Set the text view with given text
    public void setText(String text) {
        this.textView.setText(text);
        this.value = text;
    }

    // Get the text from the text view
    public String getText() {
        return this.value;
    }

    // Appending the given text to text view
    public void appendText(String text) {
        this.textView.append(text);
        this.value = this.value + text;
    }
}
