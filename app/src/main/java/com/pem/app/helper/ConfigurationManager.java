package com.pem.app.helper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class ConfigurationManager {

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("POI", e.getMessage());
        }

        return null;
    }

    public static String getString(Context context, String key, String defaultValue) {
        ApplicationInfo applicationInfo = getApplicationInfo(context);

        if(applicationInfo != null && applicationInfo.metaData != null) {
            return applicationInfo.metaData.getString(key);
        }

        return defaultValue;
    }

}
