package com.example.agrophone.Database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Entity.Entreprise;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.animationByParticipant.CreateAnimationByParticipant;
import com.example.agrophone.Database.async.entreprise.CreateEntreprise;

import java.util.List;

public class AnimationByParticipantRepo {

    private static  AnimationByParticipantRepo instance;

    private AnimationByParticipantRepo(){

    }

    public static AnimationByParticipantRepo getInstance(){
        if(instance == null){
            synchronized (AnimationByParticipantRepo.class){
                if(instance == null){
                    instance = new AnimationByParticipantRepo();
                }
            }
        }

        return instance;
    }

    public LiveData<List<AnimationByParticipant>> getAnimationByParticipant(Application application, int id){
        return ((BaseAPP) application).getDatabase().animationByParticipantDAO().getAnimationByParticipant(id);
    }

    public void insert(final AnimationByParticipant animationByParticipant, OnAsyncEventListener callback,
                       Application application) {
        new CreateAnimationByParticipant(application, callback).execute(animationByParticipant);
    }

}
