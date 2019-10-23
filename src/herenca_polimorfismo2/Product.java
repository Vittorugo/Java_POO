package herenca_polimorfismo2;

public class Product {
	
	private String name;
	private Double price;
	
	public Product() {
		
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	// Methods 
	
	public String priceTag() {
		
		StringBuilder sb = new StringBuilder();
	
		sb.append(this.getName() + " $ " + String.format("%.2f", this.getPrice()) + "\n");
		
		return sb.toString();	
	
	}
	
	
	// Getters and Setters 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
