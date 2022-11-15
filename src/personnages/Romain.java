package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private String texte;
	private int force;
	private int nbEquipement=0;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		if (force<0) {
			 throw new IllegalArgumentException("Invalid price: " + force);
		}
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}

	public void parler(String texte) { 
		System.out.println(prendreParole() + "� " + texte + "�"); 
	} 
	private String prendreParole() { 
		return "Le romain " + nom + " : "; 
	}
	/*public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force> 0) {
			parler("aie");

		}else {
			parler("J'abandonne...");
		}
	}*/


	public void sEquiper(Equipement equipement) {
		System.out.print("Le soldat "+ getNom());
		switch(nbEquipement) {
		case 2:
			System.out.println("est bien equipé.");
			break;
		case 1:
			if(equipements[0]==equipement) {
				System.out.println("possede deja un "+equipement.toString());
			}else {
				System.out.println("s'equipe avec un "+ equipement.toString());
				equipements[nbEquipement++]=equipement;
			}
			break;
		default:
			System.out.println("s'equipe avec un "+ equipement.toString());
			equipements[nbEquipement++]=equipement;
		}
	}

	/*Methods a debuger*/

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup; 
		if(force<0)
			force=0;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force==0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
				int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa  force est diminué de ";
					for (int i = 0; i < nbEquipement;i++) {
						if ((equipements[i] != null &&
								equipements[i].equals(Equipement.BOUCLIER))) {
							resistanceEquipement += 8;
						} else {
							System.out.println("Equipement casque");
							resistanceEquipement += 5;
						}
					}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
				//TODO
				int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
						equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}
	public int getForce() {
		return force;
	}
	


}