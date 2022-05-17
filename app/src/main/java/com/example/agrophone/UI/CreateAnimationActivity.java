package com.example.agrophone.UI;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agrophone.R;

public class CreateAnimationActivity extends AppCompatActivity {
    private EditText animationName;
    private Spinner animationType;
    private EditText animationLieu;
    private EditText animationDate;
    private EditText minimum;
    private EditText maximum;
    private EditText price;
    private EditText description;
    private Button create;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationName = findViewById(R.id.animation_name);
        animationType = findViewById(R.id.animation_type);
        animationLieu = findViewById(R.id.animation_create_lieu);
        animationDate = findViewById(R.id.animation_create_date);
        minimum = findViewById(R.id.disponibility_min);
        maximum = findViewById(R.id.disponibility_max);
        price = findViewById(R.id.animation_create_price);
        description = findViewById(R.id.description_creation);
        create = findViewById(R.id.create_creation);
        create.setOnClickListener(view -> create());
        cancel = findViewById(R.id.cancel_creation);
        cancel.setOnClickListener(view -> cancel());

    }
    private void create(){
        String name = animationName.getText().toString();
        String lieu = animationLieu.getText().toString();
        String date = animationDate.getText().toString();
        //String type = animationType.get
        int min = Integer.parseInt(minimum.getText().toString());
        int max = Integer.parseInt(maximum.getText().toString());
        String cost = price.getText().toString();
        String desc = description.getText().toString();


        View focusView = null;
        boolean cancel = false;

        if (TextUtils.isEmpty(name)) {
            animationName.setError("Nom manquant.");
            focusView = animationName;
            cancel = true;
        }

        if (TextUtils.isEmpty(lieu)) {
            animationLieu.setError("Lieu manquant.");
            focusView = animationLieu;
            cancel = true;
        }

        if (TextUtils.isEmpty(date)) {
            animationDate.setError("Sélectionner une date et une heure.");
            focusView = animationDate;
            cancel = true;
        }

        if (TextUtils.isEmpty(desc)) {
            description.setError("Lieu manquant");
            focusView = description;
            cancel = true;
        }

        if (TextUtils.isEmpty(lieu)) {
            animationLieu.setError("Lieu manquant");
            focusView = animationLieu;
            cancel = true;
        }

        if (cancel) {
            // There was an error don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            //code pour rentrer les données
            //if (suceed) {cancel();}
        }
    }
    private void cancel(){
        startActivity(new Intent(this, ReservationListActivity.class));
        finish();
    }




}
