package com.example.agrophone.Database.Repository;

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

}
