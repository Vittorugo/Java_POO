package herenca_polimorfismo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> listProducts = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int num = input.nextInt();
		
		for (int i=1; i <= num; i++) {
			
			input.nextLine();
			
			System.out.printf("Product #%d data: %n",i);
			System.out.print("Common, used or imported (c/u/i)? ");
			char check = input.next().charAt(0);
			
			input.nextLine();
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Price: ");
			double price = input.nextInt();
						
			if ( check == 'i' || check == 'I') {
				
				input.nextLine();
				
				System.out.print("Customs fee: ");
				double custom = input.nextDouble();
				
				listProducts.add( new ImportedProduct(name, price, custom));
			}
			
			else if ( check == 'u' || check == 'U') {
				
				input.nextLine();
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = dateFormat.parse(input.next());
				
				listProducts.add( new UsedProduct(name, price, date));
			}
			
			else if (check == 'c' || check == 'C') {
				listProducts.add( new Product(name, price));
			}
				
		}
		
		System.out.println("PRICE TAGS:");
		
		listProducts.forEach( p -> System.out.println(p.priceTag()));
		
		input.close();
		
		
		
	}

}
