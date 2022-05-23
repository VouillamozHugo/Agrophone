package com.example.agrophone.Database.Repository;


import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.animation.CreateAnimation;
import com.example.agrophone.Database.async.animation.DeleteAnimation;
import com.example.agrophone.Database.async.animationByParticipant.CreateAnimationByParticipant;

import java.util.List;

public class AnimationRepo {

    private static AnimationRepo instance;

    private AnimationRepo() {
    }

    public static AnimationRepo getInstance() {
        if (instance == null) {
            synchronized (AnimationRepo.class) {
                if (instance == null) {
                    instance = new AnimationRepo();
                }
            }
        }
        return instance;
    }

    public void insert(final Animation animation, OnAsyncEventListener callback,
                       Application application) {
        new CreateAnimation(application, callback).execute(animation);
    }


    public LiveData<List<Animation>> getAllAnimations(Application application) {
        return ((BaseAPP) application).getDatabase().animationDAO().getAllAnimations();
    }

    public LiveData<Animation> getAllByIdAnimation(Application application,int id) {
        return ((BaseAPP) application).getDatabase().animationDAO().getAllByIdAnimation(id);
    }

    public LiveData<List<Animation>> getAllAnimationsByDate(Application application, String date) {
        return ((BaseAPP) application).getDatabase().animationDAO().getAllAnimationsByDate(date);
    }

    public void delete(final Animation animation, OnAsyncEventListener callback,
                       Application application) {
        new DeleteAnimation(application, callback).execute(animation);
    }
}
