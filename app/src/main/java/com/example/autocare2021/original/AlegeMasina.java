package com.example.autocare2021.original;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.autocare2021.adaptere.MasinaAdapter;
import com.example.autocare2021.R;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AlegeMasina extends AppCompatActivity {
    private int reqCode = 1080;
    private List<Masina> masinaList;
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDateTime data = LocalDateTime.now();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alege_masina);
        ListView lv = findViewById(R.id.lvAlegeMasina);
        //
        Button btAdd = findViewById(R.id.btAdaugaMasina);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugareMasina.class);
                startActivityForResult(intent, reqCode);
            }
        });
//lista ar trebui declarata ca atribut si initializata in metoda
        masinaList = new ArrayList<>();
//
        Masina m1 = new Masina("Rm-45-WER", "Dacia", "Elite", dtf.format(data),
                1960, "Hybrid", 25, true);
        Masina m2 = new Masina();
        Masina m3 = new Masina("test", "test2", "test3", dtf.format(data),
                2021, "benzina", 69, true);
        Masina m4 = new Masina("test4", "test4", "test4", dtf.format(data),
                2021, "benzina4", 123, true);
        Masina m5 = new Masina("test5", "test5", "test5", dtf.format(data),
                2021, "benzina5", 123, true);
        Masina m6 = new Masina("test6", "test6", "test6", dtf.format(data),
                1990, "benzina6", 123, true);
        Masina m7 = new Masina();
//
        masinaList.add(m1);
        masinaList.add(m2);
        masinaList.add(m3);
        masinaList.add(m4);
        masinaList.add(m5);
        masinaList.add(m6);
        masinaList.add(m7);
//
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(),
                        PaginaPrincipala.class);
                Masina masina = masinaList.get(position);
                intent.putExtra("masina", masina);
                startActivity(intent);
            }
        });
//
        MasinaAdapter adapter = new MasinaAdapter(masinaList, this);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == reqCode)
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("info"), Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Masina NU a fost adaugata", Toast.LENGTH_SHORT).show();
    }
}
