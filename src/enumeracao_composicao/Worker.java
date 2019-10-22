package enumeracao_composicao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private List<HourContract> contracts = new ArrayList<>();
	private Departament nameDepartament;
	
	public Worker() {
		
	}
	
	public Worker( String name, WorkerLevel level, Double baseSalary, Departament departament) {
		
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.nameDepartament = departament;
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
	
	public Double income(int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		double total = this.baseSalary;
		
		for (HourContract c: contracts) {
			
			cal.setTime(c.getDate());
						
			int monthContract = 1 + cal.get(Calendar.MONTH);
			int yearContract = cal.get(Calendar.YEAR);
						
			if(monthContract == month && yearContract == year) {
				total += c.totalValue();
			}
		}
		
		// HourContract contractMonthYear = contracts.stream().filter( x -> (cal.get(Calendar.MONTH) == month)  && (cal.get(Calendar.YEAR) == year)).findAny().orElse(null);
		// if (contractMonthYear != null){
		// 		total += contractMonthYear.totalValue();
		//}
		return total;
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
	
	public Departament getDepartament() {
		return this.nameDepartament;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
}
