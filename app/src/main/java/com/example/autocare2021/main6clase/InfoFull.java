package com.example.autocare2021.main6clase;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autocare2021.R;
import com.example.autocare2021.adaptere.KmAdapter;
import com.example.autocare2021.adaptere.RepAdapter;
import com.example.autocare2021.adaptere.RevAdapter;
import com.example.autocare2021.clase6.Km;
import com.example.autocare2021.clase6.Reparatii;
import com.example.autocare2021.clase6.Revizii;
import com.example.autocare2021.json.ParsareJson;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class InfoFull extends AppCompatActivity {
    TextView tvinfoAsigurare, tvinfoRovinieta,
            tvMin, tvMax;
    private int reqCode = 1080;
    private List<Km> kmList;
    private List<Reparatii> repList;
    private List<Revizii> revList;
    //
    DatabaseReference KMdatabaseReference;
    DatabaseReference REPdatabaseReference;
    DatabaseReference REVdatabaseReference;
    //

    FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    FirebaseDatabase database2 = FirebaseDatabase.getInstance();
    FirebaseDatabase database3 = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_info_masini);
        //todo Vremea
        tvMin = findViewById(R.id.min);
        tvMax = findViewById(R.id.max);
        ParsareJson json = new ParsareJson() {

            @Override
            protected void onPostExecute(List<Double> doubles) {
                //primim ca param lista din DIB
                Toast.makeText(InfoFull.this,
                        "Minim: " + doubles.get(0) +
                                ", Maxim: " + doubles.get(1),
                        Toast.LENGTH_LONG).show();
                String min = doubles.get(0).toString(),
                        max = doubles.get(1).toString();
                tvMin.setText(min);
                tvMax.setText(max);
            }
        };
        //linkul cu fisierul Json
        //pornim firul de executie
        json.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/287430?apikey=S3oFQ6YX7fUPzFUuPJtGtZb57SScLnJp&metric=true");
//
        //region Casco
        SharedPreferences sharedPreferences = getSharedPreferences("preferinteCasco", MODE_PRIVATE);
        tvinfoAsigurare = findViewById(R.id.tvinfoAsigurare);
//
        String sofer = sharedPreferences.getString("sofer", "-"),
                auto = sharedPreferences.getString("auto", "-");
        int motor = sharedPreferences.getInt("motor", 1),
                greutate = sharedPreferences.getInt("greutate", 0);
        boolean isAsigurat = sharedPreferences.getBoolean("isAsigurata", false);
//
        tvinfoAsigurare.setText("\n" +
                "Sofer: " + sofer + "\n" +
                "Tip Autoturism: " + auto + "\n" +
                "Tip motor: " + motor + "\n" +
                "Greutate: " + greutate + "\n" +
                "Asigurare: " + isAsigurat + "\n");
        //endregion
        //region Rovinieta
//
        SharedPreferences sharedPreferences1 = getSharedPreferences("preferinteRovinieta", MODE_PRIVATE);
        tvinfoRovinieta = findViewById(R.id.tvinfoRovinieta);
//
        String data = sharedPreferences1.getString("data", "-"),
                nrInmatriculare = sharedPreferences1.getString("nrInmatriculare", "-"),
                permis = sharedPreferences1.getString("permis", "-"),
                zona = sharedPreferences1.getString("zona", "-");
        int gabarit = sharedPreferences1.getInt("gabarit", 0);
//
        tvinfoRovinieta.setText("\n" +
                "Data de incepere: " + data + "\n" +
                "Numar de Inmatriculare: " + nrInmatriculare + "\n" +
                "Categorie Permis: " + permis + "\n" +
                "Gabarit: " + gabarit + "\n" +
                "Zona de Circulatie: " + zona + "\n");
        //endregion
        //todo KM
        ListView lvKm = findViewById(R.id.lvActualizariKm);
        kmList = new ArrayList<>();
//
        KMdatabaseReference = database1
                .getInstance()
                .getReference("Actualizari Km");
        KMdatabaseReference
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            Km value = child.getValue(Km.class);
//
                            kmList.add(value);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
        KmAdapter kmAdapter = new KmAdapter(kmList, this);
        lvKm.setAdapter(kmAdapter);
//
        //todo Reparatii
        ListView lvReparatii = findViewById(R.id.lvReparatii);
        repList = new ArrayList<>();
//
        REPdatabaseReference = database2
                .getInstance()
                .getReference("Reparatii");
        REPdatabaseReference
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            Reparatii repValue = child.getValue(Reparatii.class);
//
                            repList.add(repValue);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
        RepAdapter repAdapter = new RepAdapter(repList, this);
        lvReparatii.setAdapter(repAdapter);
//
        //todo Revizii
        ListView lvRevizii = findViewById(R.id.lvRevizii);
        revList = new ArrayList<>();
//
        REVdatabaseReference = database3
                .getInstance()
                .getReference("Revizii");
        REVdatabaseReference
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot child : dataSnapshot.getChildren()) {
                            Revizii revValue = child.getValue(Revizii.class);
//
                            revList.add(revValue);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
        RevAdapter revAdapter = new RevAdapter(revList, this);
        lvRevizii.setAdapter(revAdapter);
    }
}



