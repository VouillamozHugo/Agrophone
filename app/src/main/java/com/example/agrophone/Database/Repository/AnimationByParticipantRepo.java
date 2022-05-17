package com.example.agrophone.Database.Repository;

import android.app.Application;

import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.animationByParticipant.CreateAnimationByParticipant;

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

    public void insert(final AnimationByParticipant course, OnAsyncEventListener callback,
                       Application application) {
        new CreateAnimationByParticipant(application, callback).execute(course);
    }


}
