package com.example.autocare2021.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.autocare2021.original.Masina;

import java.util.List;

@Dao
public interface MasinaDAO {

    @Insert
    void inserareMasinaRoom(Masina masina);

    @Update
    void updateMasinaRoom(Masina masina);

    @Delete
    void deleteMasinaRoom(Masina masina);

    @Query("DELETE FROM MASINI")
    void deleteAllMasinaRoom();

    @Query("SELECT * FROM MASINI ORDER BY ID ASC")
    List<Masina> getAllMasina();

}

