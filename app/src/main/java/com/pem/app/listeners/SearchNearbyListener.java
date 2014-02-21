package com.pem.app.listeners;

import com.google.android.gms.maps.model.LatLng;
import com.pem.app.models.POI;

import java.util.List;

/**
 * Created by Pierre-Emmanuel on 21/02/14.
 */
public interface SearchNearbyListener {
    void onSearchNearby(LatLng position, List<POI> poiList);
}
