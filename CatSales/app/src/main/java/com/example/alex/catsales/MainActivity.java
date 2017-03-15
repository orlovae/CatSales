package com.example.alex.catsales;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alex.catsales.model.Cat;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private ArrayList<Cat> fakeListCat;
    private GoogleMap googleMap;

    private static final double WASHINGTON_LATITUDE = 38.9071923;
    private static final double WASHINGTON_LONGITUDE = -77.0368707;
    public static final String CAT_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFabricCat();
        createMapView();
    }

    private void createMapView(){
        final MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.
                ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            googleMap = map;
            googleMap.setMyLocationEnabled(true);

            setCurrentLocation();
            addMarker(fakeListCat);

            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Intent intent = new Intent(MainActivity.this, CatActivity.class);
                    String name = marker.getTitle();

                    intent.putExtra(CAT_NAME, name);
                    startActivity(intent);
                    return false;
                }
            });
        }
    }

    private void setCurrentLocation(){
        LatLng target = new LatLng(WASHINGTON_LATITUDE, WASHINGTON_LONGITUDE);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(target, 10F);
        googleMap.animateCamera(cameraUpdate);
    }

    private void addMarker(ArrayList<Cat> fakeListCat){
        if (googleMap != null){

            for (int i = 0; i < fakeListCat.size(); i++) {
                googleMap.addMarker(new MarkerOptions()
                        .position(new LatLng(fakeListCat.get(i).getLatitude(),
                                fakeListCat.get(i).getLongtude()))
                        .title(fakeListCat.get(i).getName())
                        .draggable(false)
                );
            }
        }
    }

    private void initFabricCat(){
        if(fakeListCat == null) {
            fakeListCat = new ArrayList<>();
        }

        MyApp app = ((MyApp)getApplicationContext());
        fakeListCat = app.getFakeListCat();
    }
}
