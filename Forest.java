
public class Forest {
	public int trees;
	public int acres;
	public double treesPerAcre;
	public double pollution;
	public Wildlife wildlife;
	
	/**
	 * Forest constructor. Instantiates a Wildlife object for the forest.
	 */
	public Forest() {
		this.trees = 5000;
		this.acres = 100;
		this.treesPerAcre = trees/acres;
		wildlife = new Wildlife(trees, acres, treesPerAcre);
	}
	/**
	 * Demolishes entered number of acres of trees, and updates Wildlife accordingly.
	 * @param numOfAcres
	 */
	public void demolishAcres(int numOfAcres) {
		acres = acres - numOfAcres;
		trees = (int) (trees- (treesPerAcre * numOfAcres));
		wildlife.updateWildlife(trees, acres);
	}
	/**
	 * Demolishes entered number of trees, and updates Wildlife accordingly.
	 * @param numOfTrees
	 */
	public void demolishTrees(int numOfTrees) {
		trees = trees-numOfTrees;
		treesPerAcre = trees/acres;
		wildlife.updateWildlife(trees, acres);
	}
	public void plantTrees(int numOfTrees) {
		trees = trees+numOfTrees;
		treesPerAcre = trees/acres;
		wildlife.updateWildlife(trees, acres);
	}
	public void plantAcres(int numOfAcres, double treesPerAcre) {
		acres = acres + numOfAcres;
		trees = (int) (trees + (treesPerAcre * numOfAcres));
		this.treesPerAcre = trees/acres;
		wildlife.updateWildlife(trees, acres);
	}
	public void printWildlifeReport() {
		wildlife.printWildlifeReport();
	}
}
