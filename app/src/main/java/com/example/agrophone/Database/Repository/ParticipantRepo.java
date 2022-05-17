package com.example.agrophone.Database.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Participant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.participant.CreateParticipant;

public class ParticipantRepo {

    private static ParticipantRepo instance;

    private ParticipantRepo() {
    }

    public static ParticipantRepo getInstance() {
        if (instance == null) {
            synchronized (ParticipantRepo.class) {
                if (instance == null) {
                    instance = new ParticipantRepo();
                }
            }
        }
        return instance;
    }


        public void insert(final Participant participant, OnAsyncEventListener callback,
                           Application application) {
        new CreateParticipant(application, callback).execute(participant);
    }

    public LiveData<Participant> getParticipantByCreds(Application application, String email, String password){
        return ((BaseAPP) application).getDatabase().participantDAO().getParticipantByCreds(email,password  );
    }

}
