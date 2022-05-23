package com.example.agrophone.Database.async.animation;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class UpdateAnimation extends AsyncTask<Animation, Void, Void> {

    private final Application application;
    private final OnAsyncEventListener callback;
    private Exception exception;


    public UpdateAnimation(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Animation... params) {
        try {
            for (Animation animation : params)
                ((BaseAPP) application).getDatabase().animationDAO()
                        .update(animation.getIDAnimation());
        } catch (Exception e) {
            this.exception = e;
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
