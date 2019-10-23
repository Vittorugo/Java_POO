package heranca_polimorfismo;

public class OutsourcedEmployee extends Employee {

	private Double additionalCharge;
	
	public OutsourcedEmployee() {
		super();
		
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double add) {
		super(name, hours, valuePerHour);
		this.additionalCharge = add;
		
	}

	@Override
	public final Double payment() {
		// TODO Auto-generated method stub
		return super.payment() + (this.additionalCharge * 1.1);
	}

	public Double getAdditionalCharge() {
		return additionalCharge;
	}
	
	
	
}
