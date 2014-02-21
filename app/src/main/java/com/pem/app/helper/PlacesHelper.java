package com.pem.app.helper;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.pem.app.listeners.SearchNearbyListener;
import com.pem.app.models.POI;
import com.pem.app.models.SearchLocation;
import com.pem.app.rest.mappers.POIMapper;
import com.pem.app.rest.requests.NearbySearchPlacesRequest;
import com.pem.app.rest.responses.NearbySearchPlacesResponse;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Use Place API
 */
public class PlacesHelper {

    private SpiceManager contentManager;
    private Context context;
    private SearchNearbyListener searchNearbyHandler;
    private LatLng currentLatLng;

    public PlacesHelper(Context context, SpiceManager contentManager) {
        this.context = context;
        this.contentManager = contentManager;
    }

    /**
     * Search nerbay location Address or Geo point
     * @param searchLocation
     */
    public void searchNearby(SearchLocation searchLocation) {
        if(searchLocation != null) {

            switch (searchLocation.getLocationType()) {
                case Address:
                    currentLatLng = getLatLngFromName(searchLocation.getAddress());
                    break;
                case LatLng:
                    currentLatLng = searchLocation.getLatLng();
                    break;
            }

            if(currentLatLng == null)
                return;

            NearbySearchPlacesRequest request = new NearbySearchPlacesRequest(context ,currentLatLng);

            contentManager.execute(request, request.getCacheKey(), DurationInMillis.ALWAYS_EXPIRED, new LoadPOIRequestListener());
        }
    }

    public void setOnSearchNearby(SearchNearbyListener listener) {
        this.searchNearbyHandler = listener;
    }

    protected void onSearchNearbyFired(LatLng position, List<POI> poiList) {
        if(searchNearbyHandler != null)
            searchNearbyHandler.onSearchNearby(position, poiList);
    }

    /**
     * Use Geocoder to transform name into lat / lng
     * @param search query
     * @return LatLng
     */
    private LatLng getLatLngFromName(String name) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());

        try {
            List<Address> addressList = geocoder.getFromLocationName(name, 1);

            if(addressList != null && addressList.size() > 0) {
                return new LatLng(addressList.get(0).getLatitude(), addressList.get(0).getLongitude());
            }

        } catch (IOException e) {
            Log.e("POI", e.getMessage());
        }

        return null;
    }

    /**
     * POI Request Listener
     */
    private class LoadPOIRequestListener implements RequestListener<NearbySearchPlacesResponse> {

        @Override
        public void onRequestFailure(SpiceException e) {
            Log.e("POI", e.getMessage());
            onSearchNearbyFired(currentLatLng, null);
        }

        @Override
        public void onRequestSuccess(NearbySearchPlacesResponse searchPlacesResponse) {
            if(searchPlacesResponse != null && searchPlacesResponse.getResults() != null) {
                onSearchNearbyFired(currentLatLng, POIMapper.convertListRestToPoi(searchPlacesResponse.getResults()));
            }
        }
    }
}
