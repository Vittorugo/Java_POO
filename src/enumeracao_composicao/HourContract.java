package enumeracao_composicao;

import java.util.Date;

public class HourContract {
	
	private Integer id;
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	
	public HourContract(Integer Id, Date date, Double valueHour, Integer hours) {
		this.id = Id;
		this.date = date;
		this.valuePerHour = valueHour;
		this.hours = hours;
	}
	
	
	public double totalValue() {
		return this.valuePerHour * this.hours;
	}
	
	
	// Gettes and Setters ...
	
	public Integer getId() {
		return this.id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Integer getHours() {
		return this.getHours();
	}
	
	public Double getValueHour() {
		return this.valuePerHour;
	}
}
