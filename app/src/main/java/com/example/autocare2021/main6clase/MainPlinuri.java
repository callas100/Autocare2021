package com.example.autocare2021.main6clase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.example.autocare2021.R;
import com.example.autocare2021.original.Masina;

public class MainPlinuri extends AppCompatActivity {
    NumberPicker npL1, npL2, npL3,
            npR1, npR2, npR3,
            npM1, npM2, npM3;
    EditText data, ora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plinuri);
        //region numberPicker
        npL1 = findViewById(R.id.npL1);
        npL2 = findViewById(R.id.npL2);
        npL3 = findViewById(R.id.npL3);
        npR1 = findViewById(R.id.npR1);
        npR2 = findViewById(R.id.npR2);
        npR3 = findViewById(R.id.npR3);
        npM1 = findViewById(R.id.npM1);
        npM2 = findViewById(R.id.npM2);
        npM3 = findViewById(R.id.npM3);
//
        npL1.setMinValue(0);
        npL1.setValue(1);
        npL1.setMaxValue(30);
        npL2.setMinValue(0);
        npL2.setValue(1);
        npL2.setMaxValue(30);
        npL3.setMinValue(0);
        npL3.setValue(1);
        npL3.setMaxValue(30);
//
        npR1.setMinValue(0);
        npR1.setValue(1);
        npR1.setMaxValue(30);
        npR2.setMinValue(0);
        npR2.setValue(1);
        npR2.setMaxValue(30);
        npR3.setMinValue(0);
        npR3.setValue(1);
        npR3.setMaxValue(30);
//
        npM1.setMinValue(0);
        npM1.setValue(1);
        npM1.setMaxValue(30);
        npM2.setMinValue(0);
        npM2.setValue(1);
        npM2.setMaxValue(30);
        npM3.setMinValue(0);
        npM3.setValue(1);
        npM3.setMaxValue(30);
//
        npL1 = findViewById(R.id.npL1);
        npL2 = findViewById(R.id.npL2);
        npL3 = findViewById(R.id.npL3);
        npR1 = findViewById(R.id.npR1);
        npR2 = findViewById(R.id.npR2);
        npR3 = findViewById(R.id.npR3);
        npM1 = findViewById(R.id.npM1);
        npM2 = findViewById(R.id.npM2);
        npM3 = findViewById(R.id.npM3);
        int npL1v = npL1.getValue(), npL2v = npL2.getValue(), npL3v = npL3.getValue(),
                npR1v = npR1.getValue(), npR2v = npR2.getValue(), npR3v = npR3.getValue(),
                npM1v = npM1.getValue(), npM2v = npM1.getValue(), npM3v = npM1.getValue();
        //endregion
    }

}