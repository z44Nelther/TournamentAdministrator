package com.betaelectronics.tournamentadministrator;

import android.content.Context;

public class Match {
	int quantity;
	DataSourceManager DSM ;
	Context ctx;
public Match(int id, Context contx) {
	ctx= contx;
	DSM = new DataSourceManager(ctx);
	DSM.open();
	quantity=DSM.getParticipantsQuantity(id);
}

public boolean poweroftwo(int x){
	boolean s=(x != 0) && ((x & (x - 1)) == 0);
	return s;
	
}



}
