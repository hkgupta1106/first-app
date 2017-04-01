package com.example.himanshu.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.himanshu.firstapp.R;

import java.util.ArrayList;

import Display_Adapter.Display_Adapter;
import model.User;


public class display extends AppCompatActivity {

    private TextView tvFirstName,tvLastName, tvEmailValue,tvPassword, tvMobile,tvGenderValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
       ArrayList<User> userArrayList=getIntent().getParcelableArrayListExtra("info");

        ListView listView=(ListView)findViewById(R.id.lv_Id);
        Display_Adapter display_adapter=new Display_Adapter(this,userArrayList);

        listView.setAdapter(display_adapter);

    }
}