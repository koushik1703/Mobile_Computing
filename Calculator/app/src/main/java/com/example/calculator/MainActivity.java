package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextViewHandler queryTextHandler;
    static TextViewHandler resultTextHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring view object from Activity
        TextView queryView = findViewById(R.id.query);
        TextView resultView = findViewById(R.id.result);

        IButton number0 = new NumberButton(findViewById(R.id.number0));
        IButton number1 = new NumberButton(findViewById(R.id.number1));
        IButton number2 = new NumberButton(findViewById(R.id.number2));
        IButton number3 = new NumberButton(findViewById(R.id.number3));
        IButton number4 = new NumberButton(findViewById(R.id.number4));
        IButton number5 = new NumberButton(findViewById(R.id.number5));
        IButton number6 = new NumberButton(findViewById(R.id.number6));
        IButton number7 = new NumberButton(findViewById(R.id.number7));
        IButton number8 = new NumberButton(findViewById(R.id.number8));
        IButton number9 = new NumberButton(findViewById(R.id.number9));

        IButton point = new NumberButton(findViewById(R.id.point));

        IButton add = new NumberButton(findViewById(R.id.add));
        IButton sub = new NumberButton(findViewById(R.id.sub));
        IButton mul = new NumberButton(findViewById(R.id.mul));
        IButton div = new NumberButton(findViewById(R.id.div));

        IButton reset = new ResetButton(findViewById(R.id.reset));

        IButton equal = new EqualButton(findViewById(R.id.equal));

        // Adding listener to button list
        ButtonList.getInstance().setListener();

        // Creation of object to handling the text view
        queryTextHandler = new TextViewHandler(queryView);
        resultTextHandler = new TextViewHandler(resultView);
    }

}
