package com.example.agrophone.Database.DAO;

import android.database.sqlite.SQLiteConstraintException;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Entity.Participant;

import java.util.List;

@Dao
public interface AnimationDAO {

    @Query("SELECT * FROM animation")
    LiveData<List<Animation>> getAllAnimations();

    @Query("SELECT * FROM animation WHERE IDAnimation =:id")
    LiveData<Animation> getAllByIdAnimation(int id);

    @Query("SELECT * FROM animation WHERE Date =:date")
    LiveData<List<Animation>> getAllAnimationsByDate(String date);

    @Delete
    void delete(Animation animation);

    @Query("DELETE FROM animation")
    void deleteAll();

    @Query("UPDATE animation SET NombreActuelParticipant = NombreActuelParticipant + 1 WHERE idAnimation=:id")
    void update(int id );


    @Insert
    void insert(Animation animation) throws SQLiteConstraintException;
}
