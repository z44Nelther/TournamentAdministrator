package com.betaelectronics.tournamentadministrator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TournamentDBHelper extends SQLiteOpenHelper {
	
	//Datos generales de la base de datos
	public static final String DATABASE_NAME="TournamentDB.db";
	public static final int DATABASE_VERSION=3;
	//Datos generales de la base de datos
	
	//Datos de la tabla torneo
	public static final String TABLE_NAME="Tournaments";
	public static final String COLUMN_ID_Tournamet="ID_Tournament";
	public static final String COLUMN_Name_Tournamet="Tournament_Name";
	public static final String COLUMN_Name_Game="Game_Name";
	
	//Datos de la tabla torneo
    
	//Datos de la tabla participantes
	public static final String TABLE_NAME_PARTICIPANTS="participants";
	
	public static final String CREATE_TABLE_PARTICIPANT="CREATE TABLE participants" +
			                  " (ID_Participant integer primary key autoincrement, FK_Tournament integer, " +
			                   "Participant_Name varchar(30), Participant_Number integer, " +
			                   "FOREIGN KEY(FK_Tournament) REFERENCES Tournaments(ID_Tournament) )";
	
	public static final String CREATE_TABLE_MATCH="Create table Match (FK_Clasification integer not null, FK_Tournament integer not null," +
			" FK_Participant integer, FOREIGN KEY(FK_Tournament) REFERENCES Tournaments(ID_Tournament), " +
			"Foreign key (FK_Participant) References participants (ID_Participant), " +
			"Foreign key (FK_Clasification) references Clasifications (ID_Clasification), " +
			"primary key (FK_Clasification, FK_Tournament))";
	
	public static final String CREATE_TABLE_CLASIFICATIONS="create table Clasifications(" +
			"ID_Clasification integer primary key autoincrement," +
			"Desc_Clasification text not null)";
	
	//Trigger para insertar en la tabal participantes
	
	public static final String CREATE_TRIGER_PARTICIPANTS_NUMBER2="CREATE TRIGGER [Inserta2] "
                                                                  +"AFTER INSERT ON [participants] FOR EACH ROW" +" WHEN (select count(*) from participants)>1 "+
                                                                  "BEGIN update participants set " +
                                                                  "Participant_Number = (Select Max(Participant_Number) " +
                                                                  "from participants inner join tournaments on " +
                                                                  " participants.FK_Tournament = Tournaments.ID_Tournament " +
                                                                  "where participants.FK_Tournament = new.FK_Tournament) + 1 " +
                                                                  "where Participant_Name= new.Participant_Name; END";
                                                               
   public static final String CREATE_TRIGER_PARTICIPANTS_NUMBER1="CREATE TRIGGER [inserta] " +
   	                                                           	"AFTER INSERT ON [participants] FOR " +
   	                                                           	"EACH ROW WHEN (select count(*) from participants)=1  " +
   		                                                        "BEGIN update participants set Participant_Number =1; " +"END";                            
                                 //Trigger para insertar en la tabal participantes
                                                                  
	//Datos de la tabla participantes
	public TournamentDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID_Tournamet+" integer primary key autoincrement, "
	    		   + COLUMN_Name_Tournamet+" text not null,"+COLUMN_Name_Game+" text not null);"
	    		);
		
		db.execSQL(CREATE_TABLE_PARTICIPANT);
		
		db.execSQL(CREATE_TRIGER_PARTICIPANTS_NUMBER1);
		db.execSQL(CREATE_TRIGER_PARTICIPANTS_NUMBER2);
		
		db.execSQL(CREATE_TABLE_CLASIFICATIONS);
		db.execSQL(CREATE_TABLE_MATCH);
		
		
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldverion, int newversion) {
		db.execSQL("Delete from "+TABLE_NAME_PARTICIPANTS);
		db.execSQL("Delete from "+TABLE_NAME);
		
		
		
	}

}
