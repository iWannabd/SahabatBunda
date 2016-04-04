package com.isa.sahabatbunda;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by azaqo on 4/3/2016.
 */

public class FormAmnesa extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public FormAmnesa() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static FormAmnesa newInstance(int sectionNumber) {
        FormAmnesa fragment = new FormAmnesa();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public static final String AMNESA = "AMNESA";

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView;
        final Context c = getActivity();

        final SharedPreferences shapref = c.getSharedPreferences(AMNESA, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = shapref.edit();
        switch (getArguments().getInt(ARG_SECTION_NUMBER)){
            case 1:
                rootView = inflater.inflate(R.layout.layout_amnesa_riwayat, container, false);
                //binding View
                final EditText hpmt = (EditText) rootView.findViewById(R.id.tanggalHaid);
                final EditText takminsal = (EditText) rootView.findViewById(R.id.taksiranMingguke);
                final EditText hamike = (EditText) rootView.findViewById(R.id.hamilKe);
                final EditText jumelahir = (EditText) rootView.findViewById(R.id.melahirkan);
                final EditText jumgugut = (EditText) rootView.findViewById(R.id.keguguran);
                final Spinner jarhamil = (Spinner) rootView.findViewById(R.id.jarakHamil);

                final EditText norm = (EditText) rootView.findViewById(R.id.normal);
                final EditText vacc = (EditText) rootView.findViewById(R.id.vaccum);
                final EditText cesa = (EditText) rootView.findViewById(R.id.sesar);
                final EditText prema = (EditText) rootView.findViewById(R.id.prematur);

                final CheckBox bidan = (CheckBox) rootView.findViewById(R.id.penolongBidan);
                final CheckBox dukun = (CheckBox) rootView.findViewById(R.id.penolongDokter);
                final CheckBox dokter = (CheckBox) rootView.findViewById(R.id.penolongDukun);
                final CheckBox lain = (CheckBox) rootView.findViewById(R.id.penolongLain);

                final EditText beart1 = (EditText) rootView.findViewById(R.id.berat1);
                final EditText beart2 = (EditText) rootView.findViewById(R.id.berat2);
                final EditText beart3 = (EditText) rootView.findViewById(R.id.berat3);
                //saving data
                final Button save = (Button) rootView.findViewById(R.id.save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.putString("hpmt", hpmt.getText().toString());
                        editor.putString("TAKSIRAN_MINGGU_PERSALINAN", takminsal.getText().toString());
                        editor.putString("hamike", hamike.getText().toString());
                        editor.putString("jumelahir", jumelahir.getText().toString());
                        editor.putString("jumgugut", jumgugut.getText().toString());
                        editor.putString("jarhamil", jarhamil.getSelectedItem().toString());
                        editor.putString("norm", norm.getText().toString());
                        editor.putString("vacc", vacc.getText().toString());
                        editor.putString("cesa", cesa.getText().toString());
                        editor.putString("prema", prema.getText().toString());
                        editor.putString("beart1", beart1.getText().toString());
                        editor.putString("beart2", beart2.getText().toString());
                        editor.putString("beart3", beart3.getText().toString());

                        CheckBox cb[] = {bidan,dukun,dokter,lain};
                        Set<String> penolong = new HashSet<String>();

                        for (int i = 0; i < 4; i++) {
                            if (cb[i].isChecked())
                                penolong.add(cb[i].getText().toString());
                        }
                        String s = penolong.toString();
                        editor.putString("penolong", s);

                        editor.commit();

                        Toast.makeText(getActivity(), "Data Tersimpan ", Toast.LENGTH_SHORT).show();

                    }
                });
                return rootView;
            case 2:
                rootView = inflater.inflate(R.layout.layout_amnesa_penyakit, container, false);
                final CheckBox darting = (CheckBox) rootView.findViewById(R.id.darting);
                final CheckBox gula = (CheckBox) rootView.findViewById(R.id.gula);
                final CheckBox asma = (CheckBox) rootView.findViewById(R.id.asma);
                final CheckBox jantung = (CheckBox) rootView.findViewById(R.id.jantung);
                final CheckBox lainnya = (CheckBox) rootView.findViewById(R.id.lain);

