package com.isa.sahabatbunda;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class RegistrasiFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public RegistrasiFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static RegistrasiFragment newInstance(int sectionNumber) {
        RegistrasiFragment fragment = new RegistrasiFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    Button simpan;
    SharedPreferences shapref;
    SharedPreferences.Editor editor;


    OnNextButtonPressed mCallback;

    public interface OnNextButtonPressed{
        public void Geser();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mCallback = (OnNextButtonPressed) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement OnNextButtonPressed");
        }
    }

    public void putToMySQLDataBase(){
        // mengambil data ibu dari shared preference untuk di upload
        SharedPreferences sp = getContext().getSharedPreferences("Data_dasar", Context.MODE_PRIVATE);
        String momkeys[] = {"email","username","passwd","nama","umur","sukubangsa","agama","rtrw","kecamatan","pendidikan","pekerjaan","nomorhp","alamat","keludes","kota"};
        String momvalues[] = new String[momkeys.length];
        for (int i = 0; i < momkeys.length; i++) {
            momvalues[i] = sp.getString(momkeys[i],"kosong");
        }
        // mengambil data ibu dari shared preference untuk di upload
        String dadkeys[] = {"namaayah","umurayah","sukBangayah","agamaayah","rtrwayah","kecamatanayah","pendidikanayah","pekerjaanayah","noHPayah","alamatayah","kelurahanayah","kotaayah"};
        String dadvalues[] = new String[dadkeys.length];
        for (int i = 0; i < dadkeys.length; i++) {
            dadvalues[i] = sp.getString(dadkeys[i],"kosong");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView;


        switch (getArguments().getInt(ARG_SECTION_NUMBER)){
            case 2:
                rootView = inflater.inflate(R.layout.fragment_registrasi_ibu, container, false);

                final String momkeys[] = {"email","username","passwd","nama","umur","sukubangsa","agama","rtrw","kecamatan","pendidikan","pekerjaan","nomorhp","alamat","keludes","kota"};
                final EditText momsdata[] = {
                        (EditText) rootView.findViewById(R.id.email)
                        ,(EditText) rootView.findViewById(R.id.username)
                        ,(EditText) rootView.findViewById(R.id.password)
                        ,(EditText) rootView.findViewById(R.id.namaIbu)
                        ,(EditText) rootView.findViewById(R.id.umuribu)
                        ,(EditText) rootView.findViewById(R.id.sukBangibu)
                        ,(EditText) rootView.findViewById(R.id.agamaibu)
                        ,(EditText) rootView.findViewById(R.id.rtrwibu)
                        ,(EditText) rootView.findViewById(R.id.kecamatanibu)
                        ,(EditText) rootView.findViewById(R.id.pendidikanibu)
                        ,(EditText) rootView.findViewById(R.id.pekerjaanibu)
                        ,(EditText) rootView.findViewById(R.id.noHPibu)
                        ,(EditText) rootView.findViewById(R.id.alamatibu)
                        ,(EditText) rootView.findViewById(R.id.kelurahanibu)
                        ,(EditText) rootView.findViewById(R.id.kotaibu)
                };

                simpan = (Button) rootView.findViewById(R.id.simpan);
                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shapref = getContext().getSharedPreferences("Data_dasar", Context.MODE_PRIVATE);
                        editor = shapref.edit();
                        Boolean lengkap = false;
                        String masukan[] = new String[15];

                        for (int i = 0; i<momsdata.length;i++){
                            //cek apakah ada yang kosong datanya atau engga
                            if (momsdata[i].getText().toString().trim().length()!=0) {
                                editor.putString(momkeys[i], momsdata[i].getText().toString());
                                masukan[i] = momsdata[i].getText().toString();
                                lengkap = true;
                            }
                            else {
                                lengkap = false;
                                break;
                            }
                        }

                        //
                        if (lengkap){
                            mCallback.Geser();
                        } else {
                            Toast.makeText(getContext(),"Data ibu Belum Lengkap",Toast.LENGTH_SHORT).show();
                        }
                        editor.putBoolean("lengkapibu", lengkap);
                        editor.commit();
                    }
                });
                break;
            case 3:
                rootView = inflater.inflate(R.layout.fragment_registrasi_ayah, container, false);

                final String dadkeys[] = {"namaayah","umurayah","sukBangayah","agamaayah","rtrwayah","kecamatanayah","pendidikanayah","pekerjaanayah","noHPayah","alamatayah","kelurahanayah","kotaayah"};
                final EditText dadsdata[] = {
                        (EditText) rootView.findViewById(R.id.namaayah),
                        (EditText) rootView.findViewById(R.id.umurayah),
                        (EditText) rootView.findViewById(R.id.sukBangayah),
                        (EditText) rootView.findViewById(R.id.agamaayah),
                        (EditText) rootView.findViewById(R.id.rtrwayah),
                        (EditText) rootView.findViewById(R.id.kecamatanayah),
                        (EditText) rootView.findViewById(R.id.pendidikanayah),
                        (EditText) rootView.findViewById(R.id.pekerjaanayah),
                        (EditText) rootView.findViewById(R.id.noHPayah),
                        (EditText) rootView.findViewById(R.id.alamatayah),
                        (EditText) rootView.findViewById(R.id.kelurahanayah),
                        (EditText) rootView.findViewById(R.id.kotaayah)
                };
                simpan = (Button) rootView.findViewById(R.id.simpan);
                simpan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shapref = getContext().getSharedPreferences("Data_dasar", Context.MODE_PRIVATE);
                        editor = shapref.edit();
                        Boolean lengkap = false;

                        for (int i = 0; i<dadsdata.length;i++){
                            if (dadsdata[i].getText().toString().trim().length()!=0) {
                                editor.putString(dadkeys[i], dadsdata[i].getText().toString());
                                lengkap = true;
                            } else {
                                lengkap = false;
                                break;
                            }

                        }

                        if (lengkap){
                            editor.putBoolean("lengkapayah", lengkap);
                            Toast.makeText(getContext(),"Data ayah Tersimpan",Toast.LENGTH_SHORT).show();
                            Intent utama = new Intent(getContext(), MainActivity.class);
                            utama.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(utama);
                        } else {
                            Toast.makeText(getContext(),"Data ayah belum lengkap",Toast.LENGTH_SHORT).show();
                        }
                        editor.putBoolean("lengkapayah", lengkap);
                        editor.commit();

                        putToMySQLDataBase();
                    }
                });
                break;
            case 1:
                rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
                break;
            default:
                return null;
        }
        return rootView;

    }
}
