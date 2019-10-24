package heranca_polimorfismo3;

public class LegalPerson extends Contributor {

	private Integer employeeNumber;

	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double annualIncome, Integer number) {
		super(name, annualIncome);
		this.employeeNumber = number;
	}

	@Override
	public double taxCalculation() {

		double total = 0;

		if (this.getEmployeeNumber() > 10) {
			total = this.getAnnualIncome() * 0.14;

		} else {
			total = this.getAnnualIncome() * 0.16;
		}

		return total;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getName() + ": $ " + this.taxCalculation());

		return sb.toString();
	}

	// Getters and Setters

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

}
