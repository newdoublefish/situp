package com.example.vxwokrs.situp.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by vxwokrs on 2016/4/20.
 */
public class SitupApplication extends Application {
    private final String TAG=this.getClass().getSimpleName();
    private static Context situpApplication;
    private static SitupApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        situpApplication=this;
        instance=this;
        SitupPreferenceUtils.init(this);
        Log.e(TAG, "---onCreate");
    }

    public static SitupApplication getInstance()
    {
        return instance;
    }

}
