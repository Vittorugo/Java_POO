package manipulacao_pastas;

import java.util.ArrayList;
import java.util.List;

public class OrderProduct {
	
	private Client client;
	private List<Product> itemList = new ArrayList<>();
	
	public OrderProduct() {	
	}
	
	
	// Methods 
	public void addProduct(Product product) {
		itemList.add(product);
	}
	
	public double total() {
		
		double total = 0;
		
		for(Product p: itemList) {
			total += p.getPrice() * p.getQuantity();
		}
		return total;
	}
	
	// Getters and Setters ...
	public Client getClient() {
		return this.client;
	}


	public List<Product> getItemList() {
		return itemList;
	}
	
}
