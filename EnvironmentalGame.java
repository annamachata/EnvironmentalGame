import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EnvironmentalGame {
	static Forest forest;
	static Company company;
	static int year;
	static int energyType;
	static int energyCostPerYear;
	static int sewageType;
	static int sewageCostPerYear;
	static double yearlyIncreaseInSatisfaction;
	public static void main(String[] args) {
		forest = new Forest();
		company = new Company();
		energyCostPerYear = -5000;//accounts for starting use of fossil fuels
		company.adjustRevenue(energyCostPerYear);//accounts for starting use of fossil fuels
		company.setSatisfaction(0.8);//accounts for starting use of fossil fuels
		company.setSatisfaction(0.5);//accounts for starting use of dumping sewage into a pond
		System.out.println("Welcome to the environmental business simulator.");
		System.out.println("You will make a series of business decisions in order for your company and the environment to survive the best possible.");
		System.out.println("The goal is to get your company to 90% satisfaction, while maintaining the environment at 70% satisfaction, and your funds above $0.");
		System.out.println("Your current company satisfaction rating is:" +company.getSatisfaction()+"%");
		System.out.println("Let's make a move:");
		boolean win = false;
		boolean lose = false;
		while(win==false && lose==false) {
			boolean continueTurn = true;
			while(continueTurn ==true) {
				playTurn();
				boolean error = true;
				while (error == true) {
					System.out.println("Make another move (type 'a'), or advance a year? (type 'b')");
					Scanner scan = new Scanner(System.in);
					String choice = scan.next();
					if(choice.equalsIgnoreCase("a")) {
						continueTurn=true;
						error= false;
					}
					else if(choice.equalsIgnoreCase("b")) {
						continueTurn= false;
						error = false;
					}
					else {
						error=true;
						System.out.println("Invalid input. Please try again.");
					}
				}
		
			}
			win = checkWin();
			lose = checkLose();

		}
		if(win == true) {
			System.out.println("Congrats! You have won the game!");
			System.out.println(company);
			forest.printWildlifeReport();
		}
		else if (lose==true){
			System.out.println("Sorry! You have lost the game...");
			System.out.println(company);
			forest.printWildlifeReport();
		}
	}
	/**
	 * Simulates one turn in gameplay.
	 */
	public static void playTurn() {
		boolean error = true;
		while (error==true){
			System.out.println("Choose one (Type a 1-Letter Answer): ");
			System.out.println("A. Check Company Statistics");
			System.out.println("B. Check Environment Statistics");
			System.out.println("C. Make Executive Decisions");
			System.out.println("D. Make Environmental Decisions");
			Scanner scan = new Scanner(System.in);
			String choice = scan.next();
			if(choice.equalsIgnoreCase("a")) {
				error = false;
				System.out.println(company.toString());
			}
			else if(choice.equalsIgnoreCase("b")) {
				forest.printWildlifeReport();
				error= false;
			}
			else if(choice.equalsIgnoreCase("c")) {
				error= false;
				makeExecutiveDecisions();
			}
			else if(choice.equalsIgnoreCase("d")) {
				error = false;
				//makeEnvironmentalDecisions();
			}
			else {
				System.out.println("error in input. please try again.");
			}
		}
	}
	/**
	 * Provides options to make an executive decision, or return to the previous
	 * menu.
	 */
	public static boolean makeExecutiveDecisions() {
		boolean error = true;
		while (error==true){
			System.out.println("Choose one (Type a 1-Letter Answer): ");
			System.out.println("A. Energy Options");
			System.out.println("B. Sewage Options");
			System.out.println("C. Expansion Options");
			System.out.println("D. Other Options");
			System.out.println("E. Back");
			Scanner scan = new Scanner(System.in);
			String choice = scan.next();
			if(choice.equalsIgnoreCase("a")) {
				error = false;
				energyOptions();
			}
			else if(choice.equalsIgnoreCase("b")) {
				error = false;
				sewageOptions();
			}
			else if(choice.equalsIgnoreCase("c")) {
				error = false;
				//expansionOptions();
			}
			else if(choice.equalsIgnoreCase("d")) {
				error = false;
				//otherOptions();
			}
			else if(choice.equalsIgnoreCase("e")) {
				error = false;
			}
			else {
				System.out.println("error in input. please try again.");
			}
		}
		return true;
		
	}
	/**
	 * Changes energy type to entered input.
	 */
	public static boolean energyOptions() {
		boolean error = true;
		while (error==true){
			System.out.println("You currently have $"+company.getFunds()+" in company funds.");
			System.out.println("Choose one (Type a 1-Letter Answer): ");
			System.out.println("A. Convert to Fossil Fuel Energy (cost: +30000, -$5000 per year)");
				if(energyType==0) {
					System.out.println("<currently activated>");
				}
			System.out.println("B. Convert to Wind Energy (cost: -30000, -$2000 per year)");
				if(energyType==1) {
					System.out.println("<currently activated>");
				}
			System.out.println("C. Convert to Solar Energy (cost: -50000, -$0 per year");
				if(energyType==2) {
					System.out.println("<currently activated>");
				}
			System.out.println("D. Back");
			Scanner scan = new Scanner(System.in);
			String choice = scan.next();
			if(choice.equalsIgnoreCase("a") && energyType!=0) {
				energyType=0;
				company.adjustRevenue(energyCostPerYear*-1);//removes original cost of energy from budget
				energyCostPerYear = -5000;
				company.adjustRevenue(energyCostPerYear);
				company.setSatisfaction(0.8);
				error=false;
			}
			else if(choice.equalsIgnoreCase("b") && energyType!=1) {
				energyType=1;
				company.spendMake(-30000);
				company.adjustRevenue(energyCostPerYear*-1);//removes original cost of energy from budget
				energyCostPerYear = -2000;
				company.adjustRevenue(energyCostPerYear);
				error=false;
				company.setSatisfaction(1.1);
			}
			else if(choice.equalsIgnoreCase("c") && energyType !=2) {
				energyType = 2;
				company.spendMake(-50000);
				company.adjustRevenue(energyCostPerYear*-1);//removes original cost of energy from budget
				energyCostPerYear =0;
				company.adjustRevenue(energyCostPerYear);
				error=false;
				company.setSatisfaction(1.2);
			}
			else if(choice.equalsIgnoreCase("d")) {
				error=false;
			}
			else {
				System.out.println("error in input. please try again.");
			}
		}
		return true;
	}
	public static boolean sewageOptions() {
		System.out.println("Choose one (Type a 1-Letter Answer): ");
		System.out.println("A. Sewage Directly Into Forest Lake (cost: 0, cost per year: 0)");
		if(sewageType==0) {
			System.out.println("<currently activated>");
		}
		System.out.println("B. Implement Sewer System (cost: -40000, cost per year -7000)");
		if(sewageType==1) {
			System.out.println("<currently activated>");
		}
		System.out.println("C. Use Eco-Friendly Water Treatment Plant (cost: -60000, cost per year -1000");
		if(sewageType==2) {
			System.out.println("<currently activated>");
		}
		System.out.println("D. Back");
		Scanner scan = new Scanner(System.in);
		String choice = scan.next();
		boolean error = true;
		while (error==true) {
			if(choice.equalsIgnoreCase("a")) {
				error = false;
				sewageType=0;
				company.adjustRevenue(energyCostPerYear*-1);//removes original cost of sewage
				sewageCostPerYear =0;
				company.setSatisfaction(0.5);
			}
			else if(choice.equalsIgnoreCase("b")) {
				error = false;
				sewageType=1;
				company.spendMake(-40000);
				company.adjustRevenue(sewageCostPerYear*-1);//removes original cost of sewage
				sewageCostPerYear =-7000;
				company.adjustRevenue(sewageCostPerYear);
				company.setSatisfaction(1.1);
				
			}
			else if(choice.equalsIgnoreCase("c")) {
				sewageType=2;
				company.spendMake(-60000);
				company.adjustRevenue(sewageCostPerYear*-1);//removes original cost of sewage
				sewageCostPerYear =-1000;
				company.adjustRevenue(sewageCostPerYear);
				company.setSatisfaction(1.4);
			}
			else if(choice.equalsIgnoreCase("d")) {
				error = false;
			}
			else {
				System.out.println("error in input. please try again.");
			}
		}
		return true;
	}
	public static void makeEnvironmentalDecisions() {
		
	}
	public static void yearPass() {
		company.customerReport.releaseEnergyReport(energyType);
		company.customerReport.releaseSewageReport(sewageType);
		System.out.println("Year has passed. Your customer report for this year is:");
		company.printCustomerReport();
		forest.wildlife.yearPass();
		company.yearPass();
		System.out.println(company.toString());
		forest.printWildlifeReport();
	}
	/**
	 * Returns true if one of the winning conditions (100% satisfaction, 100 year old company,
	 * $1,000,000 in funds) are true.
	 * @return
	 */
	public static boolean checkWin() {
		if(company.getSatisfaction()==1.0 || company.getFunds()==1000000 || company.companyAge==100) {
			return true;
		}
		return false;
	}
	public static boolean checkLose() {
		if(forest.wildlife.zeroCheck()==true || company.getFunds()<=0 || company.getSatisfaction()==0.0) {
			return true;
		}
		return false;
	}
	
}
