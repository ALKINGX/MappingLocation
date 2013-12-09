package edu.sdsmt.thompsonsamson.locationmapping;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		Button buttonGoogleMaps;
		Button buttonStreetView;
		Button buttonLocationNoMaps;
		
		buttonGoogleMaps = (Button) findViewById(R.id.button_google);
		buttonGoogleMaps.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
            	Intent googleMap = new Intent(v.getContext(),MyGoogleMap.class);
            	v.getContext().startActivity(googleMap);
            }            
		});
		
		buttonStreetView = (Button) findViewById(R.id.button_streetview);
		buttonStreetView.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
            	startStreetViewIntent(v);
            	
            	//Intent streetView = new Intent(v.getContext(),MyStreetView.class);
            	//v.getContext().startActivity(streetView);
            }            
		});
		
		buttonLocationNoMaps = (Button) findViewById(R.id.button_location);
		buttonLocationNoMaps.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) 
            {
            	Intent locationWithoutMaps = new Intent(v.getContext(),LocationWithoutMaps.class);
            	v.getContext().startActivity(locationWithoutMaps);
            }
		});
	}
	
	// street view intent
	private void startStreetViewIntent(View v)
	{
		// get handle for LocationManager
        LocationManager lm =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
     	
     	// connect to the GPS location service
     	Location loc = lm.getLastKnownLocation("gps");
    
     	// define the url
     	String uri = "google.streetview:cbll=%s,%s&cbp=1,0,,0,1.0&mz=12";

     	// static or not depending if we get a location
     	if( loc != null ) {
     		uri = String.format(uri, loc.getLatitude(), loc.getLongitude());
        }
     	else {
	        uri = String.format(uri, "44.0761667", "-103.2073333");
        }
     	
     	Toast.makeText(this, uri, Toast.LENGTH_LONG).show();
     	
        Intent streetView = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(streetView);
	}
}
