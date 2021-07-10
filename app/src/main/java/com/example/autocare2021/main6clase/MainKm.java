package com.example.autocare2021.main6clase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Km;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainKm extends AppCompatActivity {
    private int reqCode = 0;
    EditText etDataKm, etOraKm, etIndexKm, etObsKm;
    long maxid;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.km);
        etDataKm = findViewById(R.id.etDataKm);
        etOraKm = findViewById(R.id.etOraKm);
        etIndexKm = findViewById(R.id.etIndexKm);
        etObsKm = findViewById(R.id.etObsKm);
        save = findViewById(R.id.btAdaugaKm);
//
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //obtinem o referinta
        //se creeaza o inregistrare cu numele "Actualizare Km"
        final DatabaseReference myRef = database.getReference().child("Actualizari Km");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                    maxid = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etDataKm.getText().toString(),
                        observatii = etObsKm.getText().toString();
                int ora = Integer.parseInt(etOraKm.getText().toString()),
                        index = Integer.parseInt(etIndexKm.getText().toString());
                Km km = new Km(data, ora, index, observatii);
//
                myRef.child("Actualizare " + String.valueOf(maxid + 1)).setValue(km);
                Toast.makeText(getApplicationContext(),
                        "Km au fost actualizati \n Firebase",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}