package personnages;

import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetpotionMin, int effetpotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetpotionMin;
		this.effetPotionMax = effetpotionMax; 
		prendreParole();
		parler("Bonjour,  je  suis  le  druide  "  +  nom  +  "  et  ma  potion  peut  aller " + 
				" d'une force " + effetPotionMin + "  " + 
				effetPotionMax + "."); 
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole()+ "\"" + texte + "\"");
	}
	private String prendreParole() {
		return "Le druide" + nom + ":";
	}
	public int preparerPotion(){
		Random random = new Random();
		int forcePotion;
		while( (forcePotion=random.nextInt(effetPotionMax))<5);		
		if(forcePotion>7) {
			parler("J'ai preéparé une super potion de force "+ forcePotion + ".");
		}else {
			parler("Je n'ai pas trouvé tout les ingredients, ma potion est seulement de force "+ forcePotion + ".");	
		}
		return forcePotion;
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("panoramix",5,10);
		panoramix.preparerPotion();
	}
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom()=="Obelix") {
			parler("Non,obélix !... Tu n'auras pas de potion magique !");
		}else {
			gaulois.boirePotion(preparerPotion());
		}
	}
}
