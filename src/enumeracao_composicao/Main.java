package enumeracao_composicao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Scanner input = new Scanner(System.in);
				
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
		Worker worker = new Worker(name, l, salary);
		
		System.out.print("How many contracts to this worker? ");
		int num = input.nextInt();
		
		for ( int i = 0; i < num; i++) {
			
			input.nextLine();
			
			System.out.printf("Enter contract #%d data: ", i+1);
			System.out.print("Date (DD/MM/YYYY): ");
			String date = input.next();
			System.out.print("Value per hour: ");
			double value = input.nextDouble();
			System.out.print("Contract duration: ");
			int duration = input.nextInt();
			
			
			// convertendo string em Date ...
			Date d = dateFormat.parse(date);
			
			worker.addContract(new HourContract( (i+1), d, value, duration));
		}
		
		
		System.out.println("Enter ID contract remove: ");
		worker.removeContract(input.nextInt());
		
		input.close();
		
	}

}
