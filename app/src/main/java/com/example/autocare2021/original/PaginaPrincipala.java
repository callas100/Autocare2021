package com.example.autocare2021.original;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.autocare2021.R;
import com.example.autocare2021.main6clase.MainKm;
import com.example.autocare2021.main6clase.MainCasco;
import com.example.autocare2021.main6clase.MainPlinuri;
import com.example.autocare2021.main6clase.MainReparatii;
import com.example.autocare2021.main6clase.MainRevizii;
import com.example.autocare2021.main6clase.MainRovinieta;
import com.example.autocare2021.main6clase.InfoFull;


public class PaginaPrincipala extends AppCompatActivity {
    private int reqCode = 1080;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_principala);
        //region 6butoane
        Button btKm = findViewById(R.id.btKm);
        btKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentKm = new Intent(getApplicationContext(), MainKm.class);
                startActivityForResult(intentKm, reqCode);

            }
        });
        //
        Button btReparatii = findViewById(R.id.btReparatii);
        btReparatii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRep = new Intent(getApplicationContext(), MainReparatii.class);
                startActivity(intentRep);
            }
        });
        //
        Button btRevizii = findViewById(R.id.btRevizii);
        btRevizii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRev = new Intent(getApplicationContext(), MainRevizii.class);
                startActivity(intentRev);
            }
        });
        //
        Button btPlinuri = findViewById(R.id.btPlinuri);
        btPlinuri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPlin = new Intent(getApplicationContext(), MainPlinuri.class);
                startActivity(intentPlin);
            }
        });
        //
        Button btCasco = findViewById(R.id.btCASCO);
        btCasco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCasco = new Intent(getApplicationContext(), MainCasco.class);
                startActivity(intentCasco);
            }
        });
        //
        Button btRovinieta = findViewById(R.id.btRovinieta);
        btRovinieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRov = new Intent(getApplicationContext(), MainRovinieta.class);
                startActivity(intentRov);
            }
        });
        ImageButton btInfo = findViewById(R.id.btImageInfo);
        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoFull.class);
                startActivity(intentInfo);
            }

        });
        //endregion
        //
        Masina masina = getIntent().getParcelableExtra("masina");
        Toast.makeText(this, masina.toString(), Toast.LENGTH_SHORT).show();
//
    }
}