package com.example.agrophone.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.Entreprise;

@Dao
public interface EntrepriseDAO {


    @Query("SELECT * FROM entreprise WHERE IdEntreprise=:id")
    LiveData<Entreprise> getEntrepriseByID(int id);

    @Delete
    void delete(Entreprise entreprise);

    @Query("DELETE FROM entreprise")
    void deleteAll();

    @Insert
    void insert(Entreprise entreprise);
}
