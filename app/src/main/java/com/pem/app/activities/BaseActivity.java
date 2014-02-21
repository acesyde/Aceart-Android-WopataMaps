package com.pem.app.activities;

import android.support.v7.app.ActionBarActivity;

import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;

/**
 * Created by Pierre-Emmanuel on 20/02/14.
 */
public class BaseActivity extends ActionBarActivity {
    private SpiceManager contentManager = new SpiceManager( JacksonSpringAndroidSpiceService.class );

    public SpiceManager getContentManager() {
        return contentManager;
    }

    @Override
    protected void onStart() {
        contentManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        contentManager.shouldStop();
        super.onStop();
    }
}
