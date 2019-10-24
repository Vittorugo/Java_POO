package heranca_polimorfismo3;

public abstract class Contributor {
	
	private String name;
	private Double annualIncome;
	
	public Contributor() {
		
	}
	
	public Contributor(String name, Double annualIncome) {
		this.name = name;
		this.annualIncome = annualIncome;
	}
	
	
	public abstract double taxCalculation(); 
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}
	
	
	
}
