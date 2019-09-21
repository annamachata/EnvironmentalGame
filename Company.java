import java.util.ArrayList;

public class Company {
	private double satisfaction;
	private double funds;
	private double yearlyRevenue;
	private double revenue;
	public int companyAge;
	public int customers;
	
	CustomerReport customerReport;
	
	/**
	 * Constructor that establishes satisfaction rating, funds, company age, and yearly revenue.
	 */
	public Company() {
		customerReport = new CustomerReport();
		satisfaction = 0.5;
		funds = 50000;
		revenue = 20000;
		companyAge =0;
		customers = 10000;
	}
	/**
	 * Returns company funds.
	 * @return
	 */
	public double getFunds() {
		return funds;
	}
	/**
	 * Returns satisfaction rating out of 100.
	 * @return
	 */
	public double getSatisfaction() {
		return satisfaction;
	}
	/**
	 * Returns yearly revenue.
	 * @return
	 */
	public double getYearlyRevenue() {
		yearlyRevenue = Math.pow(revenue*customers*satisfaction, 0.5);
		return yearlyRevenue;
	}
	public double getRevenue() {
		return revenue;
	}
	/**
	 * Adjusts satisfaction by entered double percent. For example,
	 * entering 1.2 would increase satisfaction by 20%.
	 * @param percent
	 */
	public void setSatisfaction(double percent) {
		satisfaction = satisfaction*percent;
	}
	/**
	 * Adds inputed amount to company funds. Spends money if value passed is negative,
	 * gains money if value passed is positive.
	 * @param amount
	 */
	public void spendMake(int amount) {
		funds+=amount;
	}
	public String adjustRevenue(double change) {
		revenue+=change;
		getYearlyRevenue();
		return "The new revenue after the change is "+ revenue+". The net income is "+yearlyRevenue;
	}
	/**
	 * Processes one year in the company.
	 */
	public void yearPass() {
		getYearlyRevenue();
		funds+=yearlyRevenue;
		companyAge++;
	}
	/**
	 * Returns customer report as a String value, as well as clearing the report in 
	 * the customer report object.
	 * @return
	 */
	public void printCustomerReport() {
		String[] report = (customerReport.getReport().toArray(new String[customerReport.getReport().size()]));
		for(int i=0; i<report.length; i++) {
			System.out.println(report[i]);
		}
		customerReport.clear();
	}
	/**
	 * Returns a String value of the company.
	 */
	public String toString() {
		return "The yearly net income is $"+getYearlyRevenue()+". \nCurrent company funds is $"+ funds+"\n"+"Customer satisfaction is currently at "+satisfaction+"/1.0. \nCompany currently has "+customers+" customers. \nThe company is "+companyAge+" years old.";
	}
	
}
