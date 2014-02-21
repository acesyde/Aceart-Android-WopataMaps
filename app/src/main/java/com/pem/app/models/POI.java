package com.pem.app.models;

import com.google.android.gms.maps.model.LatLng;

public class POI {
    private String name;
    private String description;
    private LatLng geo;

    public POI(String name, String description, LatLng geo) {
        this.name = name;
        this.description = description;
        this.geo = geo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LatLng getGeo() {
        return geo;
    }

    public void setGeo(LatLng geo) {
        this.geo = geo;
    }
}