                final EditText imun1 = (EditText) rootView.findViewById(R.id.imun1);
                final EditText imun2 = (EditText) rootView.findViewById(R.id.imun2);
                final EditText imun3 = (EditText) rootView.findViewById(R.id.imun3);
                final EditText imun4 = (EditText) rootView.findViewById(R.id.imun4);
                final EditText imun5 = (EditText) rootView.findViewById(R.id.imun5);

                final CheckBox dartingx = (CheckBox) rootView.findViewById(R.id.DarahTinggix);
                final CheckBox gulax = (CheckBox) rootView.findViewById(R.id.Gulax);
                final CheckBox asmax = (CheckBox) rootView.findViewById(R.id.Asmax);
                final CheckBox jantungx = (CheckBox) rootView.findViewById(R.id.Jantungx);

                final Button simpan = (Button) rootView.findViewById(R.id.save1);
                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox cb[] = {darting,gula,asma,jantung,lainnya};
                        Set<String> penyakit = new HashSet<>();

                        for (int i = 0; i < 5; i++) {
                            if(cb[i].isChecked())
                                penyakit.add(cb[i].getText().toString());
                        }
                        String s = penyakit.toString();
                        editor.putString("riwayat penyakit",s);

                        EditText imuns[] = {imun1,imun2,imun3,imun4,imun5};
                        for (int i = 0; i < 5; i++) {
                            editor.putString("imun"+i,imuns[i].getText().toString());
                        }

                        CheckBox cbx[] = {dartingx,gulax,asmax,jantungx};
                        Set<String> penyakitx = new HashSet<>();

                        for (int i = 0; i < 4; i++) {
                            penyakitx.add(cbx[i].getText().toString());
                        }
                        editor.putString("penyakit turunan", penyakitx.toString());
                        editor.commit();
                        Toast.makeText(getActivity(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                });
                return rootView;
            case 3:

                rootView = inflater.inflate(R.layout.layout_amnesa_keluhan, container, false);
                final CheckBox mual = (CheckBox) rootView.findViewById(R.id.mual);
                final CheckBox bab = (CheckBox) rootView.findViewById(R.id.bab);
                final CheckBox putih = (CheckBox) rootView.findViewById(R.id.keputihan);
                final CheckBox lelah = (CheckBox) rootView.findViewById(R.id.lelah);
                final CheckBox pusing = (CheckBox) rootView.findViewById(R.id.pusing);
                final CheckBox bakar = (CheckBox) rootView.findViewById(R.id.bakar);
                final CheckBox tri1[] = {mual,bab,putih,lelah,pusing,bakar};

                final CheckBox pusing1 = (CheckBox) rootView.findViewById(R.id.pusing1);
                final CheckBox nyeri = (CheckBox) rootView.findViewById(R.id.nyeri);
                final CheckBox keputihan1 = (CheckBox) rootView.findViewById(R.id.keputihan1);
                final CheckBox nyeriPunggung = (CheckBox) rootView.findViewById(R.id.nyeriPunggung);
                final CheckBox kemih = (CheckBox) rootView.findViewById(R.id.kemih);
                final CheckBox gerakJanin = (CheckBox) rootView.findViewById(R.id.gerakJanin);
                final CheckBox bab1 = (CheckBox) rootView.findViewById(R.id.bab1);
                final CheckBox tri2[] = {pusing1,nyeri,keputihan1,nyeriPunggung,kemih,gerakJanin,bab1};

