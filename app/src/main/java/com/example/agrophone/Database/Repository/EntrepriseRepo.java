package com.example.agrophone.Database.Repository;

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

}
