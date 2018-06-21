package com.example.usuario.injuve;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.usuario.injuve.Interface.Comunicar;
import com.example.usuario.injuve.MarkerCluestering.MyItem;
import com.example.usuario.injuve.POJOclasses.CompanyData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, Comunicar {

    private GoogleMap mMap;
    private ClusterManager<MyItem> mClusterManager;
    List<Marker> marker=new ArrayList<Marker>();
    Marker mMarker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            LatLng cdmx = new LatLng(19.431666, -99.133546);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cdmx,13));

    }





    @Override
    public void enviarDato(List<CompanyData> data, int icon, BottomSheetBehavior bottomSheetBehavior) {

        double lat;
        double lng;
        mMap.clear();
        marker.clear();

        for (int i=0;i<data.size();i++)
        {
            lat=Double.parseDouble(data.get(i).getLatitud());
            lng=Double.parseDouble(data.get(i).getLongitud());
            LatLng cdmx = new LatLng(lat, lng);

            MarkerOptions markerOptions=new MarkerOptions()
                    .position(cdmx)
                    .title("marker")
                    .icon(BitmapDescriptorFactory.fromBitmap(defineSizeIcon(icon)));
            mMarker=mMap.addMarker(markerOptions);
            marker.add(mMarker);


        }
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public Bitmap defineSizeIcon(int icon)
    {
        int height = 100;
        int width = 100;
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(icon);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        return smallMarker;
    }
}
