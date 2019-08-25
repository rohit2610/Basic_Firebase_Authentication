package com.example.depressionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        password = findViewById(R.id.passwordEditText);
        username = findViewById(R.id.usernameEditText);

        mAuth = FirebaseAuth.getInstance();
        //mAuth.signOut();


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }


    public void updateUI(FirebaseUser user) {
        if (user != null) {

        } else {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        }
    }


    public void onClick(View view){
        int i = view.getId();

        if(i == R.id.signUpButton){

        }
    }



}

