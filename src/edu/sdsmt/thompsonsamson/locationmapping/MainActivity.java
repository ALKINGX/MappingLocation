package edu.sdsmt.thompsonsamson.locationmapping;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
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
            	Intent streetView = new Intent(v.getContext(),MyStreetView.class);
            	v.getContext().startActivity(streetView);
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
}
