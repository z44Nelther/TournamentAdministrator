package com.betaelectronics.tournamentadministrator;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class AddParticipantActivity extends Activity {
	String auxname;
	public AddParticipantActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_participant);
		ImageButton AddButton = (ImageButton) findViewById(R.id.AddButton);
		final DataSourceManager DSM = new DataSourceManager(this);
		DSM.open();
		Bundle bundle = getIntent().getExtras();
		final Tournament T=DSM.ByID(bundle.getInt("IDT"));
		ListView LstPar = (ListView) findViewById(R.id.LV_participantsList);
		final ArrayList<Participant> allparticipants = DSM.GetAllParticipants(T.GetId());
		
		final EditText Name = (EditText) findViewById(R.id.ET_newPart);
		
		final ParticipantListAdapter adapter = new ParticipantListAdapter(this,R.layout.item_list_participant,allparticipants);
		LstPar.setAdapter(adapter);

		
		
		
		
		Log.i("TorneoApp","Valor id "+bundle.getInt("IDT"));
		
		//pone el titulo del torneo
		
		TextView TournamentTitle = (TextView) findViewById(R.id.TV_TournamentTitle);
		
		TournamentTitle.setText(T.GetName());
		//pone el titulo del torneo
		
		AddButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i("TorneoApp","Insertando valores de participante");
				auxname=Name.getText().toString();
				Log.i("TorneoApp","Valor de auxName "+ auxname);
				DSM.CreateParticipant(auxname, T.GetId());
				Participant aux = new Participant(auxname);
			    
				allparticipants.add(aux);
				adapter.notifyDataSetChanged();
				
				
			}
				
			});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_participant, menu);
		return true;
	}

}
