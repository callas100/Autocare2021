package com.example.autocare2021.clase6;

public class Reparatii {
    private String masina, data, service, reparatii;
    private int valoare;

    public Reparatii(String masina, String data, String service, String reparatii, int valoare) {
        this.masina = masina;
        this.data = data;
        this.service = service;
        this.reparatii = reparatii;
        this.valoare = valoare;
    }

    public Reparatii() {
        this.masina = "";
        this.data = "";
        this.service = "";
        this.reparatii = "";
        this.valoare = 0;
    }

    public String getMasina() {
        return masina;
    }

    public void setMasina(String masina) {
        this.masina = masina;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getReparatii() {
        return reparatii;
    }

    public void setReparatii(String reparatii) {
        this.reparatii = reparatii;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }

    @Override
    public String toString() {
        return "Reparatii{" +
                "masina='" + masina + '\'' +
                ", data='" + data + '\'' +
                ", service='" + service + '\'' +
                ", reparatii='" + reparatii + '\'' +
                ", valoare=" + valoare +
                '}';
    }
}
