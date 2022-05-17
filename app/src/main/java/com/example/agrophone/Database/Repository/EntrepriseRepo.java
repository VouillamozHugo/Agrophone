package com.example.agrophone.Database.Repository;

import android.app.Application;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.Entreprise;
import com.example.agrophone.Database.Util.OnAsyncEventListener;
import com.example.agrophone.Database.async.animation.DeleteAnimation;
import com.example.agrophone.Database.async.entreprise.CreateEntreprise;
import com.example.agrophone.Database.async.entreprise.DeleteEntreprise;

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

    public void delete(final Entreprise entreprise, OnAsyncEventListener callback,
                       Application application) {
        new DeleteEntreprise(application, callback).execute(entreprise);
    }

}
