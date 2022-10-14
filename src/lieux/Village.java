package lieux;

import personnages.*;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois=0;
	private Gaulois[] villageois=new Gaulois[nbVillageois];
	public Village(String nom,int nbVillageois) {
	this.nom = nom;
	this.nbVillageois=nbVillageois;
	}
	
	public void setChef(Chef chef) {
	this.chef = chef;
	}
	
	public String getNom() {
	return nom;
	}
}
