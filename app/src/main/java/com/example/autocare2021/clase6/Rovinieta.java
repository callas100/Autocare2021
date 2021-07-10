package com.example.autocare2021.clase6;

import android.widget.EditText;

public class Rovinieta {
    private String data, nrInmatriculareRov, permis, zona;
    private int gabarit;


    public Rovinieta() {
        this.data = "-";
        this.nrInmatriculareRov = "-";
        this.permis = "-";
        this.zona = "-";
        this.gabarit = 0;
    }

    public Rovinieta(String data, String nrInmatriculareRov,
                     String permis, String zona, int gabarit) {
        this.data = data;
        this.nrInmatriculareRov = nrInmatriculareRov;
        this.permis = permis;
        this.zona = zona;
        this.gabarit = gabarit;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNrInmatriculareRov() {
        return nrInmatriculareRov;
    }

    public void setNrInmatriculareRov(String nrInmatriculareRov) {
        this.nrInmatriculareRov = nrInmatriculareRov;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getGabarit() {
        return gabarit;
    }

    public void setGabarit(int gabarit) {
        this.gabarit = gabarit;
    }

    @Override
    public String toString() {
        return "Rovinieta{" +
                "data='" + data + '\'' +
                ", nrInmatriculareRov='" + nrInmatriculareRov + '\'' +
                ", permis='" + permis + '\'' +
                ", zona='" + zona + '\'' +
                ", gabarit=" + gabarit +
                '}';
    }
}
