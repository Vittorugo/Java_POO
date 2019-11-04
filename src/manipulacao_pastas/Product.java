package manipulacao_pastas;

public class Product {
	
	private int id;
	private String nameProduct;
	private double price;
	private int quantity;
	
	public Product(int id, String nameProduct, double price, int quantity) {
		this.id = id;
		this.nameProduct = nameProduct;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.nameProduct + "\n");
		sb.append("Price: " + this.price + "\n");
		sb.append("Quantity: " + this.quantity + "\n");
		
		return sb.toString();
	}
	
	// Getters and Setters ...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
}
