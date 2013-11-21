package com.betaelectronics.tournamentadministrator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
public class NuevoTorneoActivity extends Activity {
	String AuxName, AuxGame;

	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nuevo_torneo);		 
		
		ImageButton DoneButton = (ImageButton) findViewById(R.id.DoneButton);

		final EditText   ETName= (EditText) findViewById(R.id.ET_Name);
	    final EditText ETGame=   (EditText) findViewById(R.id.ET_Game);
	    
		final DataSourceManager DSM = new DataSourceManager(this);
		
		DoneButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("TorneoApp","Insertando valores de Torneo");
				
				AuxName= ETName.getText().toString();
				AuxGame= ETGame.getText().toString();
				DSM.open();
				DSM.CreateTounament(AuxName, AuxGame);
				int AuxID=DSM.GetTournament().GetId();
				
				Log.i("TorneoApp","Valores insertados");
				

				Intent i=new Intent(NuevoTorneoActivity.this,AddParticipantActivity.class); 
				i.putExtra("IDT", AuxID);
				startActivity(i);
				
			}
		}); 
		
		
		 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nuevo_torneo, menu);
		return true;
	}

}
