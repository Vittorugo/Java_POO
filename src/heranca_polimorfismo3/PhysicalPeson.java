package heranca_polimorfismo3;

public class PhysicalPeson extends Contributor {
	
	
	private Double healthExpenses = 0.0 ;
	
	public PhysicalPeson() {
		super();
	}

	public PhysicalPeson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}
	
	
	
	@Override
	public double taxCalculation() {
		
		double total = 0 ;
		
		if (this.getAnnualIncome() < 20000) {
			
			total = (this.getAnnualIncome() * 0.15) - (this.getHealthExpenses() * 0.5);
		}
		
		else if (this.getAnnualIncome() >= 20000) {
			
			total = (this.getAnnualIncome() * 0.25) - (this.getHealthExpenses() * 0.5);
		}
		
		return total;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getName() + ": $ " + this.taxCalculation());
		
		return sb.toString();
	}
	
	// Getters and Setters 
	
	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}
	
}
