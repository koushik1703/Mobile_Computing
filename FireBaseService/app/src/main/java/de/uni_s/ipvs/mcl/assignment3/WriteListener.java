package de.uni_s.ipvs.mcl.assignment3;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteListener implements View.OnClickListener {

    DatabaseReference mRef;
    EditText write_location;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;
    TextView write_temp;
    static WriteListener writeListener = null;

    @SuppressLint("SimpleDateFormat")
    public WriteListener(EditText write_location, TextView write_temp) {
        this.mRef = FirebaseDatabase.getInstance().getReference();
        this.write_location = write_location;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.timeFormat = new SimpleDateFormat("HH:mm:ss");
        this.write_temp = write_temp;
    }

    public static WriteListener getInstance(EditText write_location, TextView write_temp) {
        if(writeListener == null) {
            writeListener = new WriteListener(write_location, write_temp);
        }
        return writeListener;
    }

    @Override
    public void onClick(View v) {
        long currentTimeMillis = System.currentTimeMillis();
        Date resultdate = new Date(currentTimeMillis);
        mRef.child("teams").child("20").child("location").child(write_location.getText().toString()).child(dateFormat.format(resultdate)).child(timeFormat.format(resultdate)).setValue(write_temp.getText().toString());
    }
}
