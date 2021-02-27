package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button submitbtn;
    EditText nametxt,phonetxt;
    SharedPref sharedPref;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        sharedPref=new SharedPref(Register.this);
        submitbtn=(Button)findViewById(R.id.submitButton);
        nametxt=(EditText)findViewById(R.id.edittextname);
        phonetxt=(EditText)findViewById(R.id.edittextphone);

     String userName=nametxt.getText().toString();
       String userphone=phonetxt.getText().toString();

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedpreferences =getSharedPreferences(SharedPref.MY_PREFERENCE,
                        Context.MODE_PRIVATE);
                sharedpreferences = getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putString(SharedPref.USERNAME, userName);
//                editor.putString(SharedPref.USERPHONE, userphone);
                editor.commit();

                if (nametxt.getText().toString().equals("")){
                    Toast.makeText(Register.this, "Enter name", Toast.LENGTH_SHORT).show();
                }else if (phonetxt.getText().toString().equals("")){
                    Toast.makeText(Register.this, "Enter phone number", Toast.LENGTH_SHORT).show();
                }else {
                    sharedPref.setUSERNAME(nametxt.getText().toString());
                    sharedPref.setUSERPHONE(phonetxt.getText().toString());
                    sharedPref.setLOGIN_STATUS(true);

                    startActivity(new Intent(Register.this,NewDescriptionScreen.class));
                    finish();
                }

            }
        });
    }
}
