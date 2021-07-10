package com.example.autocare2021.original;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autocare2021.R;

public class Login extends AppCompatActivity {

    private EditText etUsername;
    private EditText etParola;
    private TextView tvTries;
    private Button btLogin;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
//
        etUsername = (EditText) findViewById(R.id.etUsername);
        etParola = (EditText) findViewById(R.id.etParola);
        btLogin = (Button) findViewById(R.id.btLogin);
        tvTries = (TextView) findViewById(R.id.tvTries);
//
        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loginValidation(etUsername.getText().toString(), etParola.getText().toString());

            }
        });
    }

    private void loginValidation(String username, String password) {
        if ((username.equals("razvan1080") && password.equals("admin")) ||
                (username.equals("filip1080") && password.equals("admin"))) {
            if (((CheckBox) findViewById(R.id.cb1)).isChecked()) {
                etUsername = (EditText) findViewById(R.id.etUsername);
                etParola = (EditText) findViewById(R.id.etParola);
                etUsername.setText(username);
                etParola.setText(password);
                Toast.makeText(this, "Utilizatorul a fost salvat", Toast.LENGTH_SHORT).show();
            } else if (!(((CheckBox) findViewById(R.id.cb1)).isChecked())) {
                etUsername = (EditText) findViewById(R.id.etUsername);
                etParola = (EditText) findViewById(R.id.etParola);
                etUsername.setText(null);
                etParola.setText(null);
                Toast.makeText(this, "Utilizatorul NU fost salvat", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getApplicationContext(), AlegeMasina.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Bine ati venit!", Toast.LENGTH_SHORT).show();
        } else {
            counter--;
            tvTries.setText("Mai aveti " + counter + " incercari");
            if (counter == 1)
                tvTries.setText("Mai aveti o incercare");
            if (counter == 0) {
                btLogin.setEnabled(false);
                btLogin.setBackgroundColor(Color.rgb(110, 110, 110));
            }
        }
    }


}