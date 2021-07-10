package com.example.autocare2021.original;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.autocare2021.R;
import com.example.autocare2021.room.MasinaDataBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdaugareMasina extends AppCompatActivity {
    private static MasinaDataBase masinaDataBase;
    List<String> elemSpinner = new ArrayList<>();
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy ");
    LocalDateTime data = LocalDateTime.now();
    EditText etNrInmatriculare, etMarca, etModel, etAn, etCapacitate;
    Spinner spinCarb;
    Switch swAsigurata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
        setContentView(R.layout.adaugare_masina);
        etNrInmatriculare = findViewById(R.id.etNrInmatriculare);
        etMarca = findViewById(R.id.etMarca);
        etModel = findViewById(R.id.etModel);
        etAn = findViewById(R.id.etAn);
        etCapacitate = findViewById(R.id.etCapacitate);
        spinCarb = findViewById(R.id.spinnerCarb);
        swAsigurata = findViewById(R.id.swAsigurata);
//
        //region Room
//
        //@3param --numele bazei de date, acolo era numele tabelei
//
        //daca vrem sa fortam sa ruleze pe firul principal, ceea ce nu e recomandat
        //.allowMainThreadQueries()
        masinaDataBase = Room.databaseBuilder(this,
                MasinaDataBase.class, "masiniDB")
                .allowMainThreadQueries()
                .build();
        //endregion
        //region spinner
        elemSpinner.add("-");
        elemSpinner.add("Benzina");
        elemSpinner.add("Motorina");
        elemSpinner.add("GPL");
        elemSpinner.add("Electric");
        elemSpinner.add("Hybrid");
        Spinner spinner = findViewById(R.id.spinnerCarb);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                elemSpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(adapterView.getContext(),
                        adapterView.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        //endregion
    }


    public void save(View view) {
        //e recomandat sa declaram baza de date ca atribut
        String nrInmatriculare = etNrInmatriculare.getText().toString(),
                marca = etMarca.getText().toString(),
                model = etModel.getText().toString(),
                combustibil = spinCarb.getSelectedItem().toString();
        int an = Integer.parseInt((etAn).getText().toString()),
                capactitate = Integer.parseInt((etCapacitate).getText().toString());
        boolean isAsigurata = swAsigurata.isChecked();
//
        Masina masina = new Masina(nrInmatriculare, marca, model, dtf.format(data),
                an, combustibil, capactitate, isAsigurata);
        masinaDataBase.getMasinaDAO().inserareMasinaRoom(masina);
        Toast.makeText(this, "Masina a fost adaugata -> Room", Toast.LENGTH_LONG).show();
        List<Masina> masinaList = masinaDataBase.
                getMasinaDAO().
                getAllMasina();
        for (Masina m : masinaList) {
            Toast.makeText(getApplicationContext(),
                    m.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    public void cancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
