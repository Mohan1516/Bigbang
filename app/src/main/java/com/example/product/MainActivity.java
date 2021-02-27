package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView1,textView2,textView3,textView4,textView5,textView6;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        TypeWriter writer = new TypeWriter(this);
//        setContentView(writer);
        //Add a character every 150ms
//        writer.setCharacterDelay(150);
//        writer.animateText("Bigbang");
        textView=findViewById(R.id.textsplash);
        textView1=findViewById(R.id.textsplash2);
        textView2=findViewById(R.id.textsplash3);
        textView3=findViewById(R.id.textsplash4);
        textView4=findViewById(R.id.textsplash5);
        textView5=findViewById(R.id.textsplash6);
        textView6=findViewById(R.id.textsplash7);
        firstletter();

    }
    private void firstletter() {
        textView.setText("B");
        textView.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(900)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash));
        secondletter();

    }
    private void secondletter() {
        textView1.setText("i");
        textView1.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1000)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash2));
        thirdletter();

    }

    private void thirdletter() {
        textView2.setText("g");
        textView2.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1100)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash3));

        fourletter();
    }

    private void fourletter() {
        textView3.setText("B");
        textView3.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1200)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash4));
        fiveletter();
    }

    private void fiveletter() {
        textView4.setText("a");
        textView4.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1300)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash5));
        sixletter();

    }

    private void sixletter() {
        textView5.setText("n");
        textView5.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1400)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash6));
        sevenletter();
    }

    private void sevenletter() {
        textView6.setText("g");
        textView6.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.SlideInRight)
                .duration(1500)
                .repeat(1)
                .playOn(findViewById(R.id.textsplash7));
        initlayout();
    }

    private void initlayout() {
        new Thread() {
            public void run() {

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                startActivity(new Intent(MainActivity.this,Password.class) );
                finish();

            }
        }.start();
    }

}