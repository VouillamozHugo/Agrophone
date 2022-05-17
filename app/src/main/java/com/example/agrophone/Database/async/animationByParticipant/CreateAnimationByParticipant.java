package com.example.agrophone.Database.async.animationByParticipant;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class CreateAnimationByParticipant extends AsyncTask<AnimationByParticipant, Void, Void> {

    private final Application application;
    private final OnAsyncEventListener callback;
    private Exception exception;

    public CreateAnimationByParticipant(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(AnimationByParticipant... courses) {
        try {
            for (AnimationByParticipant course : courses)
                ((BaseAPP) application).getDatabase().animationByParticipantDAO().insert(course);
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
