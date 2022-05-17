package com.example.agrophone.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    private TextView dateInput;
    private TextView description;
    private TextView animationPrice;
    private TextView animationLieu;
    private TextView animationHeure;
    private TextView animationDisponibility;
    private Button animationInscription;
    private TextView animationName;

    private String animationID;

    private AnimationRepo animationRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_description);

        animationRepo = ((BaseAPP) getApplication()).getanimationRepo() ;

        dateInput = findViewById(R.id.date_input);
        description = findViewById(R.id.description);
        animationPrice = findViewById(R.id.animation_price);
        animationHeure = findViewById(R.id.animation_heure);
        animationLieu = findViewById(R.id.animation_lieu);
        animationDisponibility = findViewById(R.id.animation_disponibility);
        animationName = findViewById(R.id.animation_name_description);

        animationInscription = findViewById(R.id.animation_inscription);
        animationInscription.setOnClickListener(view -> inscription());

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_ANIMATION,0);
        animationID = preferences.getString(MainActivity.PREF_ANIMATION, "");
        System.out.println(animationID + "\n########################################################################");
        animationRepo.getAllByIdAnimation(getApplication(), Integer.valueOf(animationID) ).observe(this, animation -> {
          //  animationPrice.setText(String.valueOf(animation.getPrix()));
            description.setText(animation.getDescription());
            animationHeure.setText(animation.heureDebut);
            animationLieu.setText(animation.ville);
        });
    }

    private void inscription(){
        //rajouter l'animation actuelle à la liste d'animations du client actuels

        startActivity(new Intent(this, AnimationListActivity.class));
        finish();
    }

}
