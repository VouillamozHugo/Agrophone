package com.example.agrophone.Database.DAO;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Delete;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.agrophone.Database.Entity.Participant;


import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface ParticipantDAO {

    @Insert
    void insert(Participant participant) throws SQLiteConstraintException;

    @Delete
    void delete(Participant participant);

    @Query("DELETE FROM participant")
    void deleteAll();

    @Query("SELECT * FROM PARTICIPANT WHERE Email=:email AND Password=:password")
    LiveData<Participant> getParticipantByCreds(String email, String password);

}
