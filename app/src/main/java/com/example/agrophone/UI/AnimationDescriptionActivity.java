package com.example.agrophone.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.R;

public class AnimationDescriptionActivity extends AppCompatActivity {
    /*
    Quand l'utilisateur clique sur l'image
    date_input textView, description textView, animation_price textView, animation_heure textView,
    animation_lieu textView, animation_disponibility textView, animation_inscription Button
     */

    private TextView animationName;
    private TextView animationPrice;
    private TextView dateInput;
    private TextView description;

    private TextView animationLieu;
    private TextView animationHeure;
    private TextView animationDisponibility;
    private Button animationInscription;

    private Button infoCompany;


    private String animationID;

    private AnimationRepo animationRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_description);

        animationRepo = ((BaseAPP) getApplication()).getanimationRepo() ;

        animationName = findViewById(R.id.animation_detail);

        dateInput = findViewById(R.id.date_input);
        description = findViewById(R.id.description);
        animationPrice = findViewById(R.id.animation_price);
        animationHeure = findViewById(R.id.animation_heure);
        animationLieu = findViewById(R.id.animation_lieu);
        animationDisponibility = findViewById(R.id.animation_disponibility);
        animationInscription = findViewById(R.id.animation_inscription);

    //    infoCompany.findViewById(R.id.detail_company);


        animationInscription.setOnClickListener(view -> inscription());

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_ANIMATION,0);
        animationID = preferences.getString(MainActivity.PREF_ANIMATION, "");
        System.out.println(animationID + "\n########################################################################");
        animationRepo.getAllByIdAnimation(getApplication(), Integer.valueOf(animationID) ).observe(this, animation -> {
          //  animationPrice.setText(String.valueOf(animation.getPrix()));
            animationName.setText(animation.getNomAnimation());
            dateInput.setText("Heure de début : " + animation.getHeureDebut());
            description.setText(animation.getDescription());
         //   animationHeure.setText(animation.heureDebut);
            animationHeure.setText("");
            animationLieu.setText("Lieu : " + animation.ville);
            animationPrice.setText(String.valueOf(animation.getPrix()));
            int placeDisponible = animation.getNombreMaxParticipants() - animation.getNombreActuelParticipant();
            if(placeDisponible * 2 > animation.getNombreMaxParticipants()){
                animationDisponibility.setTextColor(Color.RED);
            }else{
                animationDisponibility.setTextColor(Color.GREEN);
            }
            animationDisponibility.setText("Nombre actuel de participant inscrit : " + String.valueOf(placeDisponible) + "/" + animation.getNombreMaxParticipants());
        });
    }

    private void inscription(){
        //rajouter l'animation actuelle à la liste d'animations du client actuels

        startActivity(new Intent(this, AnimationListActivity.class));
        finish();
    }

}
