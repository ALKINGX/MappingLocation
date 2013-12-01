package edu.sdsmt.thompsonsamson.locationmapping;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

public class MyGoogleMap extends Activity {

	private GoogleMap googleMap;
	private MapFragment mapFragment;
	private LocationManager locationManager;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        
        if(googleMap == null)
        {
        	
        	mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        	googleMap = mapFragment.getMap();
			
        	if(googleMap != null)
			{
				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				updatePlaces();
			}

		}
        
    }

	private void updatePlaces() 
	{

		locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

		Location lastLoc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		double lat = lastLoc.getLatitude();
		double lng = lastLoc.getLongitude();
		
		LatLng lastLatLng = new LatLng(lat, lng);
		
		CameraPosition cameraPosition = new CameraPosition.Builder()
			.target(lastLatLng)
			.zoom(17)
			.build();
		
		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}
    
}
