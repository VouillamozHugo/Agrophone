package com.example.agrophone.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;

import com.example.agrophone.ArrayAdapter.AnimationAdapter;
import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Entity.Animation;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AnimationListActivity extends AppCompatActivity {
    // animation_list (recycler), date_button (imageButton, calendrier), show_all(Button)
    // animation_date(date sélectionnées, texte)
    private RecyclerView recyclerView;
    private ImageButton dateButton;
    private Button showAll;
    private TextView animationDate;
    public Button infoUser;
    private String date;

    private AnimationRepo animationRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_list);

        animationRepo = ((BaseAPP) getApplication()).getanimationRepo();
        infoUser = findViewById(R.id.showUserInfo);
        animationDate = findViewById(R.id.animations_date);
        recyclerView = findViewById(R.id.animation_list);
        //dateButton va permettre de choisir une date et afficher les anim pour la date x
        dateButton = findViewById(R.id.date_button);
        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                chooseDateTimeDialog(animationDate);
            }
        });
        //va tout remettre dans le recycler view
        showAll = findViewById(R.id.show_all);
        showAll.setOnClickListener(view -> show());
        //afficher si une date x a été choisie

        infoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateInfoUser();
            }
        });
        animationRepo.getAllAnimations(getApplication()).observe(this, animations ->{
            AnimationAdapter animationAdapter = new AnimationAdapter(animations);
            animationAdapter.setPage(this);
            RecyclerView recyclerView = findViewById(R.id.animation_list);
            recyclerView.setAdapter(animationAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });

    }
    private void chooseDateTimeDialog(TextView etDate) {
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener setListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd.MM.yyyy");
                date = simpleDateFormat.format(calendar.getTime());
                etDate.setText(date);
                showByDate(date);

            }
        };
        new DatePickerDialog(AnimationListActivity.this,setListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void show(){
        animationDate.setText("");
        //code juste pour recharger toute la recycler view
        animationRepo.getAllAnimations(getApplication()).observe(this, animations ->{
            AnimationAdapter animationAdapter = new AnimationAdapter(animations);
            animationAdapter.setPage(this);
            RecyclerView recyclerView = findViewById(R.id.animation_list);
            recyclerView.setAdapter(animationAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    }

    private void generateInfoUser(){
        Intent intent = new Intent(this, UserAccountActivity.class);
        startActivity(intent);

    }

    public void generateAnimationDetail(String idAnimation){
        SharedPreferences.Editor editor = getSharedPreferences(MainActivity.PREF_ANIMATION,0).edit();

        editor.putString(MainActivity.PREF_ANIMATION,idAnimation);
        editor.apply();
        Intent intent = new Intent(this, AnimationDescriptionActivity.class);
        startActivity(intent);
    }

    private void showByDate(String date){
        animationRepo.getAllAnimations(getApplication()).observe(this, animations ->{
            List<Animation> animationByDate = new ArrayList<Animation>();
            for (Animation a : animations){
                if (a.getDate().equals(date)){
                    animationByDate.add(a);
                }
            }
            AnimationAdapter animationAdapter = new AnimationAdapter(animationByDate);
            animationAdapter.setPage(this);
            RecyclerView recyclerView = findViewById(R.id.animation_list);
            recyclerView.setAdapter(animationAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });
    }
}
