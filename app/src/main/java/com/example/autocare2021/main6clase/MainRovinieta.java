package com.example.autocare2021.main6clase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.autocare2021.R;

import java.util.ArrayList;
import java.util.List;

public class MainRovinieta extends AppCompatActivity {
    EditText etDataRov, etNrRov, etGabarit;
    Button btSaveRovinieta;
    List<String> elemPermis = new ArrayList<>();
    List<String> elemZona = new ArrayList<>();
    Spinner spPermis, spZona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rovinieta);
        etDataRov = findViewById(R.id.etDataRov);
        etNrRov = findViewById(R.id.etNrInmatriculareRov);
        etGabarit = findViewById(R.id.etGabaritRov);
        //region spinnerPermis
        elemPermis.add("-");
        elemPermis.add("A");
        elemPermis.add("B");
        elemPermis.add("C");
        elemPermis.add("D");
        elemPermis.add("E");
//
        spPermis = findViewById(R.id.spPermisRov);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                elemPermis);
        spPermis.setAdapter(adapter);
        spPermis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(adapterView.getContext(),
                        adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //endregion
        //region spinnerZona
        elemZona.add("-");
        elemZona.add("Bucuresti");
        elemZona.add("Timisoara");
        elemZona.add("Craiova");
        elemZona.add("Dambovita");
        elemZona.add("Cluj");
//
        spZona = findViewById(R.id.spZonaRov);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                elemZona);
        spZona.setAdapter(adapter1);
        spZona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(adapterView.getContext(),
                        adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
//endregion
        etDataRov = findViewById(R.id.etDataRov);
        etNrRov = findViewById(R.id.etNrInmatriculareRov);
        etGabarit = findViewById(R.id.etGabaritRov);
        btSaveRovinieta = findViewById(R.id.btSaveRovinieta);
//
        btSaveRovinieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etDataRov.getText().toString(),
                        nrRov = etNrRov.getText().toString(),
                        permis = spPermis.getSelectedItem().toString(),
                        zona = spZona.getSelectedItem().toString();
                int gabarit = Integer.parseInt(etGabarit.getText().toString());
//
                SharedPreferences sharedPreferences = getSharedPreferences("preferinteRovinieta", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
//
                editor.putString("data", data);
                editor.putString("nrInmatriculare", nrRov);
                editor.putString("permis", permis);
                editor.putString("zona", zona);
                editor.putInt("gabarit", gabarit);
                editor.commit();
                Toast.makeText(getApplicationContext(),
                        "Rovinieta a fost actualizata \n SharedPref",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}