package manipulacao_pastas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Scanner;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class Main {

	public static void main(String[] args) {

		// File file = new File("C:\\Users\\hugo\\Desktop\\pedidos.csv");
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);

		OrderProduct products = new OrderProduct();

		String pathString = "C:\\Users\\hugo\\Desktop";
		File path = new File(pathString);

		System.out.print("Enter client name: ");
		String name = input.nextLine();
		System.out.print("Enter client CPF: ");
		int cpf = input.nextInt();

		try {

			System.out.print("How many products do you want to register? ");
			input.nextLine();
			int num = input.nextInt();

			for (int i = 0; i < num; i++) {

				System.out.println();
				System.out.printf("------- PRODUCT #%d -----------%n", i + 1);

				System.out.print("Enter product name: ");
				input.nextLine();
				String nameProduct = input.nextLine();

				System.out.print("Enter product price: ");
				double priceProduct = input.nextDouble();

				System.out.print("Enter product quantity: ");
				int quantProduct = input.nextInt();

				products.addProduct(new Product(i + 1, nameProduct, priceProduct, quantProduct));
			}

			System.out.println();
			System.out.print("Enter file name to store orders: ");
			input.nextLine();
			String targetFile = pathString + "\\" + input.nextLine() + ".csv"; // criando um arquivo .csv na pasta de
																				// destino.

			/*Writer writer = Files.newBufferedWriter(Paths.get(targetFile));
			StatefulBeanToCsv<Product> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

			beanToCsv.write();

			writer.flush();
			writer.close();
			 */
			
			try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(targetFile, true))) {

				bWriter.write("NomeProduto, Preço, Quantidade");

				for (Product p : products.getItemList()) {
					bWriter.write(
							p.getNameProduct() + "," + String.format("%.2f", p.getPrice()) + "," + p.getQuantity());
					bWriter.newLine();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println();

			for (Product p : products.getItemList()) {
				System.out.println(p.toString());
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		input.close();
	}

}
