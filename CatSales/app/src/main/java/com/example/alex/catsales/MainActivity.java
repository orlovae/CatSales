package com.example.alex.catsales;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alex.catsales.model.Cat;
import com.example.alex.catsales.model.FakeCatArray;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private FakeCatArray db;
    private ArrayList<Cat> fakeListCat;
    private GoogleMap googleMap;
    LocationManager locationManager;
    Context context;

    private static final double WASHINGTON_LATITUDE = 38.9071923;
    private static final double WASHINGTON_LONGITUDE = -77.0368707;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDB();
        fabriceCat(db);
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
        }
    }

    private void setCurrentLocation(){
        double lat = WASHINGTON_LATITUDE;
        double lng = WASHINGTON_LONGITUDE;

        LatLng target = new LatLng(lat, lng);
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

    private FakeCatArray initDB(){
        if (db == null){
            db = new FakeCatArray();
            return db;
        }
        return db;
    }

    private ArrayList<Cat> fabriceCat(FakeCatArray db){
        if(fakeListCat == null) {
            fakeListCat = new ArrayList<Cat>();
        }

        String uriPhoto, name, breed, description;
        double latitude, longtude;
        String telefon;

        for (int i = 0; i < db.getName().size(); i++) {
            uriPhoto = "";
            name = db.getName().get(i);
            breed = db.getBreed().get(i);
            description = db.getDescription().get(i);
            latitude = db.getLatitude().get(i);
            longtude = db.getLongtude().get(i);
            telefon = db.getTelefon().get(i);

            Cat cat = new Cat(uriPhoto, name, breed, description, latitude, longtude, telefon);
            fakeListCat.add(cat);
        }

        return fakeListCat;
    }
}
