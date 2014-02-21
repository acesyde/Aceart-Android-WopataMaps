package com.pem.app.helper;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pem.app.models.POI;

import java.util.List;

/**
 * Google map Extensions
 */
public class MapHelper {

    /**
     * Focus position with animation
     * @param map
     * @param position
     */
    public static void FocusThisPosition(GoogleMap map, LatLng position) {
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 15);
        map.animateCamera(cameraUpdate);
    }

    /**
     * Create multiple markers on the map
     * @param map
     * @param poiList
     */
    public static  void CreateMarkers(GoogleMap map, List<POI> poiList) {
        for (POI poi : poiList) {
            CreateMarker(map,poi);
        }
    }

    /**
     * Create marker on the map
     * @param map
     * @param poi
     */
    public static void CreateMarker(GoogleMap map, POI poi) {
        map.addMarker(new MarkerOptions()
                .position(poi.getGeo())
                .title(poi.getName())
                .snippet(poi.getDescription()));
    }

}
