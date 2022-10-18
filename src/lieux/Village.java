package lieux;

import personnages.*;

public class Village {
	//Attributes
	private String nom;
	private Chef chef;
	private int nbMaxVillageois;
	private int nbHabitant;
	private Gaulois[] villageois;
	
	//Methods
	public Village(String nom,int nbVillageois) {
	this.nom = nom;
	this.nbMaxVillageois=nbVillageois;
	villageois=new Gaulois[nbMaxVillageois];
	}
	
	public void setChef(Chef chef) {
	this.chef = chef;
	}
	
	
	
	public String getNom() {
	return nom; 
	}
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbHabitant<nbMaxVillageois) {
			 villageois[nbHabitant]=gaulois;
			 nbHabitant++;
			 System.out.println(gaulois.getNom() +" fait maintenant partie du village " + getNom()+".");
		}else {
			System.out.println("Il y n'y a plus assez de place dans le village");
		}
	}
	public Gaulois trouverHabitant(int numHabitant){
		return villageois[numHabitant];
	}
	
	public void afficherVillageois() {
		if(nbHabitant==0) {
			System.out.println("Le village est desert...");
		} 
		if(chef !=null) {
			System.out.println("Dans le "+ getNom()+" du chef "+ chef.getNom() +" vivent les légendaires gaulois :");
		}else {
			System.out.println("Dans le "+ getNom()+" sans chef vivent les légendaires gaulois :");
		}
		for(int i = 0;i<nbHabitant;i++) {
			System.out.println("- "+ villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village=new Village("Village_des_Irreductibles",30);
		/*Gaulois gaulois = village.trouverHabitant(30);
		Index 30 out of bounds for length 0
		On obtient cette erreur car un tableau en java commence  0*/
		Chef abraracourcix = new Chef("Abrearacourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix",50);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		// Index 1 out of bounds for length 0
		/* Le chef ne fait pas partie du tableau habitant, il y a donc que asterix dedans
		 * mais il est à la position 0 du tableau, il n'y a pas de gaulois a la pos 1 dans le tableau*/
		
	}
}
