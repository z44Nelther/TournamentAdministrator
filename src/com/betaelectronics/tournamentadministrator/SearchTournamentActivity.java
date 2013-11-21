package com.betaelectronics.tournamentadministrator;

import java.util.ArrayList;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SearchTournamentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_tournament);
		ListView lstTounaments = (ListView) findViewById(R.id.LV_TournamentList);
		
		DataSourceManager datasource  = new DataSourceManager(this);
		datasource.open();
		final ArrayList<Tournament> alltournaments = datasource.GetAllTournaments();
		
		TournamentListAdapter adapter = new TournamentListAdapter(this,R.layout.item_list_tournament,alltournaments);
		lstTounaments.setAdapter(adapter);
		
		lstTounaments.setOnItemClickListener(new OnItemClickListener() {

			@Override()
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				Log.i("TorneoApp","item clickeado: "+ String.valueOf(position));
				Intent i = new Intent(SearchTournamentActivity.this,AddParticipantActivity.class);
				i.putExtra("IDT", alltournaments.get(position).GetId());
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_tournament, menu);
		return true;
	}

}
