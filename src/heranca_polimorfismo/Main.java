package heranca_polimorfismo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		List<Employee> listEmployee = new ArrayList<>();

		System.out.print("Enter the number od employess: ");
		int num = input.nextInt();

		for (int i = 1; i <= num; i++) {

			input.nextLine();

			System.out.printf("Employee #%d data: %n", i);
			System.out.print("Outsourced (y/n)? ");
			char check = input.next().charAt(0);

			input.nextLine();

			System.out.print("Name: ");
			String name = input.nextLine();

			System.out.print("Hours: ");
			int hours = input.nextInt();

			System.out.print("Value per hour: ");
			double vh = input.nextDouble();
			
			if (check == 'y' || check == 'Y') {

				System.out.print("Additional charge: ");
				double additional = input.nextDouble();

				Employee emp = new OutsourcedEmployee(name, hours, vh, additional);
				listEmployee.add(emp);

			} else {

				Employee emp = new Employee(name, hours, vh);
				listEmployee.add(emp);
			}

		}
		
		System.out.println();
		System.out.println("Payments: ");
		
		for(Employee e: listEmployee) {
			
			System.out.println(e.getName() + " - " + e.payment());
		}
		
		input.close();

	}

}
