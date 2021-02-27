package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Agree extends AppCompatActivity {

    CheckBox checkbox;
    TextView nextbtn,textsetchecked;
    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_agree);
        sharedPref=new SharedPref(Agree.this);


        nextbtn=findViewById(R.id.nextbtn);
        checkbox=findViewById(R.id.checkbox);
        textsetchecked=findViewById(R.id.textsetchecked);

        textsetchecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkbox.setChecked(true);
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                if (checkbox.isChecked()) {
                    if (sharedPref.getLOGIN_STATUS()){
                        startActivity(new Intent(Agree.this, NewDescriptionScreen.class));
                        finish();
                    }else {
                        startActivity(new Intent(Agree.this, Register.class));
                        finish();
                    }
                }else {
                    Toast.makeText(Agree.this, "Please click the accept checkbox", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
