package com.pem.app.rest.requests;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;
import com.pem.app.Constant;
import com.pem.app.helper.ConfigurationManager;
import com.pem.app.rest.responses.NearbySearchPlacesResponse;


public class NearbySearchPlacesRequest extends SpringAndroidSpiceRequest<NearbySearchPlacesResponse> {

    private LatLng latLng;
    private Context context;

    public NearbySearchPlacesRequest(Context context, LatLng latLng) {
        super(NearbySearchPlacesResponse.class);
        this.latLng = latLng;
        this.context = context;
    }

    @Override
    public NearbySearchPlacesResponse loadDataFromNetwork() throws Exception {
        String url = String.format(Constant.REST_GPLACE_URL_SEARCH, latLng.latitude, latLng.longitude, 1000, ConfigurationManager.getString(context,Constant.PLACE_API_MD, ""));
        Log.d("POI", url);
        return getRestTemplate().getForObject(url,NearbySearchPlacesResponse.class);
    }

    public String getCacheKey() {
        return NearbySearchPlacesRequest.class.getName();
    }
}
