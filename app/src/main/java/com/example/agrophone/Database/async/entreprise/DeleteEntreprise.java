package com.example.agrophone.Database.async.entreprise;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.Entreprise;
import com.example.agrophone.Database.Entity.Participant;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class DeleteEntreprise extends AsyncTask<Entreprise, Void, Void> {

    private Application application;
    private OnAsyncEventListener callback;
    private Exception exception;

    public DeleteEntreprise(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Entreprise... params) {
        try {
            for (Entreprise entreprise : params)
                ((BaseAPP) application).getDatabase().entrepriseDAO()
                        .delete(entreprise);
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
