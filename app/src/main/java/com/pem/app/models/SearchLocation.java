package com.pem.app.models;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Pierre-Emmanuel on 21/02/14.
 */
public class SearchLocation {

    public enum LocationType {
        LatLng,
        Address
    }

    private LocationType locationType;
    private LatLng latLng;
    private String Address;

    public SearchLocation(LocationType locationType) {
        this.locationType = locationType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public SearchLocation setLatLng(Location location) {
        if(location != null) {
            return setLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
        }

        return this;
    }

    public SearchLocation setLatLng(LatLng latLng) {
        this.latLng = latLng;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public SearchLocation setAddress(String address) {
        Address = address;
        return this;
    }
}
