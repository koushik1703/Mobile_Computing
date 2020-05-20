package com.example.filedownload;

import android.view.View;
import android.widget.TextView;

public class TextViewHandler {

    static TextView textView = null;

    public static void setText(String status) {
        textView.setText(status);
    }
}
