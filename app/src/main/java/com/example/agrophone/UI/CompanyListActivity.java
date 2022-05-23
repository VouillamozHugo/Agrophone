package com.example.agrophone.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.R;

public class CompanyListActivity extends AppCompatActivity {

    private TextView AnimationTitle;
    private TextView CompanyNumber;
    private TextView CompanySite;
    private RecyclerView otherActivity;
    private Button addAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_infos_admin);
        AnimationTitle = findViewById(R.id.company_name_admin);
        CompanyNumber = findViewById(R.id.company_number_admin);
        CompanySite = findViewById(R.id.company_site_admin);
        otherActivity = findViewById(R.id.animation_list_admin);
        addAnimation = findViewById(R.id.create_animation);
        addAnimation.setOnClickListener(view -> add());

        //remplir les champs
    }

    private void add(){
        startActivity(new Intent(this, CreateAnimationActivity.class));
        finish();
    }
}
