package com.example.agrophone.UI;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agrophone.R;

public class CompanyInfoActivity extends AppCompatActivity {

    private TextView AnimationTitle;
    private TextView CompanyNumber;
    private TextView CompanySite;
    private RecyclerView otherActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_infos);
        AnimationTitle = findViewById(R.id.animation_title);
        CompanyNumber = findViewById(R.id.company_number);
        CompanySite = findViewById(R.id.company_site);
        otherActivity = findViewById(R.id.animation_company_list);

        //remplir les champs
    }
}
