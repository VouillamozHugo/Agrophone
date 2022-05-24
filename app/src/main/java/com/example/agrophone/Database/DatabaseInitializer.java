package com.example.agrophone.Database;

import android.os.AsyncTask;
import android.util.Log;

import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Entity.Entreprise;
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

    private static void addEntreprise(final AppDatabase db,  final String nom, final String lieu, final int npa,final String region, final String gps, final String url, final String tel)
    {
        Entreprise entreprise = new Entreprise( nom, lieu, npa, region, gps,url,tel);
        db.entrepriseDAO().insert(entreprise);
    }

    private static void addAnimation(final AppDatabase db, final int idEntreprise,final String nom, final String type, final int nbMax, final int nbMin,
                                     final int nbActuel, final int npa, final String ville, final String region, final double prix, final String date,final String heureDebut, final String heureFin,final String description )
    {
        Animation animation = new Animation(idEntreprise,nom, type, nbMax, nbMin, nbActuel, npa, ville, region, prix, date,heureDebut, heureFin,description);
        db.animationDAO().insert(animation);
    }

    private static void addAnimationByParticipant(final AppDatabase db, final int idAnimation, final int idParticipant){
        AnimationByParticipant animationByParticipant = new AnimationByParticipant(idAnimation, idParticipant);
        db.animationByParticipantDAO().insert(animationByParticipant);
   }
    private static void populateWithTestData(AppDatabase db) {

        // Adding users
        db.animationDAO().deleteAll();
        db.participantDAO().deleteAll();

        db.entrepriseDAO().deleteAll();

        addParticipant(db, "vouillamoz", "hugo", "h.ch", "123", "07895855", "rue sieere", "Sierre", 1945, "Valais", "Suisse" );
        addParticipant(db, "Coimbra", "Daniel", "d@d.ch", "1234", "07895855", "rue sieere", "Sierre", 1945, "Valais", "Suisse" );
//        db.userDao().deleteAll();
//        addUser(db, "hugo.v@hes.ch", "password123", "Hugo", "Vouillamoz", "075248621");
//        addUser(db, "benjamin.m@hes.ch", "letmein123", "Benjamin", "Morel", "078689289");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addEntreprise(db, "Cave", "Geneve", 3000 ,"Geneve", "1243121241", "https://maSuperCave.ch", "0242584526");
        addEntreprise(db, "Vin", "Geneve", 3000 ,"Geneve", "1243121241", "https://acheteMonvin.ch", "0251475588");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        addAnimation(db, 1,"Viste Caves", "Visite", 10, 4, 10, 3961, "Sierre", "Valais", 10.00, "30.05.2022","10h15", "18h00","Visite des anciennes cave du vignobles saint carlos");
        addAnimation(db, 1, "Dégustationn de vin", "Dégustation", 35, 10, 15, 3961, "Sierre", "Valais", 35.00, "15.06.2022", "10h00", "20h:00", "Dégustation de vin blanc au bord des vignes");
        addAnimation(db, 2,"Visite Alpage", "Visite", 10, 2, 1, 3961, "Sion", "Valais", 5.00, "31.05.2022","10h15", "18h00", "super visite de ma cave");


    try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Adding entreprises
        addAnimationByParticipant(db, 1,1);
        addAnimationByParticipant(db, 1,2);

        addAnimationByParticipant(db, 2,1);
        addAnimationByParticipant(db, 2,2);


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
