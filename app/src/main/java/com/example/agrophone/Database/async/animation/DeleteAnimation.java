package com.example.agrophone.Database.async.animation;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class DeleteAnimation extends AsyncTask<Animation, Void, Void> {


    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public DeleteAnimation(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Animation... params) {
        try {
            for (Animation animation : params)
                ((BaseAPP) application).getDatabase().animationDAO()
                        .delete(animation);
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
