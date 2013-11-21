package com.betaelectronics.tournamentadministrator;

import java.util.ArrayList;

import android.R.integer;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class DataSourceManager {
	private TournamentDBHelper helper;
	private SQLiteDatabase db;
	private Context ctx;
	private Tournament T;

public  DataSourceManager(Context context){
		
		helper= new TournamentDBHelper(context);
		ctx=context;
	}

public void open(){
	db=helper.getWritableDatabase();
}

public void close(){
	db.close();
}

public void  CreateParticipant(String Participant_Name, int ID_Tournament){
	db.execSQL("INSERT INTO "+helper.TABLE_NAME_PARTICIPANTS+" (FK_Tournament, Participant_Name) values ("+ID_Tournament+", '"+ Participant_Name+"')");
	
	
}


public void CreateTounament(String Name, String Game){
	db.execSQL("Insert into "+helper.TABLE_NAME+" ("+helper.COLUMN_Name_Tournamet+","+helper.COLUMN_Name_Game+")"+
            "Values ('" +Name+"' ,'"+Game+"')");
	Tournament TournamentInserted = new Tournament(Name, Game); 
	Cursor cursor = db.rawQuery("Select * from "+helper.TABLE_NAME+" where Tournament_Name = '"+Name+"'", null);
	
	while(cursor.moveToNext()){
		TournamentInserted.SetID(Integer.parseInt(cursor.getString(0)));
	}
	
    T=TournamentInserted;

	
}

public Tournament GetTournament(){
	return T;
}
public Tournament ByID (int id){
	Log.i("TorneoApp","Valor id333 "+id);
	Tournament CurrentTournament=null;
	Cursor cursor = db.rawQuery("Select * from "+helper.TABLE_NAME+" where ID_Tournament= "+id, null);
	while(cursor.moveToNext()){
	CurrentTournament = new Tournament(cursor.getString(1), cursor.getString(2));
	CurrentTournament.SetID(Integer.parseInt(cursor.getString(0)));
	}
	return CurrentTournament;
	
}

public ArrayList<Tournament> GetAllTournaments (){
	ArrayList<Tournament> list= new ArrayList<Tournament>();
	Tournament CurrentTournament=null;
	Cursor cursor = db.rawQuery("Select * from "+helper.TABLE_NAME , null);
	
	while(cursor.moveToNext()){
	CurrentTournament = new Tournament(cursor.getString(1), cursor.getString(2));
	CurrentTournament.SetID(Integer.parseInt(cursor.getString(0)));
	list.add(CurrentTournament);
	}
	return list;
	
}

public ArrayList<Participant> GetAllParticipants(int id){
	ArrayList<Participant> list = new ArrayList<Participant>();
	Participant CurrentParticipant = null;
	Cursor cursor = db.rawQuery("select * from "+helper.TABLE_NAME_PARTICIPANTS+" Where FK_Tournament = "+id, null);
	while(cursor.moveToNext()){
		CurrentParticipant= new Participant(cursor.getString(2));
		CurrentParticipant.SetTorneo(cursor.getInt(1));
		CurrentParticipant.SetNumber(cursor.getInt(3));
		list.add(CurrentParticipant);
		
	}
	return list;
}

public int getParticipantsQuantity(int id){
	int value;
	value= Integer.parseInt("select count (Participant_Name) from tournaments inner join participants on " +
			"Tournaments.ID_Tournament= participants.FK_Tournament where ID_Tournament=FK_Tournament and FK_Tournament= "+id);
	return value;
}
}
