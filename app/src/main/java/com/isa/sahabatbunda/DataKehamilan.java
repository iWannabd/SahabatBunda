package com.isa.sahabatbunda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataKehamilan extends AppCompatActivity {
    public static final String AMNESA = "AMNESA";
    SharedPreferences shapref;
    SharedPreferences.Editor editor;

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
    TextView usiahamil;
    TextView takspersa;
    TextView janin;
    TextView ibu;
    TextView saran;

    @Override
    protected void onResume() {
        super.onResume();
        setKeadaan();
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

        shapref = PreferenceManager.getDefaultSharedPreferences(this);
        editor = shapref.edit();
        setKeadaan();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setKeadaan(){
        String hpht = shapref.getString("hpmt",null);
        if (hpht!=null){
            try {
                Date start = sdf.parse(hpht);
                DateTime dateTime = new DateTime(start);
                usiahamil.setText(Weeks.weeksBetween(dateTime,new DateTime()).getValue(0)+" minggu.");
                dateTime = dateTime.plusYears(1);
                dateTime = dateTime.minusMonths(3);
                dateTime = dateTime.plusDays(7);
                takspersa.setText(sdf.format(dateTime.toDate()));

                saran.setText(shapref.getString("saran", "-"));
                ibu.setText(shapref.getString("keadaanumumibu","-"));
                janin.setText(shapref.getString("keadaanumumjanin", "-"));

            } catch (ParseException e) {
                takspersa.setText("Invalid Date Format");
                e.printStackTrace();
            }
        }
    }
}
