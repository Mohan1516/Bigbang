package com.example.product;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPref {
    public static final String MY_PREFERENCE = "mypref";

    public static String USERNAME = "mypref_username";
    public static String USERPHONE = "mypref_userphone";
    public static String LOGIN_STATUS = "login_status";
    Context context1;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;


    public SharedPref(Context context) {
        context1 = context;
        if (context == null) {
            Log.e("LOGGER", "CON IS NULL");
        }
        if (MY_PREFERENCE == null) {
            Log.e("LOGGER", "MyPREFERENCES IS NULL");
        }
        sharedpreferences = context1.getSharedPreferences(MY_PREFERENCE, Activity.MODE_PRIVATE);
        editor = sharedpreferences.edit();

    }
    public boolean getLOGIN_STATUS() {
        if (sharedpreferences.contains(LOGIN_STATUS)) {
            return sharedpreferences.getBoolean(LOGIN_STATUS, false);
        }
        return false;
    }

    public void setLOGIN_STATUS(boolean lOGIN_STATUS) {
        editor = sharedpreferences.edit();
        editor.putBoolean(LOGIN_STATUS, lOGIN_STATUS);
        editor.commit();
    }

    public String getUSERNAME(){
        if (sharedpreferences.contains(USERNAME)){
            return sharedpreferences.getString(USERNAME,"");
        }
        return "";
    }
    public void setUSERNAME(String username){
        editor=sharedpreferences.edit();
        editor.putString(USERNAME,username);
        editor.commit();
    }

    public String getUSERPHONE(){
        if (sharedpreferences.contains(USERPHONE)){
            return sharedpreferences.getString(USERPHONE,"");
        }
        return "";
    }
    public void setUSERPHONE(String username){
        editor=sharedpreferences.edit();
        editor.putString(USERPHONE,username);
        editor.commit();
    }



}
