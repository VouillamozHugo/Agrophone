package com.example.agrophone.Database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;

import java.util.List;

public interface AnimationByParticipantDAO {

    @Query("SELECT * FROM animationByParticipant WHERE idParticipant = :id")
    LiveData<List<AnimationByParticipant>> getAnimationByParticipant(int id);

}
