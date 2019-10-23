package enummeracao_composicao2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> listItens = new ArrayList<>();
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		
		listItens.add(item);
	}
	
	public void removeItem(int cod_item) {
		
		OrderItem item = listItens.stream().filter( i -> i.getCod_item() == cod_item).findFirst().orElse(null);
		
		if (item != null) {
			listItens.remove(item);
			System.out.println("Item removido da lista!");
		} else {
			System.out.println("Codígo do item não encontrado!");
		}
	}
	
	
	public Double totalPedido() {
		
		double total = 0;
		
		for (OrderItem i: listItens) {
			total += i.subtotal();
		}
		
		return total;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ORDER SUMMARY:" + "\n");
		sb.append("Order moment: " + dateFormat.format(this.getMoment()) + "\n");
		sb.append("Order statud: " + this.getStatus() + "\n");
		sb.append("Client: " + client.toString() + "\n");
		sb.append("Order items: \n");
		
		for(OrderItem i: listItens) {
			sb.append( i.getProduto().getName() + ", $" + String.format("%.2f", i.getPrice()) + ", Quantity: " + i.getQuantity() + ", Subtotal: $" + String.format("%.2f", i.subtotal()) + "\n");
		}
		
		sb.append("Total price: $" + String.format("%.2f", this.totalPedido()));
		
		return sb.toString();
	}
	
	//Getters and Setters ...
	
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Date getMoment() {
		return moment;
	}
	
	
	
	
	
}
