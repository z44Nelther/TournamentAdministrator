package com.betaelectronics.tournamentadministrator;

public class Participant {
	private String Name;
	private int id;
	private int Numero;
	private int torneo;
	
public Participant(String Name_Participant){
	this.Name=Name_Participant;
}

public void SetId (int id){
	this.id=id;
}
public int GetId(){
	return id;
}
public void SetName(String name){
	this.Name=name;
}
public String GetNAme(){
	return Name;
}
public void SetNumber(int number){
	this.Numero=number;
}
public int GetNumber(){
	return Numero;
}
public void SetTorneo(int Torneo){
	this.torneo=Torneo;
}
public int GetTorneo(){
	return torneo;
}

}
