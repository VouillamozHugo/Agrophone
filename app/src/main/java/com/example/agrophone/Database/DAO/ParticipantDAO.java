package com.example.agrophone.Database.DAO;

import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Insert;

import com.example.agrophone.Database.Entity.Participant;


import androidx.room.Dao;

@Dao
public interface ParticipantDAO {

    @Insert
    void insert(Participant participant) throws SQLiteConstraintException;

}
