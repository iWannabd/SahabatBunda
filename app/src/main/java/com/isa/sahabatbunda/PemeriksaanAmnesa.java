package com.isa.sahabatbunda;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by azaqo on 4/4/2016.
 */
public class PemeriksaanAmnesa extends PreferenceFragment {

    static String pos = "Position";

    public static PemeriksaanAmnesa newInstance(int Position) {

        Bundle args = new Bundle();
        args.putInt(pos, Position);

        PemeriksaanAmnesa fragment = new PemeriksaanAmnesa();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (getArguments().getInt(pos,0)){
            case 1:
                addPreferencesFromResource(R.xml.riwayathamil);
                break;
            case 2:
                addPreferencesFromResource(R.xml.riwayatpenyakit);
                break;
            case 3:
                addPreferencesFromResource(R.xml.keluhan);
                break;
            case 4:
                addPreferencesFromResource(R.xml.pemeriksaan);
                break;
            default:
                break;
        }
    }
}
