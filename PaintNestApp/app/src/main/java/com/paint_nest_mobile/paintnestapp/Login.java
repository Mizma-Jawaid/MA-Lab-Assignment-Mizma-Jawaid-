package com.paint_nest_mobile.paintnestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button signupbutton,loginbutton;
    TextInputLayout username_var, password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        signupbutton = findViewById(R.id.signup_btn);
        loginbutton = findViewById(R.id. login_btn);

        username_var = findViewById(R.id.username_text_field_design);
        password_var = findViewById(R.id.password_input_field);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username_ = username_var.getEditText().getText().toString();
                String password_ = password_var.getEditText().getText().toString();

                if (!username_.isEmpty()){
                    username_var.setError(null);
                    username_var.setErrorEnabled(false);

                    if (!password_.isEmpty()){
                        password_var.setError(null);
                        password_var.setErrorEnabled(false);

                        final String username_data = username_var.getEditText().getText().toString();
                        final String password_data = username_var.getEditText().getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("datauser");

                        Query check_username = databaseReference.orderByChild("username").equalTo(username_data);

                        check_username.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                                if (snapshot.exists()){
                                    username_var.setError(null);
                                    username_var.setErrorEnabled(false);
                                    String passwordcheck = snapshot.child(username_data).child("password").getValue(String.class);
                                    if (passwordcheck.equals(password_data)){

                                    }else{
                                        password_var.setError("Wrong Password");
                                        password_var.setError(null);
                                        password_var.setErrorEnabled(false);

                                        Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                }else{
                                    username_var.setError("User doesn't exists");
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {


                            }
                        });

                    }else{
                        password_var.setError("Please enter the password");
                    }
                }else{
                    username_var.setError("Please enter the username");
                }

            }
        });
                signupbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Signup.class);
                        startActivity(intent);

                    }
                });

    }
}
