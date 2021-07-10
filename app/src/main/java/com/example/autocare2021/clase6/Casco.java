package com.example.autocare2021.clase6;

public class Casco {
    private String sofer, auto;
    private int motor, greutate;
    private boolean isAsigurat;

    public Casco(String sofer, String auto, int motor, int greutate, boolean isAsigurat) {
        this.sofer = sofer;
        this.auto = auto;
        this.motor = motor;
        this.greutate = greutate;
        this.isAsigurat = isAsigurat;
    }

    public Casco() {
        this.sofer = "";
        this.auto = "";
        this.motor = 0;
        this.greutate = 0;
        this.isAsigurat = false;
    }

    public String getSofer() {
        return sofer;
    }

    public void setSofer(String sofer) {
        this.sofer = sofer;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public int getGreutate() {
        return greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
    }

    public boolean isAsigurat() {
        return isAsigurat;
    }

    public void setAsigurat(boolean asigurat) {
        isAsigurat = asigurat;
    }

    @Override
    public String toString() {
        return "Casco{" +
                "sofer='" + sofer + '\'' +
                ", auto='" + auto + '\'' +
                ", motor=" + motor +
                ", greutate=" + greutate +
                ", isAsigurat=" + isAsigurat +
                '}';
    }
}
