package com.example.agrophone;

import android.app.Application;

import com.example.agrophone.Database.AppDatabase;
import com.example.agrophone.Database.Repository.AnimationByParticipantRepo;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.Database.Repository.EntrepriseRepo;
import com.example.agrophone.Database.Repository.ParticipantRepo;

public class BaseAPP extends Application {

    @Override
    public void onCreate(){super.onCreate();}

    public AppDatabase getDatabase(){return AppDatabase.getAppDateBase(this);}

    public EntrepriseRepo getEntrepriseRepo(){return EntrepriseRepo.getInstance();}
    public AnimationRepo getanimationRepo(){return AnimationRepo.getInstance();}
    public ParticipantRepo getParticipantRepo(){return ParticipantRepo.getInstance();}
    public AnimationByParticipantRepo getAnimationByParticipantRepo(){return AnimationByParticipantRepo.getInstance();}


}
