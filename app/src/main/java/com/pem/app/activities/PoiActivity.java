package com.pem.app.activities;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.pem.app.R;
import com.pem.app.helper.MapHelper;
import com.pem.app.helper.PlacesHelper;
import com.pem.app.listeners.SearchNearbyListener;
import com.pem.app.models.POI;
import com.pem.app.models.SearchLocation;

import java.util.List;

public class PoiActivity extends BaseActivity implements SearchNearbyListener {

    private boolean isMyLocationAlreadyInit;
    private GoogleMap map;
    private PlacesHelper placesHelper;
    private MenuItem searchMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placesHelper = new PlacesHelper(this, getContentManager());
        placesHelper.setOnSearchNearby(this);
    }

    private void setUpMapIfNeeded() {
        if(map == null) {
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();

            if(map != null) {
                map.setMyLocationEnabled(true);
                map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange(Location location) {

                        if(!isMyLocationAlreadyInit) {
                            loadPOI(new SearchLocation(SearchLocation.LocationType.LatLng).setLatLng(location));
                            isMyLocationAlreadyInit = true;
                        }
                    }
                });
            }
        }
    }

    private void loadPOI(SearchLocation location) {
        if(location != null) {
            map.clear();
            placesHelper.searchNearby(location);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        searchMenuItem = menu.findItem(R.id.action_menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                MenuItemCompat.collapseActionView(searchMenuItem);
                loadPOI(new SearchLocation(SearchLocation.LocationType.Address).setAddress(s));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    @Override
    public void onSearchNearby(LatLng position, List<POI> poiList) {
        if(poiList != null) {
            MapHelper.FocusThisPosition(map, position);
            MapHelper.CreateMarkers(map, poiList);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
}
