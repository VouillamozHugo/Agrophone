package com.example.agrophone.Database.DAO;

import android.database.sqlite.SQLiteConstraintException;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;

import java.util.List;

@Dao
public interface AnimationDAO {

    @Query("SELECT * FROM animation")
    LiveData<List<Animation>> getAllAnimations();

    @Query("SELECT * FROM animation WHERE IDAnimation =:id")
    LiveData<List<Animation>> getAllByIdAnimation(int id);

    @Delete
    void delete(Animation animation);

    @Query("DELETE FROM animation")
    void deleteAll();

    @Insert
    void insert(Animation animation) throws SQLiteConstraintException;
}
