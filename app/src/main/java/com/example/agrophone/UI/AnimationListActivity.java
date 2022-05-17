package com.example.agrophone.UI;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AnimationListActivity extends AppCompatActivity {
    // animation_list (recycler), date_button (imageButton, calendrier), show_all(Button)
    // animation_date(date sélectionnées, texte)
    private RecyclerView recyclerView;
    private ImageButton dateButton;
    private Button showAll;
    private TextView animationDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_list);

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

                etDate.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(AnimationListActivity.this,setListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    private void show(){
        animationDate.setText("");
        //code juste pour recharger toute la recycler view
    }
}
