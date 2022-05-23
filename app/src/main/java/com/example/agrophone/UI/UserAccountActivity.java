package com.example.agrophone.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agrophone.R;

public class UserAccountActivity extends AppCompatActivity {
    private TextView userName;
    private TextView userForname;
    private TextView userAddress;
    private TextView userNpa;
    private TextView userTel;
    private TextView userEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_list);

        userName = findViewById(R.id.account_name);
        userForname = findViewById(R.id.account_forname);
        userAddress = findViewById(R.id.account_address);
        userNpa = findViewById(R.id.account_npa);
        userTel = findViewById(R.id.account_tel);
        userEmail = findViewById(R.id.account_email);

        //juste à attribuer les infos au TextView
    }


}
