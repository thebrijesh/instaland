package com.example.instaland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class Login_Form extends AppCompatActivity {

    private TextView Signup;
    private Button login;
    private FirebaseAuth mAuth;
    private TextInputEditText email, password;
    FirebaseUser currentuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Signup = findViewById(R.id.signup);
        login = findViewById(R.id.loginbtn);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);


        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    Intent intent = new Intent(Login_Form.this,MainActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(Login_Form.this, "Error", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });



        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Form.this,signup.class);
                startActivity(intent);
            }
        });



    }

    void user(){
        if(currentuser!=null){
            startActivity(new Intent(Login_Form.this,MainActivity.class));

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        currentuser = mAuth.getCurrentUser();
        user();
    }
}