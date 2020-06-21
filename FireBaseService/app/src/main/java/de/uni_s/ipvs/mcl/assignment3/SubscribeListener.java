package de.uni_s.ipvs.mcl.assignment3;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SubscribeListener implements View.OnClickListener {

    DatabaseReference mRef;
    EditText subscribe_location;
    SimpleDateFormat dateFormat;
    TextView subscribe_temp;
    static SubscribeListener subscribeListener = null;


    @SuppressLint("SimpleDateFormat")
    public SubscribeListener(EditText subscribe_location, TextView subscribe_temp) {
        this.mRef = FirebaseDatabase.getInstance().getReference();
        this.subscribe_location = subscribe_location;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.subscribe_temp = subscribe_temp;
    }

    public static SubscribeListener getInstance(EditText subscribe_location, TextView subscribe_temp) {
        if(subscribeListener == null) {
            subscribeListener = new SubscribeListener(subscribe_location, subscribe_temp);
        }
        return subscribeListener;
    }

    @Override
    public void onClick(View v) {
        long currentTimeMillis = System.currentTimeMillis();
        Date resultdate = new Date(currentTimeMillis);
        mRef.child("teams").child("20").child("location").child(subscribe_location.getText().toString()).child(dateFormat.format(resultdate)).addValueEventListener(ValueListener.getInstance(subscribe_temp));
    }
}
