package com.isa.sahabatbunda;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
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
public class UploadDataRegistrasi extends AsyncTask<String,Void,String> {
    Context context;
    Registrasi activity;
    public UploadDataRegistrasi(Context context,Activity activity) {
        this.context = context;
        this.activity = (Registrasi) activity;
    }

    @Override
    protected String doInBackground(String... params) {
        Okhttp ok = new Okhttp();

//            String result = ok.doPostRequestDataIbu("http://sahabatbundaku.org/request_android/registrasi.php",params);
//            return result;

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
        switch (s){
            case "0":
                Toast.makeText(context,"Data belum valid",Toast.LENGTH_SHORT).show();
                break;
            case "-1":
                Toast.makeText(context,"Sepertinya perangkat tidak terhubung ke internet",Toast.LENGTH_LONG).show();
                break;
            case "1":
                Toast.makeText(context,"Data tersimpan",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
                break;
        }




    }

    public class Okhttp {
        OkHttpClient client = new OkHttpClient();
        // code request code here
        String doPostRequestDataIbu(String url, String[] values,String[] keys) throws IOException {
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
