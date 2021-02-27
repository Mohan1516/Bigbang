package com.example.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class ProductDetails extends AppCompatActivity {
    ImageView remove;
    TextView textView;
    ImageView imageView,WhatsappButton;
    ImageView back;
    String getlistname;
    SharedPreferences sharedpreferences;
    SharedPref sharedPref;
    Context context;
    ViewPager viewFlipper;
    LinearLayout sliderDotspanel;
    private int dotscount;
    TextView geneticstext,conditionstext,symptomstext,potentialefectstext,flavourtext;
//    GridView productgridview;
    private ImageView[] dots;
    EditText edittextqty;
    String TAG=getClass().getName();
    Integer [] images;
    int newposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        context=this;
        remove=findViewById(R.id.logout);
//        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
//        imageView=findViewById(R.id.image);
        textView=findViewById(R.id.textnew);
        back=findViewById(R.id.back);
        sharedPref = new SharedPref(context);
        viewFlipper=findViewById(R.id.image);//viewpager for product
        edittextqty=(EditText)findViewById(R.id.edittextqty);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        geneticstext=(TextView)findViewById(R.id.geneticstext);
        conditionstext=(TextView)findViewById(R.id.conditionstext);
        symptomstext=(TextView)findViewById(R.id.symptomstext);
        potentialefectstext=(TextView)findViewById(R.id.potentialefectstext);
        flavourtext=(TextView)findViewById(R.id.flavourtext);
        WhatsappButton=(ImageView)findViewById(R.id.WhatsappButton);

        final Intent intent=getIntent();
        textView.setText(intent.getStringExtra("name"));
        Log.d(TAG,"Position ="+intent.getIntExtra("position",0));
        Log.d(TAG,"LIST NAME ="+intent.getStringExtra("listname"));
        newposition=intent.getIntExtra("position",0);
        getlistname=intent.getStringExtra("listname");
//        productgridview=(GridView)findViewById(R.id.image);
        if (getlistname.equals("productlist")) {
            if (newposition == 0) {
                images = new Integer[]{R.drawable.product1, R.drawable.product1_2};
            } else if (newposition == 1) {
                images = new Integer[]{R.drawable.product2, R.drawable.product2_2};
            } else if (newposition == 2) {
                images = new Integer[]{R.drawable.product3, R.drawable.product3_2};
            } else if (newposition == 3) {
                images = new Integer[]{R.drawable.product4};
            } else if (newposition == 4) {
                images = new Integer[]{R.drawable.product5, R.drawable.product5_2};
            } else if (newposition == 5) {
                images = new Integer[]{R.drawable.product6, R.drawable.product6_2};
            } else if (newposition == 6) {
                images = new Integer[]{R.drawable.product7, R.drawable.product7_2};
            } else if (newposition == 7) {
                images = new Integer[]{R.drawable.product8, R.drawable.product8_2};
            } else if (newposition == 8) {
                images = new Integer[]{R.drawable.product9};
            } else if (newposition == 9) {
                images = new Integer[]{R.drawable.product10};
            }
        }else {
            if (newposition == 0) {
                images = new Integer[]{R.drawable.can1, R.drawable.can1_1};
            } else if (newposition == 1) {
                images = new Integer[]{R.drawable.can2, R.drawable.can2_1};
            } else if (newposition == 2) {
                images = new Integer[]{R.drawable.can3, R.drawable.can3_1};
            } else if (newposition == 3) {
                images = new Integer[]{R.drawable.can4,R.drawable.can4_1};
            } else if (newposition == 4) {
                images = new Integer[]{R.drawable.can5, R.drawable.can5_1};
            } else if (newposition == 5) {
                images = new Integer[]{R.drawable.can6, R.drawable.can4};
            } else if (newposition == 6) {
                images = new Integer[]{R.drawable.can7, R.drawable.can7_1};
            } else if (newposition == 7) {
                images = new Integer[]{R.drawable.can8};
            }

        }

//        imageView.setImageResource(intent.getIntExtra("image",0));
        WhatsappButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "9600344951";
                if (!edittextqty.getText().toString().equals("")) {
                    boolean installed = appInstalledornot("com.whatsapp");
                    String text ="Username : "+sharedPref.getUSERNAME()+"\n"+"Product Name :"+ textView.getText().toString() + "\n" +"Quantity :"+ edittextqty.getText().toString();

                    if (installed) {

                        PackageManager pm = context.getPackageManager();
//                        try {
//                            Intent waIntent = new Intent(Intent.ACTION_SEND);
//                            waIntent.setType("text/plain");
//                            String text1 ="Username : "+sharedPref.getUSERNAME()+"\n"+"Product Name :"+ textView.getText().toString() + "\n" +"Quantity :"+ edittextqty.getText().toString();
//                            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
//                            waIntent.setPackage("com.whatsapp");
//                            waIntent.putExtra(Intent.EXTRA_TEXT, text1);
//                            waIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(phoneNumber) + "@s.whatsapp.net");//phone number without "+" prefix
//
//                            startActivity(Intent.createChooser(waIntent, "Share with"));
//                        } catch (PackageManager.NameNotFoundException e) {
//                            Toast.makeText(context, "WhatsApp not Installed", Toast.LENGTH_SHORT)
//                                    .show();
//                        }

                        //Sending Message to whatsapp Number 202102211227
                        Intent intent1=new Intent(Intent.ACTION_VIEW);
                        intent1.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+91"+phoneNumber+"&text="+text));
                        startActivity(intent1);
                        //

                    } else {
                        Toast.makeText(context, "Whatsapp not installed in you mobile", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(context, "Please enter quantity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
//        CustomAdapter customAdapter= new CustomAdapter();
//        productgridview.setAdapter(customAdapter);
//
//        productgridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(context, ProductDetails.class);
//                intent.putExtra("listname","productlist");
//                intent.putExtra("position",position);
//                intent.putExtra("name",ProductNames[position]);
//                intent.putExtra("image",ProductImages[position]);
//                startActivity(intent);
//                final Dialog dialog2=new Dialog(context);
//                dialog2.setContentView(R.layout.view_photo);
//                PhotoView imageView12=(PhotoView) dialog2.findViewById(R.id.viewImage);
//                ImageView frameLayout=(ImageView) dialog2.findViewById(R.id.closeImage);
//                frameLayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog2.dismiss();
//                    }
//                });
//
//                int size=images.length;
//                for (int j=0;j<size;j++) {
//                    imageView12.setImageResource(images[position]);
//                }
//
//                dialog2.show();
//                Window window=dialog2.getWindow();
//                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            }
//        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(context);

        viewFlipper.setAdapter(viewPagerAdapter);
//
//
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(context);
            dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));
        viewFlipper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        viewFlipper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog2=new Dialog(context);
//                dialog2.setContentView(R.layout.view_photo);
//                PhotoView imageView12=(PhotoView) dialog2.findViewById(R.id.viewImage);
//                ImageView frameLayout=(ImageView) dialog2.findViewById(R.id.closeImage);
//                frameLayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog2.dismiss();
//                    }
//                });
//
//                int size=images.length;
//                for (int j=0;j<size;j++) {
//                    imageView12.setImageResource(images[size]);
//                }
//
//                dialog2.show();
//                Window window=dialog2.getWindow();
//                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//            }
//        });
//
//        remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sharedpreferences =getSharedPreferences(SharedPref.MY_PREFERENCE,
//                        Context.MODE_PRIVATE);
//                sharedpreferences = getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.putString(SharedPref.USERNAME, "");
//                editor.putString(SharedPref.USERPHONE, "");
//                editor.commit();
//                sharedPref.setLOGIN_STATUS(false);
//                finish();
//                startActivity(new Intent(ProductDetails.this,Password.class));
//            }
//        });
    }
    public class ViewPagerAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater layoutInflater;

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.custom_layer, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
            imageView.setImageResource(images[position]);


            ViewPager vp = (ViewPager) container;
            vp.addView(view, 0);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            ViewPager vp = (ViewPager) container;
            View view = (View) object;
            vp.removeView(view);

        }
    }
    private boolean appInstalledornot(String url){
        PackageManager packageManager=getPackageManager();
        boolean app_installed;
        try {
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed=true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed=false;
        }
        return app_installed;
    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
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
            View view=getLayoutInflater().inflate(R.layout.product_griditem,null);

//            TextView textView=(TextView)view.findViewById(R.id.producttext);
            ImageView imageView=(ImageView)view.findViewById(R.id.productimage);

//            textView.setText(ProductNames[position]);
            imageView.setImageResource(images[position]);

            return  view;
        }
    }
}
