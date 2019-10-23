package herenca_polimorfismo2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
	
	private Date manufactureDate;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date md) {
		super(name, price);
		this.manufactureDate = md;
	}
	
	// Methods 
	
	@Override
	public final String priceTag() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getName() + "( used ) $ " + String.format("%.2f", this.getPrice()) + " (Manufacture date: " + dateFormat.format(this.getManufactureDate()) + " ) \n");
		
		return sb.toString();
	}
	
	
	// Getters and Setters 

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	
	
}
