package edu.sdsmt.thompsonsamson.locationmapping;

import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MyStreetView extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        
        // get handle for LocationManager
        LocationManager lm =(LocationManager) getSystemService(Context.LOCATION_SERVICE);
     	
    
     	// connect to the GPS location service
     	Location loc = lm.getLastKnownLocation("gps");
    
     	if( loc != null )
        {
	        String uri = "google.streetview:cbll=" + 
	        			loc.getLatitude() + "," + 
	        			loc.getLongitude() + "&cbp=1,0,,0,1.0&mz=12";
	        
	        //String uri = "google.streetview:cbll=42.352299,-71.063979&cbp=1,0,,0,1.0&mz=12";
	        Intent streetView = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
	        startActivity(streetView);
        }
	}
}