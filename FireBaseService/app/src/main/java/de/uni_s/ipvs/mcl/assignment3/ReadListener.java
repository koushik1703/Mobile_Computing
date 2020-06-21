package de.uni_s.ipvs.mcl.assignment3;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadListener implements View.OnClickListener {

    DatabaseReference mRef;
    EditText read_location;
    TextView read_temp;
    SimpleDateFormat dateFormat;
    static ReadListener readListener = null;


    @SuppressLint("SimpleDateFormat")
    public ReadListener(EditText read_location, TextView read_temp) {
        this.mRef = FirebaseDatabase.getInstance().getReference();
        this.read_location = read_location;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.read_temp = read_temp;
    }

    public static ReadListener getInstance(EditText read_location, TextView read_temp) {
        if(readListener == null) {
            readListener = new ReadListener(read_location, read_temp);
        }
        return readListener;
    }

    @Override
    public void onClick(View v) {
        long currentTimeMillis = System.currentTimeMillis();
        Date resultdate = new Date(currentTimeMillis);
        mRef.child("teams").child("20").child("location").child(read_location.getText().toString()).child(dateFormat.format(resultdate)).addListenerForSingleValueEvent(SingleValueListener.getInstance(read_temp));
    }
}
