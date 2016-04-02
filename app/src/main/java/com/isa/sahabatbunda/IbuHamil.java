package com.isa.sahabatbunda;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class IbuHamil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibu_hamil);

        ImageButton dataHamil = (ImageButton) findViewById(R.id.dataKehamilan);
        if (dataHamil != null) {
            dataHamil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getBaseContext(), DataKehamilan.class));
                }
            });
        }
    }
}
