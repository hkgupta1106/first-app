package com.example.himanshu.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import model.User;


public class sign_up extends AppCompatActivity {

    String gender, firstName, lastName, email, password, confirmPassword, mobileNo, checkBox;
    boolean emailValidation;
    int selectId;
    CheckBox cb_Check_Box_Id;
    EditText et_First_Name_Id, et_Last_Name_Id, et_Email_Id, et_Password_Id, et_Confirm_Password_Id, et_Mobile_No_Id;
    RadioGroup rg_Gender_Id;
    User user_object;
    ArrayList<User> userArrayList=new ArrayList<User>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signup_Button = (Button) findViewById(R.id.btn_Sign_Up_Id);
        signup_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                et_First_Name_Id = (EditText) findViewById(R.id.et_First_Name_Id);
                et_Last_Name_Id = (EditText) findViewById(R.id.et_Last_Name_Id);
                et_Email_Id = (EditText) findViewById(R.id.et_Email_Id);
                et_Password_Id = (EditText) findViewById(R.id.et_Password_ID);
                et_Confirm_Password_Id = (EditText) findViewById(R.id.et_Confirm_Password_Id);
                et_Mobile_No_Id = (EditText) findViewById(R.id.et_Mobile_No_Id);
                cb_Check_Box_Id = (CheckBox) findViewById(R.id.cb_Check_Box_Id);
                rg_Gender_Id = (RadioGroup) findViewById(R.id.rg_Gender_Id);
                firstName = et_First_Name_Id.getText().toString();
                lastName = et_Last_Name_Id.getText().toString();
                email = et_Email_Id.getText().toString();
                password = et_Password_Id.getText().toString();
                confirmPassword = et_Confirm_Password_Id.getText().toString();
                mobileNo = et_Mobile_No_Id.getText().toString();
                checkBox = cb_Check_Box_Id.getText().toString();
                selectId = rg_Gender_Id.getCheckedRadioButtonId();
                emailValidation = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();


                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || mobileNo.isEmpty() || selectId == -1) {
                    Toast.makeText(getApplicationContext(), "all fields are mandatory", Toast.LENGTH_SHORT).show();
                } else if (firstName.matches("[0-9]*") || lastName.matches("[0-9]*")) {
                    Toast.makeText(getApplicationContext(), "Name should not be numeric", Toast.LENGTH_SHORT).show();
                } else if (!emailValidation) {
                    Toast.makeText(getApplicationContext(), "Invalid email format", Toast.LENGTH_SHORT).show();
                } else if (!(password.equals(confirmPassword))) {
                    Toast.makeText(getApplicationContext(), "password does'nt match", Toast.LENGTH_SHORT).show();
                } else if (mobileNo.length() < 10) {
                    Toast.makeText(getApplicationContext(), "mobile number should not be less then 10", Toast.LENGTH_SHORT).show();
                } else if (!cb_Check_Box_Id.isChecked()) {
                    Toast.makeText(getApplicationContext(), "please check TOS and Privacy", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = (RadioButton) findViewById(selectId);
                    gender = radioButton.getText().toString();

                    user_object = new User(firstName, lastName, email, password, mobileNo, gender);
                    userArrayList.add(user_object);
                    Intent intent = new Intent(sign_up.this, display.class);
                    intent.putParcelableArrayListExtra("info", userArrayList);
                    startActivity(intent);
                }
            }
        });
    }

}