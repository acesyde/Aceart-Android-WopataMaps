package com.pem.app.helper;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import com.google.android.gms.maps.model.LatLng;
import com.pem.app.models.SearchLocation;

/**
 * Created by Pierre-Emmanuel on 21/02/14.
 */
public class LocationHelper {

    public static SearchLocation getCurrentLocation(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if(locationManager != null) {
            String bestProvider = locationManager.getBestProvider(new Criteria(), false);

            Location location = locationManager.getLastKnownLocation(bestProvider);

            return getLocation(location);
        }

        return null;
    }

    public static SearchLocation getLocation(Location location) {
        if(location != null) {
            SearchLocation searchLocation = new SearchLocation(SearchLocation.LocationType.LatLng);
            searchLocation.setLatLng(new LatLng(location.getLatitude(),location.getLongitude()));
            return searchLocation;
        }

        return null;
    }

}
