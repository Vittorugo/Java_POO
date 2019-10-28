package excecoes2;

public class Account {
	
	private Integer number;
	private String  holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	// Methods
	
	public void deposit(Double value) {
		this.balance += value;
	}
	
	public void withdraw(Double value) throws WithDrawlException {
		
		if (value > this.withdrawLimit) {
			throw new WithDrawlException("Error removing. Your withdrawal limit is R$ " + String.format("%.2f", this.withdrawLimit) + ".");
		}
		
		if (value > this.balance) {
			throw new WithDrawlException("Insufficient funds!");
		}
		
	}
	
	
	// Getters and setters 
	
	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	
}
