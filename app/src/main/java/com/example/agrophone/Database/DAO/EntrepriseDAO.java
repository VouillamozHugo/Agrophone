package com.example.agrophone.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Entreprise;

@Dao
public interface EntrepriseDAO {


    @Query("SELECT * FROM entreprise WHERE IdEntreprise=:id")
    LiveData<Entreprise> getEntrepriseByID(int id);


    @Insert
    void insert(Entreprise entreprise);
}
