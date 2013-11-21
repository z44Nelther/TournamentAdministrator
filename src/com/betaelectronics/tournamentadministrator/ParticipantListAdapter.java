package com.betaelectronics.tournamentadministrator;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ParticipantListAdapter extends ArrayAdapter<Participant> {
	
	private ArrayList <Participant> Participants;
	private Context ctx;
	public ParticipantListAdapter(Context context,int textViewResourceId, ArrayList <Participant> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		Participants=objects;
		ctx = context;
	}
	
	public View getView  ( int position, View convertView, ViewGroup parent){
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=vi.inflate(R.layout.item_list_participant, null);
		}
		Participant temp = Participants.get(position);
		TextView tvParticipantName = (TextView) v.findViewById(R.id.TV_PartName);
		
	
		
		tvParticipantName.setText(temp.GetNAme());
		
		
		
		return v;
	}

}
