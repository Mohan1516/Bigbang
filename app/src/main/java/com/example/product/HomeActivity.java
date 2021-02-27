package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {

    ImageView remove;
    ViewFlipper viewFlipper;
    Context context;
    SharedPreferences sharedpreferences;
    SharedPref sharedPref;

    GridView gridView;
    String[] ProductNames = {"Laptop","Hard Disk","Iphone 5S","Bose","smart Watch","Web Cam","PSP","Speaker"};
    int[] ProductImages = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,
                            R.drawable.image7,R.drawable.image8};

    int images[]={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context=this;
        remove=findViewById(R.id.logout);
        viewFlipper=(ViewFlipper)findViewById(R.id.viewflipper);
        gridView=(GridView)findViewById(R.id.productgridview);

        CustomAdapter customAdapter= new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),ProductDetails.class);
                intent.putExtra("name",ProductNames[position]);
                intent.putExtra("image",ProductImages[position]);
                startActivity(intent);
            }
        });

        sharedPref = new SharedPref(context);

        viewFlipper.setPadding(10,10,10,10);

        for (int img1:images){
            FillerViewImage(img1);
        }

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences =getSharedPreferences(SharedPref.MY_PREFERENCE,
                        Context.MODE_PRIVATE);
                sharedpreferences = getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(SharedPref.USERNAME, "");
                editor.putString(SharedPref.USERPHONE, "");
                editor.commit();
                sharedPref.setLOGIN_STATUS(false);
                startActivity(new Intent(HomeActivity.this,Password.class));
            }
        });
    }

    public void FillerViewImage(int images){

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);//3 sec
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this,android.R.anim.slide_out_right);


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return ProductImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(R.layout.gridview_items,null);

            TextView textView=(TextView)view.findViewById(R.id.producttext);
            ImageView imageView=(ImageView)view.findViewById(R.id.productimage);

            textView.setText(ProductNames[position]);
            imageView.setImageResource(ProductImages[position]);

            return  view;
        }
    }
}
