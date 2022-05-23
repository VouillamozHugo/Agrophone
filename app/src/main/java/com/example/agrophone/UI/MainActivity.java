package com.example.agrophone.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.agrophone.BaseAPP;
import com.example.agrophone.Database.DatabaseInitializer;
import com.example.agrophone.Database.Repository.AnimationRepo;
import com.example.agrophone.Database.Repository.ParticipantRepo;
import com.example.agrophone.R;

public class MainActivity extends AppCompatActivity {

    public static final String PREF_NAME = "SharedPrefs";
    public static final String PREF_ANIMATION = "Animation";
    public static final String PREF_ENTREPRISE = "Entreprise";
    public static final String PREF_USER = "User";

    private EditText email_loginView;
    private EditText passwordView;
    private Button loginbtn;
    private Button registerbtn;

    private ParticipantRepo participantRepo;
    private AnimationRepo animationRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        participantRepo = ((BaseAPP) getApplication()).getParticipantRepo();
        animationRepo = ((BaseAPP) getApplication()).getanimationRepo();

        animationRepo.getAllAnimations(getApplication()).observe(this, animations -> {
            if(animations.isEmpty()){
                DatabaseInitializer.populateDatabase(((BaseAPP) getApplicationContext()).getDatabase());
            }else{
                return;
            }
        });


        //values from view
        email_loginView = findViewById(R.id.email_login);
        passwordView = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(view -> attemptLogin());
        registerbtn = findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(view -> register());




    }

    private void attemptLogin() {
        participantRepo = ((BaseAPP) getApplication()).getParticipantRepo();
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
                        SharedPreferences.Editor editor = getSharedPreferences(MainActivity.PREF_USER,0).edit();

                        editor.putString(MainActivity.PREF_ANIMATION,String.valueOf(participant.getIdParticipant()));
                        editor.apply();
                        Intent intent = new Intent(this, AnimationListActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        }
    }
        public void register() {
            Intent intent = new Intent(this, AnimationDescriptionActivity.class);
            startActivity(intent);
            finish();
        }
}