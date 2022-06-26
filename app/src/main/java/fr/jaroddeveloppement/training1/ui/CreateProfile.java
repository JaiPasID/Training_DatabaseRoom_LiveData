package fr.jaroddeveloppement.training1.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import java.util.List;

import fr.jaroddeveloppement.training1.R;
import fr.jaroddeveloppement.training1.model.UserEntity;
import fr.jaroddeveloppement.training1.viewmodel.ViewModelFactory;
import fr.jaroddeveloppement.training1.viewmodel.ViewModelUser;

public class CreateProfile extends AppCompatActivity {

    @Nullable
    private EditText dialogEditText = null;


    private List<UserEntity> mUserEntities;
    private ViewModelUser mViewModelUser;

    private final ArrayList<UserEntity> mUserEntityArrayList =new ArrayList<>();

    EditText name, firstName, age, adress, zipCode, country;
    Button save;

    @NonNull
    private final ArrayList<UserEntity> tasks =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        name = findViewById(R.id.name);
        firstName = findViewById(R.id.firstName);
        age = findViewById(R.id.age);
        adress = findViewById(R.id.adress);
        zipCode = findViewById(R.id.zipCode);
        country = findViewById(R.id.country);
        save = findViewById(R.id.saveInformation);

        mViewModelUser =new ViewModelProvider(this, ViewModelFactory.getInstance(this)).get(ViewModelUser.class);
        mViewModelUser.getListLiveData().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> pUserEntities) {
                mUserEntities =pUserEntities;
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                onPositiveButtonClick();
                Intent lvIntent = new Intent(CreateProfile.this, MainActivity.class);
                startActivity(lvIntent);

            }
        });
    }


    private void addTask(UserEntity task){
        mViewModelUser.insertUser(task);
    }


    private void onPositiveButtonClick() {
        if (name != null && firstName != null && age != null && adress != null && zipCode != null && country != null) {
            String userName = name.getText().toString();
            String userFirstName = firstName.getText().toString();
            String userAge = age.getText().toString();
            String userAdress = adress.getText().toString();
            String userZipCode = zipCode.getText().toString();
            String userCountry = country.getText().toString();

            if (userName.trim().isEmpty() || userFirstName.trim().isEmpty() || userAge.trim().isEmpty() || userAdress.trim().isEmpty() || userZipCode.trim().isEmpty() || userCountry.trim().isEmpty()) {
                dialogEditText.setError(getString(R.string.empty_task_name));
            } else {
                UserEntity newUser = new UserEntity(
                        userName,
                        userFirstName,
                        userAge,
                        userAdress,
                        userZipCode,
                        userCountry);
                addTask(newUser);

            }

        }
    }


}