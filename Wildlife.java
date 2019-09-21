
public class Wildlife{
	int frogs;
	int predatoryMammals;
	int preyMammals;
	int insects;
	int birds;
	int scavengers;
	double wildFireChance;
	int trees;
	int acres;
	double treesPerAcre;
	
	/**
	 * Wildlife constructor that establishes trees and animals in forest.
	 * @param trees
	 * @param acres
	 * @param treesPerAcre
	 */
	public Wildlife(int trees, int acres, double treesPerAcre) {
		this.trees= trees;
		this.acres = acres;
		this.treesPerAcre = treesPerAcre;
		frogs = 5*acres;
		predatoryMammals = (acres/2)-10;
		preyMammals = acres*8;
		insects = acres*1000;
		birds = acres*15;
		scavengers = acres/2;
		wildFireChance = 10;
		zeroCheck();
	}
	/**
	 * Updates wild life based on updated tree statistics.
	 * @param trees
	 * @param acres
	 * @param treesPerAcre
	 */
	public void updateWildlife(int trees, int acres) {
		this.treesPerAcre= trees/acres;
		this.acres= acres;
		if (treesPerAcre<40) {
			frogs= frogs-10;
			predatoryMammals = predatoryMammals- 20;
			insects = insects +(500*acres);
			birds = acres*10;
			scavengers = scavengers - (acres/5);
			wildFireChance-=10;
			zeroCheck();
		}
		else if(treesPerAcre>60) {
			frogs = frogs-10;
			predatoryMammals = predatoryMammals- 20;
			insects = insects +(500*acres);
			preyMammals = preyMammals/2;
			scavengers = scavengers - (acres/5);
			wildFireChance+=10;
			zeroCheck();
		}
	}
	/**
	 * Prints out the number of animals and trees currently in the forest.
	 */
	public void printWildlifeReport() {
		System.out.println("The forest currently has: ");
		System.out.println(frogs+" frogs,");
		System.out.println(predatoryMammals+" predatory mammals,");
		System.out.println(preyMammals+" preyMammals,");
		System.out.println(insects+" insects,");
		System.out.println(birds+" birds,");
		System.out.println(scavengers+" scavengers,");
		System.out.println(trees+" trees,");
		System.out.println(acres+" acres of trees,");
		System.out.println(treesPerAcre+" trees per acre.");
	}
	/**
	 * Checks to ensure that no species of animal has a negative population.
	 */
	//Postcondition: All animal fields are either 0 or positive.
	public boolean zeroCheck() {
		if(frogs<=0) {
			frogs=0;
			return true;
		}
		if(predatoryMammals<=0) {
			predatoryMammals=0;
			return true;
		}
		if(preyMammals<=0) {
			preyMammals=0;
			return true;
		}
		if(insects<=0) {
			insects=0;
			return true;
		}
		if(birds<=0) {
			birds=0;
			return true;
		}
		if(scavengers<=0) {
			scavengers=0;
			return true;
		}
		return false;
	}
	/**
	 * Randomly simulates a wildfire based on the wildFireChance variable, which is
	 * based on years passed as well as the density of the forest. Returns true if 
	 * a wildfire occured.
	 * @return
	 */
	public boolean wildFire() {
		int randomNumber = (int) ((Math.random() * ((100 - 1) + 1)) + 1);
		if (wildFireChance>=randomNumber) {
			frogs = (int)(frogs*0.01*(100-randomNumber));
			predatoryMammals = (int)(predatoryMammals*0.01*(100-randomNumber));
			preyMammals = (int)(preyMammals*0.01*(100-randomNumber));
			insects = (int)(insects*0.01*(100-randomNumber));
			birds = (int)(birds*0.01*(100-randomNumber));
			scavengers = (int)(scavengers*0.01*(100-randomNumber));
			zeroCheck();
			if(randomNumber<40) {
				System.out.println("There was a small wildfire!");
				this.trees -= 400;
				updateWildlife(this.trees, this.acres);
			}
			else if(randomNumber <70) {
				System.out.println("There was a medium-sized wildfire!");
				this.trees -= 700;
				updateWildlife(this.trees, this.acres);
			}
			else {
				System.out.println("There was a large wild fire!");
				this.trees -= 1000;
				updateWildlife(this.trees, this.acres);
			}
			wildFireChance-=10;
			printWildlifeReport();
			return true;
		}
		return false;
	}
	public void yearPass() {
		if(treesPerAcre<60 && treesPerAcre>40) {
			if (frogs<20000) {
				frogs= frogs*2;
			}
			predatoryMammals+=2;
			preyMammals=(int) Math.pow(preyMammals, 1.01);
			insects+=100;
			birds+= 500;
			this.scavengers= this.scavengers +3;
			wildFireChance+=1;
		}
	}
	/*public String wildlifeStatus() {
		int randomNumber = (int) (Math.random());
		if (randomNumber%2==0) {
			if(frogs<500) {
				return "I am concerned about the amphibian life in that company's forest! Shame!";
			}
			else if (predatoryMammals<40) {
				randomNumber = (int) (Math.random());
				if (randomNumber%2==0) {
					return "I am worried about the cougar population in the surrounding area of your company! Do Something!";
				}
				else {
					return "I am upset about the declining wolf population near that company!";
				}
			}
		}
		else if(preyMammals<800) {
			return "I am not thrilled with the upsettingly low rabbit population nearby your company!!";
		}
		else if(birds<1500) {
			return "Boycott this company for low bird populations!";
		}
		
	}*/
	

}
