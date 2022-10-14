package histoire;

import personnages.*;


public class Scenario {

	public static void main(String[] args) {
		 Gaulois asterix =new Gaulois("Asterix", 8);
		 Gaulois obelix = new Gaulois("Obelix",50);
		 Romain minus = new Romain("Minus ",6);
		 Druide panoramix= new Druide("panoramix",5,10);
		 panoramix.parler("Je vais preparer un potion");
		 panoramix.preparerPotion();
		 panoramix.booster(obelix);
		 panoramix.booster(asterix);
		 minus.parler("UN GAU GAU");
		 asterix.frapper(minus);
	}
	
}
