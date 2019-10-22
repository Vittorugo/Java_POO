package enumeracao_composicao;

import java.util.ArrayList;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker( String name, WorkerLevel level, Double baseSalary) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
	}
	
	
	// Methods 
	
	public void addContract( HourContract contract) {
		
		contracts.add(contract);
		
	}
	
	public void removeContract( Integer id) {
		
		
		HourContract removeContract = contracts.stream().filter( c -> c.getId() == id).findFirst().orElse(null);
		
		
		if ( removeContract != null) {
			contracts.remove(removeContract);
			System.out.println("Contrato removido!");
		
		} else {
			System.out.println("Id de contrato não encontrado!");
		}
			
	}
	
	
	// Getters and Setters 
	
	public String getName() {
		return this.name;
	}
	
	public WorkerLevel getLevel() {
		return this.level;
	}
	
	public Double getSalary() {
		return this.baseSalary;
	}
	
	
	public void setName(String newName) {
		this.name = newName;
	}
	
}
