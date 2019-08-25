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

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        password = findViewById(R.id.passwordEditText);
        username = findViewById(R.id.usernameEditText);

        mAuth = FirebaseAuth.getInstance();
        //mAuth.signOut();

        //signUp();




    }

    public void onClickButton(View view){

        int i = view.getId();

        if(i == R.id.signupButton){
            signUp();
        }

        else if(i == R.id.logButton){
            login();
        }

    }

    private void login(){
        Intent intent = new Intent(SignUp.this,LogIn.class);
        startActivity(intent);
    }



    public void signUp() {

        String user =  username.getText().toString();
        String pass = password.getText().toString();

        if (username.getText().toString() == null && password.getText().toString() == null) {

        } else {
            mAuth.createUserWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Login Successfull", Toast.LENGTH_SHORT).show();

                            }
                            else
                            {
                                System.out.println(task.getException().toString());
                                Log.i("LOgin","unsee");
                                Log.i("Reason",task.getException().toString());
                            }



                        }
                    });


        }
    }
}
