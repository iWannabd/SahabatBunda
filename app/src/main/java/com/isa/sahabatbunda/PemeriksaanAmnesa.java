package com.isa.sahabatbunda;

import android.content.Context;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.PreferenceFragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;

/**
 * Created by azaqo on 4/4/2016.
 */
public class PemeriksaanAmnesa extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.riwayathamil);
    }
}
