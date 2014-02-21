package com.pem.app.rest.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Opening_hours {
    private Boolean open_now;

    public Boolean getOpen_now() {
        return open_now;
    }

    public void setOpen_now(Boolean open_now) {
        this.open_now = open_now;
    }
}
