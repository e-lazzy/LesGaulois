package personnages;

import lieux.*;
import objets.Equipement;

public class Gaulois {
	
	
	private String nom;
	private int effetPotion = 1;
	
	//Attributs en plus
	private int force, nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getEffetPotion() {
		return effetPotion;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
		
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+ "� " + texte + "�");
	}
	
//	public String prendreParole() {
//		return "Le gaulois" + nom + " : ";
//	}
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de "+ romain.getNom());
//		romain.recevoirCoup(force/3*effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheeGagne = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; tropheeGagne != null && i < tropheeGagne.length; i++,
		nbTrophees++) {
		this.trophees[nbTrophees] = tropheeGagne[i];
		}
		}

	 public static void main(String[] args) { 
		 Gaulois asterix =new Gaulois("Asterix", 8);
		 Romain minus = new Romain("Minus ",6);
		 asterix.parler("Bonjour � tous");
		 minus.parler("UN GAU... UN GAUGAU...");
		 asterix.frapper(minus);
		 asterix.frapper(minus);
		 asterix.frapper(minus);
	 }
	 public void boirePotion(int forcePotion) {
		 effetPotion=forcePotion; 
		 parler("Merci Druide, je sens que ma force est "+ forcePotion +" fois decuplée");
	 }
	 public void faireUneDonnation(Musee musee) {
		 if(nbTrophees!=0) {
			 parler("Je donne au musee tous mes trophees :");
			 for(int i=0;i<nbTrophees;i++) {
				 System.out.println("-"+ trophees[i].toString());
				 musee.donnerTrophees(this, trophees[i]);
			 }
			 nbTrophees=0;
		 	}
		 	else {
				 parler("Je n'ai pas de trophées ! Allons chasser du romains !");
			 }
	 }
}
