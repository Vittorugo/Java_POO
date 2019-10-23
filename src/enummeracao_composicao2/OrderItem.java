package enummeracao_composicao2;

public class OrderItem {
	
	private Integer cod_item;
	private Integer quantity;
	private Double price;
	
	private Product produto;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Integer quantity, Product produto) {
		
		this.cod_item = produto.getCod_product();
		this.quantity = quantity;
		this.price = produto.getPrice();
		this.produto = produto;
	}
	
	public Double subtotal() {
		
		return this.quantity * this.price;
	}
	
	// Getters and Setters 

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduto() {
		return produto;
	}

	public Integer getCod_item() {
		return cod_item;
	}
	
	
}
