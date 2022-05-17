package com.example.agrophone.Database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.agrophone.Database.Entity.Participant;

public class DatabaseInitializer {

    public static final String TAG = "DatabaseInitializer";

    public static void populateDatabase(final AppDatabase db) {
        Log.i(TAG, "Inserting demo data.");
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }



    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase database;

        PopulateDbAsync(AppDatabase db) {
            database = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(database);
            return null;
        }
    }


    private static void addParticipant(final AppDatabase db, final String nomParticipant, final String prenomParticipant, final String email,
                                final String password, final String telephone,final String addressParticipant, final String lieuParticipant, final int npaParticipant, final String regionParticipant, final String payaParticipant) {

        Participant participant = new Participant(nomParticipant, prenomParticipant, email, password, telephone, addressParticipant, lieuParticipant, npaParticipant, regionParticipant, payaParticipant);
        db.participantDAO().insert(participant);
    }

    private static void populateWithTestData(AppDatabase db) {

        // Adding users
        addParticipant(db, "vouillamoz", "hugo", "h@h.ch", "123", "07895855", "rue sieere", "Sierre", 1945, "Valais", "Suisse" );
        addParticipant(db, "Coimbra", "Daniel", "d@d.ch", "1234", "07895855", "rue sieere", "Sierre", 1945, "Valais", "Suisse" );
//        db.userDao().deleteAll();
//        addUser(db, "hugo.v@hes.ch", "password123", "Hugo", "Vouillamoz", "075248621");
//        addUser(db, "benjamin.m@hes.ch", "letmein123", "Benjamin", "Morel", "078689289");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Adding rides
    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Adding courses

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
