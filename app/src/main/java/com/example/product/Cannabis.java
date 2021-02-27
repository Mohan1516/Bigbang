package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class Cannabis extends AppCompatActivity {

    GridView cannabisgridview;
    ImageView back;
    Context context;
    String[] ProductNames = {"Cannabis 1","Cannabis 2","Cannabis 3","Cannabis 4","Cannabis 5","Cannabis 6","Cannabis 7","Cannabis 8"};
    int[] ProductImages = {R.drawable.can1,R.drawable.can2,R.drawable.can3,R.drawable.can4,R.drawable.can5,R.drawable.can6,
            R.drawable.can7,R.drawable.can8};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannabis);

        context=this;
        cannabisgridview=(GridView)findViewById(R.id.cannabisgridview);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        CustomAdapter customAdapter= new CustomAdapter();
        cannabisgridview.setAdapter(customAdapter);

        cannabisgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context, ProductDetails.class);
                intent.putExtra("listname","cannabislist");
                intent.putExtra("position",position);
                intent.putExtra("name",ProductNames[position]);
                intent.putExtra("image",ProductImages[position]);
                startActivity(intent);
            }
        });
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
