package de.uni_s.ipvs.mcl.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText write_location = findViewById(R.id.write_location);
        final EditText write_temp = findViewById(R.id.write_temp);

        Button write_button = findViewById(R.id.write_button);

        final EditText read_location = findViewById(R.id.read_location);
        final TextView read_temp = findViewById(R.id.read_temp);

        Button read_button = findViewById(R.id.read_button);

        final EditText subscribe_location = findViewById(R.id.subscribe_location);
        final TextView subscribe_temp = findViewById(R.id.subscribe_temp);

        Button subscribe_button = findViewById(R.id.subscribe_button);

        write_button.setOnClickListener(WriteListener.getInstance(write_location, write_temp));

        read_button.setOnClickListener(ReadListener.getInstance(read_location, read_temp));

        subscribe_button.setOnClickListener(SubscribeListener.getInstance(subscribe_location, subscribe_temp));
    }
}
