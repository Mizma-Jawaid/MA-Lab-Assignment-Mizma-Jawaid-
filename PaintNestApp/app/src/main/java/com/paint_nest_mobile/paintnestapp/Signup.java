package com.paint_nest_mobile.paintnestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    TextInputLayout username_var,password_var,email_var,contact_var;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username_var = findViewById(R.id.username_text_field_design);
        password_var = findViewById(R.id.password_input_field);
        email_var = findViewById(R.id.email_input_field);
        contact_var = findViewById(R.id.phone_number_field);

    }

    public void login_button_click(View view) {
        Intent intent = new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
        finish();
    }

    public void register_button_click(View view) {

        String username_ =  username_var.getEditText().getText().toString();
        String password_ =  password_var.getEditText().getText().toString();
        String email_ =  email_var.getEditText().getText().toString();
        String contact_ = contact_var.getEditText().getText().toString();

        if (!username_.isEmpty()){
            username_var.setError(null);
            username_var.setErrorEnabled(false);

            if (!password_.isEmpty()){
                password_var.setError(null);
                password_var.setErrorEnabled(false);

                if (!email_.isEmpty()){
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);

                    if (!contact_.isEmpty()){
                        contact_var.setError(null);
                        contact_var.setErrorEnabled(false);

                        if (email_.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")){
                            email_var.setError(null);
                            email_var.setErrorEnabled(false);

                            firebaseDatabase = FirebaseDatabase.getInstance();
                            reference = firebaseDatabase.getReference("datauser");

                            String username_s =  username_var.getEditText().getText().toString();
                            String password_s=  password_var.getEditText().getText().toString();
                            String email_s =  email_var.getEditText().getText().toString();
                            String contact_s = contact_var.getEditText().getText().toString();

                            Storingdata storingdatass = new Storingdata(username_s,password_s,email_s,contact_s);

                            reference.child(username_s).setValue(storingdatass);

                            Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                            startActivity(intent);
                            finish();



                        }else{
                            email_var.setError("Invalid Email!");
                        }
                }else{
                        contact_var.setError("Please enter the contact no");
                    }

                }else{
                    email_var.setError("Please enter the email");
                }

            }else{
                password_var.setError("Please enter the password");
            }
        }else{
            username_var.setError("Please enter the username");
        }

    }
}