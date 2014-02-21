package com.pem.app.rest.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private Geometry geometry;
    private String icon;
    private String id;
    private String name;
    private Opening_hours opening_hours;
    private Integer price_level;
    private Double rating;
    private String reference;
    private List<String> types = new ArrayList<String>();
    private String vicinity;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Opening_hours getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(Opening_hours opening_hours) {
        this.opening_hours = opening_hours;
    }

    public Integer getPrice_level() {
        return price_level;
    }

    public void setPrice_level(Integer price_level) {
        this.price_level = price_level;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}
