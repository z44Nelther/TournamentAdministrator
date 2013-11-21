package com.betaelectronics.tournamentadministrator;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		ImageButton NewButton = (ImageButton) findViewById(R.id.newButton);
		ImageButton SearchButton = (ImageButton) findViewById(R.id.searchButton);
		
		NewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("TorneoApp","entrando a crear torneo");
				Intent i=new Intent(MenuActivity.this,NuevoTorneoActivity.class); 
				startActivity(i);
				
			}
		}); 
		
	SearchButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("TorneoApp","entrando a Lista de torneos");
				Intent i=new Intent(MenuActivity.this,SearchTournamentActivity.class); 
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
