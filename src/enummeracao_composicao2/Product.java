package enummeracao_composicao2;

public class Product {
	
	private Integer cod_product;
	private String name;
	private Double price;
	
	public Product(Integer cod_product, String name, Double price) {
	
		this.cod_product = cod_product;
		this.name = name;
		this.price = price;
	}
	
	
	// Getters and Setters 
	
	public Integer getCod_product() {
		return cod_product;
	}

	public void setCod_product(Integer cod_product) {
		this.cod_product = cod_product;
	}

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
