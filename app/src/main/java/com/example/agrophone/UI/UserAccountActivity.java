package com.example.agrophone.UI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.ArrayAdapter.AnimationAdapter;
import com.example.agrophone.ArrayAdapter.UserAnimationAdapter;
import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Entity.AnimationByParticipant;
import com.example.agrophone.Database.Repository.AnimationByParticipantRepo;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.Database.Repository.ParticipantRepo;
import com.example.agrophone.R;

import java.util.ArrayList;
import java.util.List;

public class UserAccountActivity extends AppCompatActivity {
    private TextView userName;
    private TextView userForname;
    private TextView userAddress;
    private TextView userNpa;
    private TextView userTel;
    private TextView userEmail;
    private String userId;

    private ParticipantRepo participantRepo;

    private AnimationRepo animationRepo;
    private AnimationByParticipantRepo animationByParticipantRepo;

    public static List<Animation> allAnimations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_account);

        SharedPreferences preferences = getSharedPreferences(MainActivity.PREF_ANIMATION,0);
        userId = preferences.getString(MainActivity.PREF_ANIMATION, "");

        userName = findViewById(R.id.account_name);
        userForname = findViewById(R.id.account_forname);
        userAddress = findViewById(R.id.account_address);
        userNpa = findViewById(R.id.account_npa);
        userTel = findViewById(R.id.account_tel);
        userEmail = findViewById(R.id.account_email);

        animationRepo = ((BaseAPP) getApplication()).getanimationRepo();
        participantRepo = ((BaseAPP) getApplication()).getParticipantRepo();

        animationByParticipantRepo = ((BaseAPP) getApplication()).getAnimationByParticipantRepo();

        animationByParticipantRepo.getAnimationByParticipant(getApplication(), 1).observe(this, animations -> {

            for (AnimationByParticipant anim : animations){
                animationRepo.getAllByIdAnimation(getApplication(), anim.getIdAnimation()).observe(this, animation -> {
                    allAnimations.add(animation);
                });
            }

            UserAnimationAdapter animationAdapter = new UserAnimationAdapter(allAnimations);
            RecyclerView recyclerView = findViewById(R.id.user_animation_list);
            recyclerView.setAdapter(animationAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });



        //juste à attribuer les infos au TextView
    }


}
