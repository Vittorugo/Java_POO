package herenca_polimorfismo2;

public class ImportedProduct extends Product {
	
	private Double customFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double cfee) {
		super(name, price);
		this.customFee = cfee;
	}
	
	// Methods
	
	public Double totalPrice() {
		return this.getPrice() + this.getCustomFee();
	}
	
	@Override
	public final String priceTag() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getName() + " $ " + String.format("%.2f", this.getPrice()) + " (Customs fee: $ " + this.getCustomFee() + " ) \n");
		
		return sb.toString();
	}
	
	
	// Getters and Setters 
	
	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	
	
	
}
