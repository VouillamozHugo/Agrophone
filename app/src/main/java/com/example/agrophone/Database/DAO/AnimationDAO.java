package com.example.agrophone.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Animation;

import java.util.List;

@Dao
public interface AnimationDAO {

    @Query("SELECT * FROM animation")
    LiveData<List<Animation>> getAllAnimations();

    @Query("SELECT * FROM animation WHERE IDAnimation =:id")
    LiveData<List<Animation>> getAllByIdAnimation(int id);

}
