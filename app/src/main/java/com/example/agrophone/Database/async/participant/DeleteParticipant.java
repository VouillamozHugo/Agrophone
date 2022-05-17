package com.example.agrophone.Database.async.participant;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.Participant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class DeleteParticipant extends AsyncTask<Participant, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public DeleteParticipant(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Participant... params) {
        try {
            for (Participant participant : params)
                ((BaseAPP) application).getDatabase().participantDAO()
                        .delete(participant);
        } catch (Exception e) {
            exception = e;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (callback != null) {
            if (exception == null) {
                callback.onSuccess();
            } else {
                callback.onFailure(exception);
            }
        }
    }

}
