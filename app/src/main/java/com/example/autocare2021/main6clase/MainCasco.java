package com.example.autocare2021.main6clase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.autocare2021.R;

public class MainCasco extends AppCompatActivity {

    EditText etSofer, etAuto, etMotor, etGreutate;
    Switch swAsigurat;
    Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casco);
//
        etSofer = findViewById(R.id.etSofer);
        etAuto = findViewById(R.id.etTipAuto);
        etMotor = findViewById(R.id.etMotor);
        etGreutate = findViewById(R.id.etGreutate);
        swAsigurat = findViewById(R.id.swAsigurat);
        btSave = findViewById(R.id.btAdaugaCasco);
//
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sofer = etSofer.getText().toString(),
                        auto = etAuto.getText().toString();
                int motor = Integer.parseInt(etMotor.getText().toString()),
                        greutate = Integer.parseInt(etGreutate.getText().toString());
                boolean isAsigurat = swAsigurat.isChecked();
//
                SharedPreferences sharedPreferences = getSharedPreferences("preferinteCasco", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
//
                editor.putString("sofer", sofer);
                editor.putString("auto", auto);
                editor.putInt("motor", motor);
                editor.putInt("greutate", greutate);
                editor.putBoolean("isAsigurat", isAsigurat);
                editor.commit();
//
                Intent intent = new Intent();
                Toast.makeText(MainCasco.this,
                        "Casco a fost actualizat \n SharedPreferences",
                        Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }


}