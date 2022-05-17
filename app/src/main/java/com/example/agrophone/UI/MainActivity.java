package com.example.agrophone.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.Repository.ParticipantRepo;
import com.example.agrophone.R;

public class MainActivity extends AppCompatActivity {

    private EditText email_loginView;
    private EditText passwordView;
    private Button loginbtn;
    private Button registerbtn;

    private ParticipantRepo participantRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //values from view
        email_loginView = findViewById(R.id.email_login);
        passwordView = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(view -> attemptLogin());
        registerbtn = findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(view -> register());

        participantRepo = ((BaseAPP) getApplication()).getParticipantRepo();


    }

    private void attemptLogin() {
        email_loginView.setError(null);
        passwordView.setError(null);

        String email = email_loginView.getText().toString();
        String pwd = passwordView.getText().toString();

        View focusView = null;
        boolean cancel = false;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(pwd)) {
            passwordView.setError("Missing password");
            passwordView.setText("");
            focusView = passwordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            email_loginView.setError("Email empty");
            focusView = email_loginView;
            cancel = true;
        }
        if (cancel) {
            // There was an error don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            participantRepo.getParticipantByCreds(getApplication(), email, pwd).observe(MainActivity.this, participant -> {
                if(participant != null){
                    if(participant.getEmail().equals(email) && participant.getPassword().equals(pwd)){
                        Intent intent = new Intent(this, AnimationListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        }
    }
        public void register() {
            Intent intent = new Intent(this, AnimationListActivity.class);
            startActivity(intent);
            finish();
        }
}