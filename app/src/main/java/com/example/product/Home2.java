package com.example.product;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.w3c.dom.Text;

public class Home2 extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    SharedPreferences sharedpreferences;
    SharedPref sharedPref;
    Context context;
    String TAG=getClass().getName();
    String name,phone;
    TextView nametext,phnumbertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.colormenuicon);
        toolbar.setNavigationIcon(R.drawable.colormenuicon);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.colormenuicon);
        FloatingActionButton fab = findViewById(R.id.fab);

//        nametext=(TextView)findViewById(R.id.textView1);
//        phnumbertext=(TextView)findViewById(R.id.textView2);
//        getActionBar().setIcon(R.drawable.appbaricon);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        context=this;
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        sharedPref=new SharedPref(context);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.app_name,R.string.app_name );
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.setHomeAsUpIndicator(R.drawable.colormenuicon);
//        toggle.setDrawerIndicatorEnabled(false);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),   R.drawable.list,this.getTheme());
        toggle.setHomeAsUpIndicator(drawable);
//        getSupportActionBar().setHomeButtonEnabled(false);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menn_icon);

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.appbaricon);


        nametext=headerView.findViewById(R.id.textView1);
        phnumbertext=headerView.findViewById(R.id.textView2);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home,R.id.nav_gallery,R.id.nav_slideshow)
                R.id.nav_home,R.id.nav_gallery)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        Menu m = navigationView.getMenu();
        MenuItem itemessage=m.add("Contact Us");
        itemessage.setIcon(R.drawable.cannabisicon);
        navigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        itemessage.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //
//                String phoneNumber = "9600344951";
//                String text ="Username : "+sharedPref.getUSERNAME();
//                boolean installed = appInstalledornot("com.whatsapp");
//                if (installed) {
//                    Intent intent1 = new Intent(Intent.ACTION_VIEW);
//                    intent1.setData(Uri.parse("http://api.whatsapp.com/send?phone=" + "+91" + phoneNumber + "&text=" + text));
//                    startActivity(intent1);
//                } else {
//                        Toast.makeText(context, "Whatsapp not installed in you mobile", Toast.LENGTH_SHORT).show();
//                    }
                //
                sendEmail();


                return false;
            }
        });
        MenuItem item=m.add("Logout");
        item.setIcon(R.drawable.ic_action);

            Log.d(TAG,"Name ="+sharedPref);
            if (sharedPref.getUSERNAME()!=null) {
                nametext.setText(sharedPref.getUSERNAME());
            }

            if (sharedPref.getUSERPHONE()!=null) {
                phnumbertext.setText(sharedPref.getUSERPHONE());
            }



        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                sharedpreferences =getSharedPreferences(SharedPref.MY_PREFERENCE,
                        Context.MODE_PRIVATE);
                sharedpreferences = getSharedPreferences(SharedPref.MY_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(SharedPref.USERNAME, "");
                editor.putString(SharedPref.USERPHONE, "");
                editor.commit();
                sharedPref.setLOGIN_STATUS(false);
                startActivity(new Intent(Home2.this,Password.class));
                finish();
                return false;
            }
        });

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"Big997522@gmail.com"};
//        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
//        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "New Stonner Purchase");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I would like to buy some products...");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.d(TAG,"Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Home2.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
