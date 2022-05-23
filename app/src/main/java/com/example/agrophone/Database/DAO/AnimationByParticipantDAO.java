package com.example.agrophone.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;

import java.util.List;

@Dao
public interface AnimationByParticipantDAO {

    @Query("SELECT * FROM animationByParticipant WHERE idParticipant = :id")
    LiveData<List<AnimationByParticipant>> getAnimationByParticipant(int id);


    @Insert
    void insert(AnimationByParticipant animationByParticipant);
}
