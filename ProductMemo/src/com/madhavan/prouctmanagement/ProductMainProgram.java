package com.madhavan.prouctmanagement;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductMainProgram {

	public static void menu() {
		System.out.println("1.Add Product");
		System.out.println("2.View Product");
		System.out.println("3.Update Product");
		System.out.println("4.Remove Product");
		System.out.println("5.Exit ");

		System.out.print("Your choice  : ");

	}

	public static void main(String[] args) throws SQLException {

		CrudOperation crudOperation = new CrudOperation();
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------Proudct Management--------");
		int choice;

		while (true) {

			menu();
			choice = scanner.nextInt();
			if (choice == 1) {
				Product product = new Product();

				System.out.print("Enter Prouct Id : ");
				product.setId(scanner.nextInt());

				System.out.print("Enter Product name : ");
				product.setName(scanner.next());

				System.out.print("Enter Prouct Price : ");
				product.setPrice(scanner.nextInt());

				System.out.println(crudOperation.add(product));

			}

			else if (choice == 2) {
				System.out.println("Enter the Product Id to view  : ");
				int id = scanner.nextInt();

				System.out.println(crudOperation.view(id));

			} else if (choice == 3) {

				System.out.println("Enter Product id : ");
				int id = scanner.nextInt();

				System.out.println("Enter  New name : ");
				String name = scanner.next();

				System.out.println("Enter  New price :");
				int price = scanner.nextInt();
				System.out.println(crudOperation.modify(id, price, name));

			} else if (choice == 4) {
				System.out.println("Enter the Product Id to Delete  : ");
				int id = scanner.nextInt();

				System.out.println(crudOperation.remove(id));

			}

			else
				break;

		}
		scanner.close();
	}

}