                final CheckBox bab2 = (CheckBox) rootView.findViewById(R.id.bab2);
                final CheckBox kram = (CheckBox) rootView.findViewById(R.id.kram);
                final CheckBox nyeri1 = (CheckBox) rootView.findViewById(R.id.nyeri1);
                final CheckBox grakJanin1 = (CheckBox) rootView.findViewById(R.id.grakJanin1);
                final CheckBox kemih1 = (CheckBox) rootView.findViewById(R.id.kemih1);
                final CheckBox bengkakaki = (CheckBox) rootView.findViewById(R.id.bengkakaki);
                final CheckBox keputihan2 = (CheckBox) rootView.findViewById(R.id.keputihan2);
                final CheckBox sulittidur = (CheckBox) rootView.findViewById(R.id.sulittidur);
                final CheckBox sesaknapas = (CheckBox) rootView.findViewById(R.id.sesaknapas);
                final CheckBox nyeripinggang = (CheckBox) rootView.findViewById(R.id.nyeripinggang);
                final CheckBox darahmalu = (CheckBox) rootView.findViewById(R.id.darahmalu);
                final CheckBox tri3[] = {bab2,kram,nyeri1,grakJanin1,kemih1,bengkakaki,keputihan2,sulittidur,sesaknapas,nyeripinggang,darahmalu};

                final Button simpan2 = (Button) rootView.findViewById(R.id.save2);
                simpan2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Set<String> tris1 = new HashSet<String>();
                        for (CheckBox t1:tri1) {
                            if (t1.isChecked())
                            tris1.add(t1.getText().toString());
                        }
                        Set<String> tris2 = new HashSet<String>();
                        for (CheckBox t2:tri2) {
                            if (t2.isChecked())
                            tris2.add(t2.getText().toString());
                        }
                        Set<String> tris3 = new HashSet<String>();
                        for (CheckBox t3:tri3) {
                            if (t3.isChecked())
                            tris3.add(t3.getText().toString());
                        }

                        editor.putString("TriSemester1",tris1.toString());
                        editor.putString("TriSemester2",tris2.toString());
                        editor.putString("TriSemester3", tris3.toString());
                        editor.commit();
                        Toast.makeText(getActivity(), "Data Tersimpan", Toast.LENGTH_SHORT).show();

                    }
                });
                return rootView;
            case 4:
                rootView = inflater.inflate(R.layout.layout_amnesa_pemeriksaan, container, false);

                final Spinner keumum = (Spinner) rootView.findViewById(R.id.keumum);
                final Spinner presjanin = (Spinner) rootView.findViewById(R.id.presjanin);
                final Spinner wakgerja = (Spinner) rootView.findViewById(R.id.waktugerakjanin);
                final EditText suhu = (EditText) rootView.findViewById(R.id.suhu);
                final EditText tekdarah = (EditText) rootView.findViewById(R.id.tekdarah);
                final EditText tekdarahmmhg = (EditText) rootView.findViewById(R.id.tekdarahmmhg);
                final EditText berdan = (EditText) rootView.findViewById(R.id.berdan);
                final EditText lila = (EditText) rootView.findViewById(R.id.lila);
                final EditText tfu = (EditText) rootView.findViewById(R.id.tfu);
                final EditText hb = (EditText) rootView.findViewById(R.id.hb);
                final EditText goldar = (EditText) rootView.findViewById(R.id.goldar);
                final EditText jantungJanin = (EditText) rootView.findViewById(R.id.jantungJanin);
                final EditText saran = (EditText) rootView.findViewById(R.id.saran);


                final Button simpan3 = (Button) rootView.findViewById(R.id.save3);
                simpan3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.putString("keadaan umum",keumum.getSelectedItem().toString());
                        editor.putString("presentasi janin",presjanin.getSelectedItem().toString());
                        editor.putString("waktu gerak janin",wakgerja.getSelectedItem().toString());

                        editor.putString("suhu", suhu.getText().toString());
                        editor.putString("tekdarah", tekdarah.getText().toString());
                        editor.putString("tekdarahmmhg", tekdarahmmhg.getText().toString());
                        editor.putString("berat badan",berdan.getText().toString());
                        editor.putString("lila",lila.getText().toString());
                        editor.putString("tfu",tfu.getText().toString());
                        editor.putString("hb", hb.getText().toString());
                        editor.putString("goldar", goldar.getText().toString());
                        editor.putString("jantungJanin", jantungJanin.getText().toString());
                        editor.putString("saran", saran.getText().toString());

                        editor.commit();

                        Toast.makeText(getActivity(), "Data Tersimpan", Toast.LENGTH_SHORT).show();
                    }
                });
                return rootView;
        }
        return null;
    }
}

