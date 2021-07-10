package com.example.autocare2021.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.autocare2021.original.Masina;

//@1 Entities --lista cu tabele pe care le va contine baza de date--1 tabel
//daca vrem sa adaugam coloane, schimbam versiunea (+1)
@Database(entities = {Masina.class}, version = 1)
public abstract class MasinaDataBase extends RoomDatabase {

    private static MasinaDataBase instance;

    public abstract MasinaDAO getMasinaDAO();


}
