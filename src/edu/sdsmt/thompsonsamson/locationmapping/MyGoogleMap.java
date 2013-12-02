package edu.sdsmt.thompsonsamson.locationmapping;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import android.app.Activity;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;

public class MyGoogleMap extends Activity 
{
	// some static locations
	private static final LatLng sdsmtLocation = new LatLng(44.0748, -103.20585);
	private static final LatLng schoolLocation = new LatLng(44.075033, -103.207);
	private static final LatLng workLocation = new LatLng(44.07263, -103.20526);
	private static final LatLng beerLocation = new LatLng(44.08003, -103.22863);
	
	// map and location member
	private GoogleMap googleMap;
	private MapFragment mapFragment;
	
	// marker and icon members
	private int schoolIcon, workIcon, beerIcon;
	private Marker schoolMarker, workMarker, beerMarker;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
        
        schoolIcon = R.drawable.university;
        workIcon = R.drawable.workoffice;
        beerIcon = R.drawable.beergarden;
        
        // setup the map
        if(googleMap == null)
        {	
        	// get the map fragment and the map object
        	mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        	googleMap = mapFragment.getMap();
			
        	// set the map
        	if(googleMap != null)
			{
				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
				updatePlaces();
			}
		}
    }

	private void updatePlaces() 
	{	
		// setup the map markers
		setMarkers();
		
		// draw the path
		setPath();
		
		// set the camera position
		CameraPosition cameraPosition = new CameraPosition.Builder()
			.target(sdsmtLocation)
			.zoom(17)
			.tilt((float)60.0)
			.build();
		
		// move the camera
		googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	}

	private void setPath() 
	{
		new Color();
		// setup line options
		PolylineOptions rectOptions = new PolylineOptions()
			.color(Color.parseColor("#755673DB"))
        	.add(new LatLng(44.07626, -103.2073),
        		 new LatLng(44.076616, -103.20715),
        		 new LatLng(44.07803, -103.2104),
        		 new LatLng(44.079, -103.21425),
        		 new LatLng(44.081683, -103.230716),
        		 new LatLng(44.080616, -103.23103),
        		 new LatLng(44.080216, -103.22856));

		// add the line to the map
		googleMap.addPolyline(rectOptions);
		
	}

	private void setMarkers() 
	{
		// check the markers and remove them if visible
		if( schoolMarker != null) schoolMarker.remove();
		if( workMarker != null) workMarker.remove();
		if( beerMarker != null) beerMarker.remove();
		
		// setup the school
		schoolMarker = googleMap.addMarker(new MarkerOptions()
	    	.position(schoolLocation)
	    	.title("McLaury Building")
	    	.icon(BitmapDescriptorFactory.fromResource(schoolIcon))
	    	.snippet("Mobile class is the best!"));

		workMarker = googleMap.addMarker(new MarkerOptions()
	    	.position(workLocation)
	    	.title("Black Hills Business Center")
	    	.icon(BitmapDescriptorFactory.fromResource(workIcon))
	    	.snippet("I work at CHR Solutions."));

		beerMarker = googleMap.addMarker(new MarkerOptions()
	    	.position(beerLocation)
	    	.title("Independent Ale House")
	    	.icon(BitmapDescriptorFactory.fromResource(beerIcon))
	    	.snippet("Study Session... Really!"));	
	}
    
}
