package com.example.autocare2021.main6clase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Km;
import com.example.autocare2021.clase6.Revizii;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainRevizii extends AppCompatActivity {
    private int reqCode = 0;
    EditText etBujii, etFiltreAer, etFiltreBenzina, etRotor;
    Switch swUlei;
    Button btAdaugaRevizie;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revizii);
//
        etBujii = findViewById(R.id.etBujii);
        etFiltreAer = findViewById(R.id.etFiltreAer);
        etFiltreBenzina = findViewById(R.id.etFiltreBenzina);
        etRotor = findViewById(R.id.etRotor);
        swUlei = findViewById(R.id.swSchimbUlei);
        btAdaugaRevizie = findViewById(R.id.btAdaugaRevizie);
//
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //obtinem o referinta
        //se creeaza o inregistrare cu numele "Revizii"
        final DatabaseReference myRef = database.getReference().child("Revizii");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Iterable<DataSnapshot> actualizariRevizii = snapshot.getChildren();
//                for (DataSnapshot actualizari : actualizariRevizii) {
//                    Toast.makeText(MainRevizii.this, actualizari
//                            .getValue()
//                            .toString(), Toast.LENGTH_SHORT)
//                            .show();
//                }
                if (snapshot.exists())
                    maxid = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        btAdaugaRevizie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bujii = Integer.parseInt(etBujii.getText().toString()),
                        filtreAer = Integer.parseInt(etFiltreAer.getText().toString()),
                        filtreBenzina = Integer.parseInt(etFiltreBenzina.getText().toString()),
                        rotor = Integer.parseInt(etRotor.getText().toString());
                boolean ulei = swUlei.isChecked();
                Revizii revizie = new Revizii(bujii, filtreAer, filtreBenzina, rotor, ulei);
//
                int total;
                if (ulei)
                    total = bujii * 20 + filtreAer * 50 + filtreBenzina * 75 + rotor * 5 + 100;
                else
                    total = bujii * 20 + filtreAer * 50 + filtreBenzina * 75 + rotor * 5;
//
                myRef.child("Revizie " + String.valueOf(maxid + 1)).setValue(revizie);
                Toast.makeText(getApplicationContext(),
                        "Revizia a fost actualizata \nFirebase",
                        Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),
                        "Total: " + total,
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

}