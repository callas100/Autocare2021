package com.example.autocare2021.clase6;

public class Revizii {
    private int bujii,
            filtruAer,
            filtruBenzina,
            rotor;
    private boolean schimbUlei;

    public Revizii(int bujii, int filtruAer, int filtruBenzina, int rotor, boolean schimbUlei) {
        this.bujii = bujii;
        this.filtruAer = filtruAer;
        this.filtruBenzina = filtruBenzina;
        this.rotor = rotor;
        this.schimbUlei = schimbUlei;
    }

    public Revizii() {
        this.bujii = 0;
        this.filtruAer = 0;
        this.filtruBenzina = 0;
        this.rotor = 0;
        this.schimbUlei = false;

    }

    public int getBujii() {
        return bujii;
    }

    public void setBujii(int bujii) {
        this.bujii = bujii;
    }

    public int getFiltruAer() {
        return filtruAer;
    }

    public void setFiltruAer(int filtruAer) {
        this.filtruAer = filtruAer;
    }

    public int getFiltruBenzina() {
        return filtruBenzina;
    }

    public void setFiltruBenzina(int filtruBenzina) {
        this.filtruBenzina = filtruBenzina;
    }

    public int getRotor() {
        return rotor;
    }

    public void setRotor(int rotor) {
        this.rotor = rotor;
    }

    public boolean isSchimbUlei() {
        return schimbUlei;
    }

    public void setSchimbUlei(boolean schimbUlei) {
        this.schimbUlei = schimbUlei;
    }

    @Override
    public String toString() {
        return "Revizii{" +
                "bujii=" + bujii +
                ", filtruAer=" + filtruAer +
                ", filtruBenzina=" + filtruBenzina +
                ", rotor=" + rotor +
                ", schimbUlei=" + schimbUlei +
                "Total: " + this.bujii * 100 + " lei" +
                '}';
    }
}
