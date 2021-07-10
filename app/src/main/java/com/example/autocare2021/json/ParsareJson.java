package com.example.autocare2021.json;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//1 @params este link ul din exemplul nostru--e link deci String
//-tipul inf din FirP->FirS
//2 @progress Void cu V mare
//3 @Result --
//cele 2 temperaturi le putem trimite ca obj sau String(concat), acum le facem obiecte

public class ParsareJson extends AsyncTask<String, Void, List<Double>> {
    //e taiat pt ca e descurajata folosirea
    @Override
    protected List<Double> doInBackground(String... strings) {
        //... insemana ca nu stim cati parametri de tip String vor fi
//
        //List e clasa abstracta--ArrayList mosteneste clasa abs si implementeaza acele metode
        List<Double> lista = new ArrayList<>();
        try {
            URL url = new URL(strings[0]);
            try {
                //BufferedReader->pt citirea
                //StringBuilder-> pt fisiere text
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                InputStream input = http.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(input);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                StringBuilder builder = new StringBuilder();
                String linie = "";
                //String e imutabil?--deci creeaza noi obiecte
                //cand ajung la finalul fisierului, returneaza null(cea de jos e verificarea)
                while ((linie = reader.readLine()) != null) {
                    builder.append(linie);
                }
                String text = builder.toString();
//
                JSONObject textFull = new JSONObject(text);
                JSONArray array = textFull.getJSONArray("DailyForecasts");
//
                JSONObject primulObiect = array.getJSONObject(0);
                JSONObject temperatura = primulObiect.getJSONObject("Temperature");
                JSONObject minimum = temperatura.getJSONObject("Minimum");
                JSONObject maximum = temperatura.getJSONObject("Maximum");
//
                double minim = minimum.getDouble("Value");
                double maxim = maximum.getDouble("Value");
//
                lista.add(minim);
                lista.add(maxim);
//
            } catch (MalformedURLException e) {
                //mesaj in consola
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;
    }

}

