package com.example.depressionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    FirebaseAuth mAuth ;
    private EditText user;
    private EditText pass ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mAuth = FirebaseAuth.getInstance();

        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);



    }

    public void login(View view){
        mAuth.signInWithEmailAndPassword(user.getText().toString(),pass.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Logging in ",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LogIn.this,MessageScreen.class);
                            startActivity(intent);
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(),task.getException().toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
