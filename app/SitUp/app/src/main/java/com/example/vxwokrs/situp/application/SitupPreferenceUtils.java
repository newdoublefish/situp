package com.example.vxwokrs.situp.application;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vxwokrs on 2016/4/20.
 */
public class SitupPreferenceUtils {
    private  final String PREFERENCE_NAME="data";
    private  SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    private  static SitupPreferenceUtils situpPreferenceUtils;

    private SitupPreferenceUtils(Context ctx)
    {
        sharedPreferences=ctx.getSharedPreferences(PREFERENCE_NAME,ctx.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public static void init(Context context)
    {
        if(situpPreferenceUtils==null)
            situpPreferenceUtils=new SitupPreferenceUtils(context);
    }

    public static SitupPreferenceUtils getInstance(){
        return situpPreferenceUtils;
    }

    public String  getLoginedUserName()
    {
        String userName=sharedPreferences.getString("userName",null);
        System.out.println("---------------"+userName);
        return userName;
    }

    public void  setLoginedUserName(String userName) {
        editor.putString("userName",userName).commit();
    }

    public void clearAll()
    {
        editor.clear().commit();
    }

}
