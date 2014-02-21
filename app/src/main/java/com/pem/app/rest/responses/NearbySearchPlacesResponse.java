package com.pem.app.rest.responses;

import com.pem.app.rest.models.Result;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearbySearchPlacesResponse {

    private List<Result> results;

    public NearbySearchPlacesResponse() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
