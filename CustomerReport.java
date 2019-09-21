import java.util.ArrayList;
import java.util.Arrays;

public class CustomerReport {
	private ArrayList<String> report;
	int sequence;
	
	public CustomerReport() {
		report = new ArrayList<String>();
	}
	public void releaseEnergyReport(int energyType) {
		if(energyType==0) {
			add("I do not appreciate the company's use of fossil fuels.");
		}
		else if(energyType==1) {
			double num = Math.random();
			if(num%2==0) {
				report.add("I love that the company uses wind power!");
			}
			else {
				add("I appreciate the use of wind power, but what about the birds?");
			}
		}
		else {
			add("It is amazing that this company runs on solar power!");
		}
	}
	public void releaseSewageReport(int sewageType) {
		if (sewageType==0) {
			add("I am outraged the company is pouring their sewage into the lake!");
		}
		else if(sewageType==1) {
			add("");
		}
	}
	public void add(String f) {
		if(sequence==0) {
			sequence++;
		}
		report.add(sequence+". "+f);
		sequence++;
	}
	public void clear(){
		report.clear();
		sequence =0;
	}
	public ArrayList<String> getReport(){
		//String customerReport =Arrays.toString(report.toArray());
		return report;
	}
}
