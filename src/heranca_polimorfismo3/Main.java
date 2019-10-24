package heranca_polimorfismo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		List<Contributor> listContributor = new ArrayList<>();
		
		System.out.print("Enter the number od tax payers: ");
		int num = input.nextInt();
		
		for ( int i = 1; i <= num; i++) {
			
			input.nextLine();
			
			System.out.printf("Tax payer #%d data:%n",i);
			System.out.print("Individual or company (i/c)? ");
			char check = input.next().charAt(0);
			
			input.nextLine();
			
			System.out.print("Name: ");
			String name = input.nextLine();
			System.out.print("Anual income: ");
			double income = input.nextDouble();
			
			if (check == 'i' || check == 'I') { // se o contribuinte for do tipo pessoa física receba também gastos com saúde.
				
				input.nextLine();
				
				System.out.print("Health expenditures: ");
				double healthExpenditures = input.nextDouble();
				
				listContributor.add(new PhysicalPeson(name, income, healthExpenditures));
			
			} else if (check == 'c' || check == 'C') { // se o contribuinte for do tipo pessoa jurídica receba também número de funcionarios.
				
				input.nextLine();
				
				System.out.print("Number of employees: ");
				int numberEmployees = input.nextInt();
				
				listContributor.add(new LegalPerson(name, income, numberEmployees));
			} 
		}
		
		System.out.println();
		
		// retorna valor de impostos para cada contribuinte
		System.out.println("TAXES PAID: ");
		listContributor.forEach( c -> System.out.println( c.toString()));
		
		input.close();

	}

}
