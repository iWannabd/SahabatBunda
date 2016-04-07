package com.isa.sahabatbunda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Registrasi extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrasi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        EditText etext;
        Button simpan;
        SharedPreferences shapref;
        SharedPreferences.Editor editor;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView;
            shapref = getContext().getSharedPreferences("Data_dasar", Context.MODE_PRIVATE);
            editor = shapref.edit();

            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 2:
                    rootView = inflater.inflate(R.layout.fragment_registrasi_ibu, container, false);

                    final String momkeys[] = {"namaIbu","sukBangibu","agamaibu","rtrwibu","kecamatanibu","pendidikanibu","pekerjaanibu","noHPibu","alamatibu","kelurahanibu","kotaibu"};
                    final EditText momsdata[] = {
                            (EditText) rootView.findViewById(R.id.namaIbu)
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
                    final EditText umuribu = (EditText) rootView.findViewById(R.id.umuribu);

                    simpan = (Button) rootView.findViewById(R.id.simpan);
                    simpan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ArrayList<String> a = new ArrayList<String>();
                            for (int i = 0; i<momsdata.length;i++){
                                editor.putString(momkeys[i], momsdata[i].getText().toString()) ;
                                a.add(momkeys[i]+"=>"+momsdata[i].getText().toString());
                            }
                            Log.d("Berhasil", "onClick: "+a);
                            editor.putInt("umuribu", Integer.parseInt(umuribu.getText().toString()));
                            editor.putBoolean("lengkapibu", true);
                            Toast.makeText(getContext(),"Data ibu Tersimpan",Toast.LENGTH_SHORT).show();
                        }
                    });
                    break;
                case 3:
                    rootView = inflater.inflate(R.layout.fragment_registrasi_ayah, container, false);

                    final String dadkeys[] = {"namaayah","sukBangayah","agamaayah","rtrwayah","kecamatanayah","pendidikanayah","pekerjaanayah","noHPayah","alamatayah","kelurahanayah","kotaayah"};
                    final EditText dadsdata[] = {
                            (EditText) rootView.findViewById(R.id.namaayah),
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
                    final EditText umurayah = (EditText) rootView.findViewById(R.id.umurayah);
                    simpan = (Button) rootView.findViewById(R.id.simpan);
                    simpan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            for (int i = 0; i<dadsdata.length;i++){
                                editor.putString(dadkeys[i], dadsdata[i].getText().toString());
                            }
                            editor.putInt("umurayah", Integer.parseInt(umurayah.getText().toString()));
                            editor.putBoolean("lengkapayah", true);
                            editor.commit();
                            Toast.makeText(getContext(),"Data ayah Tersimpan",Toast.LENGTH_SHORT).show();
                            getActivity().finish();
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 1:
                    return "Ibu";
                case 2:
                    return "Ayah";
                case 0:
                    return "Halo";
            }
            return null;
        }
    }
}
