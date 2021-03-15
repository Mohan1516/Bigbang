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

public class Password extends AppCompatActivity {

    EditText passwordtxt;
    Button submitButton;
    SharedPreferences sharedpreferences;
    SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_password);

        passwordtxt=findViewById(R.id.edittextpassword);
        submitButton=(Button)findViewById(R.id.submitButton);
        sharedPref=new SharedPref(Password.this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordtxt.getText().toString().equals("flowergirl")){

//                    sharedpreferences = getApplicationContext().getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
//                    if (sharedpreferences.contains(SharedPref.USERNAME)){
//                        startActivity(new Intent(Password.this,HomeActivity.class) );
//                        finish();
//                    }else {
//                    if (sharedPref.getLOGIN_STATUS()){
                        startActivity(new Intent(Password.this, Agree.class));
                        finish();
//                    }
//                    else {
//                        startActivity(new Intent(Password.this,Agree.class));
//                        finish();
//                    }
                }else {
                    Toast.makeText(Password.this, "Invalid password", Toast.LENGTH_SHORT).show();
                }
            }
        });

      
    }
}
