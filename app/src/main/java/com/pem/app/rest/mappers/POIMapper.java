package com.pem.app.rest.mappers;

import com.google.android.gms.maps.model.LatLng;
import com.pem.app.models.POI;
import com.pem.app.rest.models.Result;

import java.util.ArrayList;
import java.util.List;

public class POIMapper {
    public static List<POI> convertListRestToPoi(List<Result> results) {
        List<POI> poiList = new ArrayList<POI>();

        for(final Result result : results) {
            POI poi = convertRestToPoi(result);
            if(poi != null) {
                poiList.add(poi);
            }
        }

        return poiList;
    }

    public static POI convertRestToPoi(Result result) {
        if(result != null) {
            return new POI(result.getName(),result.getVicinity(), new LatLng(result.getGeometry().getLocation().getLat(),result.getGeometry().getLocation().getLng()));
        }

        return null;
    }
}
