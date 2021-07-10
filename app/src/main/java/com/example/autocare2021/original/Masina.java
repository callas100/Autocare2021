package com.example.autocare2021.original;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//implementam Parcelable ca sa nu consumam prea multe resurse
//ADD PARCELABLE IMPLEMENTATIONS
@Entity(tableName = "Masini") //param cu numele tabelei
public class Masina implements Parcelable {
    //SQLite offline database
    //Room-biblioteca care ne permite sa folosim SQLite(ORM) object relationship-method?
    //principalele componente Room
    //entitatile
    //interfete->DataAccessObject
    //MasinaDataBase
//
    //pt ca id sa fie primary key
    @PrimaryKey(autoGenerate = true)
    private int id;
    //asa putem numi coloana intr un anumit fel
    @ColumnInfo(name = "nrInmatriculare")
    private String nrInmatriculare;
    private String marca;
    private String model;
    private String data;
    private String combustibil;
    private int an;
    private int capacitate;
    private boolean isAsigurata;
    //region constructori+parcelable

    //
    //metoda care face serializarea-atribute primitive/ser
    //
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nrInmatriculare);
        dest.writeString(marca);
        dest.writeString(model);
        dest.writeString(data);
        dest.writeInt(an);
        dest.writeString(combustibil);
        dest.writeInt(capacitate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Masina(Parcel in) {
        nrInmatriculare = in.readString();
        marca = in.readString();
        model = in.readString();
        data = in.readString();
        an = in.readInt();
        combustibil = in.readString();
        capacitate = in.readInt();
        isAsigurata = in.readBoolean();
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };


    public Masina() {
        this.nrInmatriculare = "00-00-000";
        this.marca = "-";
        this.model = "-";
        this.data = "01-01-1970";
        this.an = 1970;
        this.combustibil = "-";
        this.capacitate = 0;
        this.isAsigurata = false;

    }


    public Masina(String nrInmatriculare, String marca, String model, String data,
                  int an, String combustibil, int capacitate, boolean isAsigurata) {
        this.nrInmatriculare = nrInmatriculare;
        this.marca = marca;
        this.model = model;
        this.data = data;
        this.an = an;
        this.combustibil = combustibil;
        this.capacitate = capacitate;
        this.isAsigurata = isAsigurata;
    }
    //endregion
    //region setteri

    public void setId(int id) {
        this.id = id;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public void setCombustibil(String combustibil) {
        this.combustibil = combustibil;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public void setAsigurata(boolean asigurata) {
        isAsigurata = asigurata;
    }
    //endregion
    //region getteri

    public int getId() {
        return id;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String getData() {
        return data;
    }

    public int getAn() {
        return an;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public boolean isAsigurata() {
        return isAsigurata;
    }
    //endregion

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", data='" + data + '\'' +
                ", an=" + an +
                ", combustibil='" + combustibil + '\'' +
                ", capacitate=" + capacitate +
                ", isAsigurata=" + isAsigurata +
                '}';
    }
}
