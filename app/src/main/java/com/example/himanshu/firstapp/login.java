package com.example.himanshu.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login_Button = (Button) findViewById(R.id.loginid);
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailid = (EditText) findViewById(R.id.emailid);
                String email = emailid.getText().toString();
                EditText passwordid = (EditText) findViewById(R.id.passwordid);
                String password = passwordid.getText().toString();
                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(getApplicationContext(), "all fields are mandatory", Toast.LENGTH_SHORT).show();
            }
        });

        Button signup_Button = (Button) findViewById(R.id.signupid);
        signup_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupintent();
            }
        });
    }

    public void signupintent() {
        Intent clickedDay = new Intent(this, sign_up.class);
        startActivity(clickedDay);
    }
}
