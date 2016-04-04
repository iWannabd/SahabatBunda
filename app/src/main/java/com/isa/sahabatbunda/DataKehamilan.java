package com.isa.sahabatbunda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataKehamilan extends AppCompatActivity {
    public static final String AMNESA = "AMNESA";
    SharedPreferences shapref;
    SharedPreferences.Editor editor;

    SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
    TextView usiahamil;
    TextView takspersa;
    TextView janin;
    TextView ibu;
    TextView saran;

    @Override
    protected void onResume() {
        super.onResume();
        setUsiaHamil();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_kehamilan);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getBaseContext(),Amnesa.class));
//                    startActivity(new Intent(getBaseContext(),PemeriksaanAmnesa.class));
                }
            });
        }

        usiahamil = (TextView) findViewById(R.id.usia_kehamilan);
        takspersa = (TextView) findViewById(R.id.taksiran_persalinan);
        janin = (TextView) findViewById(R.id.keadaanjanin);
        ibu = (TextView) findViewById(R.id.keadaanibu);
        saran = (TextView) findViewById(R.id.saran);

        shapref = getSharedPreferences(AMNESA, Context.MODE_PRIVATE);
        editor = shapref.edit();
        setUsiaHamil();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUsiaHamil(){
        String hpht = shapref.getString("hpmt",null);
        if (hpht!=null){
            try {
                Date start = sdf.parse(hpht);
                Calendar cal = Calendar.getInstance();
                cal.setTime(start);
                cal.add(Calendar.DATE, 7);//add 7
                cal.add(Calendar.MONTH, -3);//subs 3
                cal.add(Calendar.YEAR, 1);//add1
                DateTime dt = new DateTime(cal);
                usiahamil.setText(Weeks.weeksBetween(dt,new DateTime(new Date())).toString()+" mng.");
                takspersa.setText(sdf.format(cal.getTime()));
            } catch (ParseException e) {
                takspersa.setText("Invalid Date Format");
                e.printStackTrace();
            }
        }
    }
}
