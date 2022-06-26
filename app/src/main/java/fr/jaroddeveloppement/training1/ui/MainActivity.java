package fr.jaroddeveloppement.training1.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

import fr.jaroddeveloppement.training1.R;


public class MainActivity extends AppCompatActivity {

Button createProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    createProfile = findViewById(R.id.createProfile);


    createProfile.setOnClickListener(pView -> {
        Intent lvIntent = new Intent(this, CreateProfile.class);
        startActivity(lvIntent);
    });

    }
}