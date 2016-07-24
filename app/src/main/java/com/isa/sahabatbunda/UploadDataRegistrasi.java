package com.isa.sahabatbunda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by node06 on 21/04/2016.
 */
public class UploadDataRegistrasi extends AsyncTask<String[],Void,String> {
    Context context;
    LoginRegistrationActivity activity;
    String url;
    Boolean flag; // true if login false if sign up // menandai apakah data yang dikirim untuk login atau signup

    public UploadDataRegistrasi(Context context,Activity activity,String url,Boolean flag) {
        this.context = context;
        this.activity = (LoginRegistrationActivity) activity;
        this.url = url;
        this.flag = flag;
    }

    @Override
    protected String doInBackground(String[]... params) {
        Okdeh ok = new Okdeh();
        try {
            String s = ok.doPostRequestDataDasar(url,params[0],params[1]);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("BISA", "doInBackground: "+e);
        }
        return "-1";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(context,"Tunggu...",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //if flag true then do login respones handle
        if (flag){
            switch (s){
                case "1": //jika login gagal
                    Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_LONG).show();
                    break;
                default:
                    Intent utama = new Intent(context, MainActivity.class);
                    utama.putExtra("SESSION_UNAME",s);
                    utama.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    activity.startActivity(utama);
                    break;
            }

        } else {
            // if false then do sign up respones handle
            switch (s) {
                case "0": //jika data belum valid menurut server
                    Toast.makeText(context, "Data belum valid", Toast.LENGTH_SHORT).show();
                    break;
                case "-1": //jika tidak terkoneksi
                    Toast.makeText(context, "Sepertinya perangkat tidak terhubung ke internet", Toast.LENGTH_LONG).show();
                    break;
                case "1": //jika berhasil
                    Toast.makeText(context, "Data tersimpan, Silahkan Login", Toast.LENGTH_SHORT).show();
                    activity.Geser(0);
                    break;
                default:
                    Toast.makeText(context, s, Toast.LENGTH_LONG).show();
                    break;
            }
        }

    }

    public class Okdeh {
        OkHttpClient client = new OkHttpClient();
        // code request code here
        String doPostRequestDataDasar(String url, String[] keys, String[] values) throws IOException {
            MultipartBody.Builder feb = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM);

            for (int i = 0; i < values.length; i++) {
                feb.addFormDataPart(keys[i],values[i]);
            }

            RequestBody febs = feb.build();

            Request request = new Request.Builder()
                    .url(url)
                    .post(febs)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }

    }
}
