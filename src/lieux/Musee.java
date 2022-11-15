package lieux;

import objets.*;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee;
	public Musee() {
		this.trophees = new Trophee[200];
		this.nbTrophee = 0;
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee nouveauTroph = new Trophee(gaulois,equipement);
		trophees[nbTrophee]=nouveauTroph;
		nbTrophee++;
	}
	
	public String extraireInstructionCaml() {
		String cmdCmL="";
		cmdCmL=cmdCmL.concat("let musee = [\n");
		for(int i=0; i<nbTrophee; i++) {
			cmdCmL=cmdCmL.concat("\""+trophees[i].getGaulois().getNom()+"\", \""+trophees[i].getEquipement().toString()+"\"");
			if(i<nbTrophee-1) cmdCmL=cmdCmL.concat(";\n");
		}
		cmdCmL=cmdCmL.concat("\n]");
		return cmdCmL;
	}
}
