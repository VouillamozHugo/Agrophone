package com.example.agrophone.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.ArrayAdapter.AnimationAdapter;
import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.Database.Repository.EntrepriseRepo;
import com.example.agrophone.R;

import java.util.ArrayList;
import java.util.List;

public class CompanyInfoActivity extends AppCompatActivity {

    private TextView companyName;
    private TextView CompanyNumber;
    private TextView CompanySite;

    private String entrepriseID;
    private EntrepriseRepo entrepriseRepo;
    private AnimationRepo animationRepo;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_infos);

        entrepriseRepo = ((BaseAPP) getApplication()).getEntrepriseRepo();
        animationRepo = ((BaseAPP) getApplication()).getanimationRepo() ;

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_ENTREPRISE,0);
        entrepriseID = preferences.getString(MainActivity.PREF_ANIMATION, "");


        companyName = findViewById(R.id.info_company_name);
        CompanyNumber = findViewById(R.id.company_number);
        CompanySite = findViewById(R.id.company_site);
        recyclerView = findViewById(R.id.animation_company_list);

        entrepriseRepo.getEntrepriseByID(getApplication(), Integer.valueOf(entrepriseID)).observe(this, entreprise -> {
            CompanyNumber.setText("Téléphone : " + entreprise.getTel());
            CompanySite.setText("Site Web : " + entreprise.getUrl());
            companyName.setText(entreprise.getNomEntreprise());
        });

        animationRepo.getAllAnimations(getApplication()).observe(this, animations -> {
            List<Animation> animationByCompany = new ArrayList<>();
            for (Animation a : animations){
                if(a.getIDEntreprise() == Integer.valueOf(entrepriseID)){
                    animationByCompany.add(a);
                }
            }
            AnimationAdapter animationAdapter = new AnimationAdapter(animations);
            animationAdapter.setpage2(this);
            recyclerView.setAdapter(animationAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });


        //remplir les champs
    }

    public void generateAnimationDetail(String idAnimation){
        SharedPreferences.Editor editor = getSharedPreferences(MainActivity.PREF_ANIMATION,0).edit();

        editor.putString(MainActivity.PREF_ANIMATION,idAnimation);
        editor.apply();
        Intent intent = new Intent(this, AnimationDescriptionActivity.class);
        startActivity(intent);
    }
}
