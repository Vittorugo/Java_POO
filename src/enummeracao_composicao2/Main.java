package enummeracao_composicao2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat dateFormat_birthDate = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client Data:");
		System.out.print("Name: ");
		String nameClient = input.nextLine();
		System.out.print("Email: ");
		String emailClient = input.nextLine();
		System.out.print("Birth date(DD/MM/YYYY): ");
		Date birthdate = dateFormat_birthDate.parse(input.next());
		
		Client client = new Client(nameClient, emailClient, birthdate );
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(input.next());
		

		Order order = new Order(new Date(),  status, client);
		
		System.out.print("How many items to this order? ");
		int num = input.nextInt();
		
		for(int i = 1; i <= num ; i ++) {
			
			input.nextLine();
			
			System.out.printf("Enter #%d item data: %n",i);
			System.out.print("Product name: ");
			String nameProduct = input.nextLine();
			System.out.print("Product price: ");
			double price = input.nextDouble();
			
			Product produto = new Product(i, nameProduct, price);
			
			System.out.print("Quantity: ");
			int quantity = input.nextInt();
		
			
			OrderItem item = new OrderItem(quantity, produto);
			order.addItem(item);
			
			System.out.println();
			
		}
		
		System.out.println(order);
		
		input.close();
	}
	
}
