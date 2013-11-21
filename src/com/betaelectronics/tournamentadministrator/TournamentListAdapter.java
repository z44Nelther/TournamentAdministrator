package com.betaelectronics.tournamentadministrator;

import java.util.ArrayList;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TournamentListAdapter extends ArrayAdapter<Tournament>{
	
	private ArrayList <Tournament> tournaments;
	private Context ctx;
	public TournamentListAdapter(Context context,int textViewResourceId, ArrayList <Tournament> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		tournaments=objects;
		ctx = context;
	}
	
	
	public View getView  ( int position, View convertView, ViewGroup parent){
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=vi.inflate(R.layout.item_list_tournament, null);
		}
		Tournament temp = tournaments.get(position);
		TextView tvTTitle = (TextView) v.findViewById(R.id.TV_TTittle);
		TextView tvParticipantsNList = (TextView)v.findViewById(R.id.TV_ParticimaptNumberList);
	
		
		tvTTitle.setText(temp.GetName());
		tvParticipantsNList.setText(temp.GetGame());
		
		
		return v;
	}

}
