package com.example.agrophone.Database.async.entreprise;

import android.app.Application;
import android.os.AsyncTask;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Entreprise;
import com.example.agrophone.Database.Util.OnAsyncEventListener;

public class CreateEntreprise extends AsyncTask<Entreprise, Void, Void> {

    private final Application application;
    private final OnAsyncEventListener callback;
    private Exception exception;

    public CreateEntreprise(Application application, OnAsyncEventListener callback) {
        this.application = application;
        this.callback = callback;
    }


    @Override
    protected Void doInBackground(Entreprise... courses) {
        try {
            for (Entreprise course : courses)
                ((BaseAPP) application).getDatabase().entrepriseDAO().insert(course);
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
