package com.example.locationservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static Intent intent = null;
    static Context context = null;
    static TextViewHandler longitudeTextViewHandler = null;
    static TextViewHandler latitudeTextViewHandler = null;
    static TextViewHandler distanceTextViewHandler = null;
    static TextViewHandler speedTextViewHandler = null;
    private static final int LOCATION_PERMISSION_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longitudeTextViewHandler = new TextViewHandler("Longitude : ", (TextView) findViewById(R.id.longitude));
        latitudeTextViewHandler = new TextViewHandler("Latitude : ", (TextView) findViewById(R.id.latitude));
        distanceTextViewHandler = new TextViewHandler("Distance : ", (TextView) findViewById(R.id.distance));
        speedTextViewHandler = new TextViewHandler("Speed : ", (TextView) findViewById(R.id.speed));

        IButton stopButton = new StopButton((Button) findViewById(R.id.stop));
        ButtonList.getInstance().addButton(stopButton);
        IButton startButton = new StartButton((Button) findViewById(R.id.start));
        ButtonList.getInstance().addButton(startButton);
        IButton updateButton = new UpdateButton((Button) findViewById(R.id.update));
        ButtonList.getInstance().addButton(updateButton);

        ButtonList.getInstance().setOnClickListener();

        intent = new Intent(this, LocationService.class);

        context = getApplicationContext();

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, LOCATION_PERMISSION_CODE);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0) {
                Toast.makeText(MainActivity.this, "Location Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Location Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == 2) {
            if (grantResults.length > 0) {
                Toast.makeText(MainActivity.this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, 2);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }
}
