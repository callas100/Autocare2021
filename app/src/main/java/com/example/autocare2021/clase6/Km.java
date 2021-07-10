package com.example.autocare2021.clase6;

public class Km {

    private String data;
    private int ora,
            index;
    private String observatii;

    public Km(String data, int ora, int index) {
        this.data = data;
        this.ora = ora;
        this.index = index;
        this.observatii = null;
    }

    public Km() {
        this.data = "-";
        this.ora = 0;
        this.index = 0;
        this.observatii = "-";
    }

    public Km(String data, int ora, int index, String observatii) {
        this.data = data;
        this.ora = ora;
        this.index = index;
        this.observatii = observatii;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
