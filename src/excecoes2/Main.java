package excecoes2;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = input.nextInt();
			System.out.print("Holder: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Initial balance: ");
			double balance = input.nextDouble();
			System.out.print("Withdrawl Limit: ");
			double withdrawlimit = input.nextDouble();
			
			Account account = new Account(number, name, balance, withdrawlimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double withdrawlValue = input.nextDouble();
			
			account.withdraw(withdrawlValue);
			
			System.out.print("New Balance: " + (account.getBalance() - withdrawlValue));
			
		} catch (WithDrawlException e) {
			System.out.print("Error exception: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
		
		input.close();

	}

}
