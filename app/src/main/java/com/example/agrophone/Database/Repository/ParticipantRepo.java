package com.example.agrophone.Database.Repository;

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


}
