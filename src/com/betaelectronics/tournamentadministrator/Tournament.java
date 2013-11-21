package com.betaelectronics.tournamentadministrator;

public class Tournament {
	private int Id;
	private String Name;
	private String Game;

	public Tournament(String name, String game) {
		this.Name=name;
		this.Game=game;
	}
	
	public void SetID(int id){
		this.Id=id;
	}
	public int GetId(){
		return Id;
	}
	public void SetName (String Name){
		this.Name=Name;
	}
	public String GetName(){
		return Name;
	}
	public void SetGame (String game){
		Game=game;
	}
	public String GetGame(){
		return Game;
	}

}
