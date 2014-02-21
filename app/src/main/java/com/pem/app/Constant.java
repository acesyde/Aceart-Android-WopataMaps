package com.pem.app;

/**
 * Created by Pierre-Emmanuel on 20/02/14.
 */
public class Constant {

    private static final String BASE_REST_GPLACE_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    public  static final String REST_GPLACE_URL_SEARCH = BASE_REST_GPLACE_SEARCH_URL + "?location=%s, %s&radius=%s&sensor=false&key=%s";

    public static final String PLACE_API_MD = "com.pem.app.Place_API_KEY";

}
