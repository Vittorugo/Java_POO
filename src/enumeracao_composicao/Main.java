package enumeracao_composicao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter departament's name: ");
		Departament departament = new Departament(input.nextLine());
		
		System.out.println("Worker data: ");
		System.out.print("Name: ");
		String name = input.nextLine();
		
		System.out.print("Level: ");
		String level = input.nextLine();
		
		// converter a string em Enum ...
		WorkerLevel l = WorkerLevel.valueOf(level);
		
		System.out.print("Salary base: ");
		Double salary = input.nextDouble();
		
		// instancia do trabalhador 
		Worker worker = new Worker(name, l, salary, departament);
		
		System.out.print("How many contracts to this worker? ");
		int num = input.nextInt();
		
		for ( int i = 0; i < num; i++) {
			
			input.nextLine();
			
			System.out.printf("Enter contract #%d data: %n", i+1);
			System.out.print("Date (DD/MM/YYYY): ");
			String date = input.next();
			System.out.print("Value per hour: ");
			double value = input.nextDouble();
			System.out.print("Contract duration: ");
			int duration = input.nextInt();
			
			// convertendo string em Date ...
			Date dateContract = dateFormat.parse(date);
						
			worker.addContract(new HourContract( (i+1), dateContract, value, duration));
			
			System.out.println();
		}
		
		input.nextLine();
		
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String[] monthYear = input.next().split("/");
		
		int month = Integer.parseInt(monthYear[0]);  
		int year  = Integer.parseInt(monthYear[1]);
		
	
		System.out.printf("Name: %s%n" , worker.getName());
		System.out.printf("Departament: %s%n", worker.getDepartament().getName());
		System.out.printf("Income for %d/%d: %.2f%n", month, year, worker.income(year, month));

		System.out.print("Want to remove contract (y/n)? ");
		char check = input.next().charAt(0);
		
		if ( check == 'y' || check == 'Y') {
			System.out.print("Enter ID contract remove: ");
			worker.removeContract(input.nextInt());
		} else {
			System.out.println("Good-Bye!");
		}
		
				
		input.close();
		
	}

}
