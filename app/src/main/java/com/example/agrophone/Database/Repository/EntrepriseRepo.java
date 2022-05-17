package com.example.agrophone.Database.Repository;

import android.app.Application;

import com.example.agrophone.Database.Entity.Entreprise;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.entreprise.CreateEntreprise;

public class EntrepriseRepo {

    private static EntrepriseRepo instance;

    private EntrepriseRepo() {
    }

    public static EntrepriseRepo getInstance() {
        if (instance == null) {
            synchronized (EntrepriseRepo.class) {
                if (instance == null) {
                    instance = new EntrepriseRepo();
                }
            }
        }
        return instance;
    }

        public void insert(final Entreprise entreprise, OnAsyncEventListener callback,
                           Application application) {
        new CreateEntreprise(application, callback).execute(entreprise);
    }

}
