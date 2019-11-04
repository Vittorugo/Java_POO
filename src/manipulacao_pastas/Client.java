package manipulacao_pastas;

public class Client {
	
	private String name;
	private Integer cpf;
	
	public Client() {
	}
	
	public Client(String name, int cpf) {
		this.name = name;
		this.cpf  = cpf;
	}
	
	
	// Getters and Setters 
	
	
	public String getName() {
		return name;
	}


	public Integer getCpf() {
		return cpf;
	}

}
