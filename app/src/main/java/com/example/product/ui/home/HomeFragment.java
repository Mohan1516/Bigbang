package com.example.product.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.example.product.Password;
import com.example.product.ProductDetails;
import com.example.product.R;
import com.example.product.SharedPref;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView remove;
    ViewFlipper viewFlipper;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    Context context;
    SharedPreferences sharedpreferences;
    SharedPref sharedPref;

    GridView gridView;
    String[] ProductNames = {"Product 1","Product 2","Product 3","Product 4","Product 5","Product 6","Product 7","Product 8","Product 9","Product 10"};
    int[] ProductImages = {R.drawable.new_product11,R.drawable.new_product12,
            R.drawable.new_product13,R.drawable.new_product14,R.drawable.new_product15,R.drawable.new_product16,R.drawable.new_product17,
            R.drawable.new_product18,R.drawable.new_product19,R.drawable.new_product20,R.drawable.product1,R.drawable.product2,R.drawable.product3,R.drawable.product4,R.drawable.product5,R.drawable.product6,
            R.drawable.product7,R.drawable.product8,R.drawable.product9,R.drawable.product10};
    Integer [] images = {R.drawable.slider1,R.drawable.slider2,R.drawable.slider3,R.drawable.slider4,R.drawable.slider5,R.drawable.slider6,
            R.drawable.slider7,R.drawable.slider8,R.drawable.slider9,R.drawable.slider10,R.drawable.slider11,R.drawable.slider12,R.drawable.slider13,
            R.drawable.slider14,R.drawable.slider15,R.drawable.slider16,R.drawable.slider17,R.drawable.slider18,R.drawable.slider19,R.drawable.slider20,
             R.drawable.slider21, R.drawable.slider22,R.drawable.slider23,R.drawable.slider24,R.drawable.slider25,R.drawable.slider26,R.drawable.slider27,
             R.drawable.slider28_,R.drawable.slider29,R.drawable.slider30,R.drawable.slider31,R.drawable.slider32,R.drawable.slider33,R.drawable.slider34,
    R.drawable.slider35,R.drawable.slider36,R.drawable.slider37,R.drawable.slider38,R.drawable.slider39,R.drawable.slider40,R.drawable.slider41,
            R.drawable.slider42,R.drawable.slider43,R.drawable.slider44,R.drawable.slider45,R.drawable.slider46,R.drawable.slider47_new,R.drawable.slider48,
    R.drawable.slider49,R.drawable.slider50,R.drawable.slider51,R.drawable.slider52,R.drawable.slider53,R.drawable.slider54,R.drawable.slider55_new,
            R.drawable.slide56,R.drawable.slide57,R.drawable.slide58,R.drawable.slide59,R.drawable.slide60,R.drawable.slide61,R.drawable.slide62,
            R.drawable.slide63,R.drawable.slide64,R.drawable.slide65,R.drawable.slide66,R.drawable.slide67,R.drawable.slide68,R.drawable.slide69,
            R.drawable.slide70,R.drawable.slide71,R.drawable.slide72,R.drawable.slide73,R.drawable.slide74,R.drawable.slide75,R.drawable.slide76,
            R.drawable.slide77,R.drawable.slide78};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        context=getActivity().getApplicationContext();
        remove=root.findViewById(R.id.logout);
        viewFlipper=(ViewFlipper) root.findViewById(R.id.viewflipper);
        gridView=(GridView)root.findViewById(R.id.productgridview);
        sliderDotspanel = (LinearLayout) root.findViewById(R.id.SliderDots);

        CustomAdapter customAdapter= new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(context, ProductDetails.class);
//                intent.putExtra("listname","productlist");
//                intent.putExtra("position",position);
//                intent.putExtra("name",ProductNames[position]);
//                intent.putExtra("image",ProductImages[position]);
//                startActivity(intent);
            }
        });

        sharedPref = new SharedPref(context);

//        viewFlipper.setPadding(10,10,10,10);

        for (int img1:images){
            FillerViewImage(img1);
        }

//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(context);
//
//        viewFlipper.setAdapter(viewPagerAdapter);


//        dotscount = viewPagerAdapter.getCount();
//        dots = new ImageView[dotscount];
//
//        for(int i = 0; i < dotscount; i++){
//
//            dots[i] = new ImageView(context);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.non_active_dot));
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.setMargins(8, 0, 8, 0);
//
//            sliderDotspanel.addView(dots[i], params);
//
//        }

//        dots[0].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));
//        viewFlipper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.non_active_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(context, R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 3000, 5000);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedpreferences =context.getSharedPreferences(SharedPref.MY_PREFERENCE,
                        Context.MODE_PRIVATE);
                sharedpreferences = context.getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(SharedPref.USERNAME, "");
                editor.putString(SharedPref.USERPHONE, "");
                editor.commit();
                sharedPref.setLOGIN_STATUS(false);
                startActivity(new Intent(context, Password.class));
            }
        });
        return root;
    }
    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            if(getActivity() == null)
                return;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    if (viewFlipper.getCurrentItem() < images.length - 1) {
//                        viewFlipper.setCurrentItem(viewFlipper.getCurrentItem() + 1);
//                    } else {
//                        viewFlipper.setCurrentItem(0);
//                    }
                }
            });
        }
    }
    public void FillerViewImage(int images){

        ImageView imageView=new ImageView(context);
        imageView.setBackgroundResource(images);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);//3 sec
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(context,android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(context,android.R.anim.slide_out_right);


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

//            TextView textView=(TextView)view.findViewById(R.id.producttext);
            ImageView imageView=(ImageView)view.findViewById(R.id.productimage);

//            textView.setText(ProductNames[position]);
            imageView.setImageResource(ProductImages[position]);

            return  view;
        }
    }

    public class ViewPagerAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater layoutInflater;
        private Integer [] images = {R.drawable.slider1,R.drawable.slider2,R.drawable.slider3,R.drawable.slider4,R.drawable.slider5,R.drawable.slider6,
                R.drawable.slider7,R.drawable.slider8,R.drawable.slider9,R.drawable.slider10,R.drawable.slider11,R.drawable.slider12,R.drawable.slide1};

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
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
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
}
