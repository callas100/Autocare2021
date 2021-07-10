package com.example.autocare2021.main6clase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autocare2021.R;
import com.example.autocare2021.clase6.Km;
import com.example.autocare2021.clase6.Reparatii;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainReparatii extends AppCompatActivity {
    private int reqCode = 0;
    EditText etMasina, etData, etService, etRepObs, etValoare;
    Button save;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reparatii);
//
        etMasina = findViewById(R.id.etRepMasina);
        etData = findViewById(R.id.etRepData);
        etService = findViewById(R.id.etService);
        etRepObs = findViewById(R.id.etRepObs);
        etValoare = findViewById(R.id.etRepValoare);
        save = findViewById(R.id.btAdaugaReparatii);
//
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference().child("Reparatii");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Iterable<DataSnapshot> actualizariKm = snapshot.getChildren();
//                for (DataSnapshot actualizari :actualizariKm) {
//                    Toast.makeText(MainKm.this, actualizari
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
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masina = etMasina.getText().toString(),
                        data = etData.getText().toString(),
                        service = etData.getText().toString(),
                        observatii = etRepObs.getText().toString();
                int valoare = Integer.parseInt(etValoare.getText().toString());
//
                Reparatii reparatii = new Reparatii(masina, data, service, observatii, valoare);
//
                myRef.child("Reparatie " + String.valueOf(maxid + 1)).setValue(reparatii);
                Toast.makeText(getApplicationContext(),
                        "Reparatia a fost actualizata \n Firebase",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}