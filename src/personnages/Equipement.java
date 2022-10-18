package personnages;

public enum Equipement {
	CASQUE("Casque"), BOUCLIER("Bouclier");
	private String nom;
	
	Equipement(String nom) {
		this.nom = nom;
	}
	public String toString() {
		return nom;
	}
}
