package com.pem.app.helper;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pem.app.models.POI;

import java.util.List;

/**
 * Created by Pierre-Emmanuel on 21/02/14.
 */
public class MapHelper {

    public static void FocusThisPosition(GoogleMap map, LatLng position) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 15);
        map.animateCamera(cameraUpdate);
    }

    public static  void CreateMarkers(GoogleMap map, List<POI> poiList) {
        for (POI poi : poiList) {
            CreateMarker(map,poi);
        }
    }

    public static void CreateMarker(GoogleMap map, POI poi) {
        map.addMarker(new MarkerOptions()
                .position(poi.getGeo())
                .title(poi.getName())
                .snippet(poi.getDescription()));
    }

}
