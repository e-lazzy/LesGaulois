package personnages;

import lieux.Village;

public class Chef extends Gaulois{
	private Village village;
	public Chef(String nom, int force, Village village) {
		super(nom,force);
		this.village = village;
	}
	
	 @Override
	 public void parler(String texte) { 
	 System.out.println(prendreParole() + "� " + texte + "�"); 
	 } 
	 
	 public String prendreParole() { 
	 return "Le chef " + getNom() + " du village " + village.getNom() + " : "; 
	 } 
	 public void frapper(Romain romain) { 
	 System.out.println(getNom()  +  "  envoie  un  grand  coup  dans  la  m�choire  de  "  + 
	 romain.getNom()); 
	 romain.recevoirCoup(getForce() / 3); 
	 } 
}
