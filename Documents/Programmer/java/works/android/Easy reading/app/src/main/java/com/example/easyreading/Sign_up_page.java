package com.example.easyreading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up_page extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail, signupPass;
    private Button signupBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        auth = FirebaseAuth.getInstance();
        signupEmail = findViewById(R.id.signup_mail);
        signupPass = findViewById(R.id.signup_pass);
        signupBut = findViewById(R.id.signup_button);

        signupBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupEmail.getText().toString();
                String pass = signupPass.getText().toString().trim();
                if (user.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                }
                if (pass.isEmpty()){
                    signupEmail.setError("Password cannot be empty");
                } else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Sign_up_page.this, "SignUp successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_up_page.this, Login_page.class));
                            } else {
                                Toast.makeText(Sign_up_page.this, "Signup failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


    }
}