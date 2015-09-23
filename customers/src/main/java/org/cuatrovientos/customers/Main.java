package org.cuatrovientos.customers;

import java.sql.SQLException;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	Scanner reader = new Scanner(System.in);
    	int option = 0;
    	Bd bd = new Bd();
    	do{
			showMenu();
			option = getOption(reader);
			doAction(reader, option, bd);
    	}while (option!=6);
    	
    }

	private static void showMenu() {
		System.out.println("1. Show all customer");
		System.out.println("2. Add customer");
		System.out.println("3. Modify costumer");
		System.out.println("4. Delete one customer");
		System.out.println("5. Delete all customer");
		System.out.println("6. Exit");
		System.out.print("Option:");
	}
	/**
	 * @param scanner
	 * @return
	 */
	private static int getOption(Scanner scanner) {
		String line;
		int option;
		line = scanner.nextLine();
		option = Integer.parseInt(line);
		return option;
	}


	private static void doAction(Scanner reader, int option, Bd bd) throws SQLException {
		String name = "";
		int id = 0;
		switch(option){
		case 1:
			System.out.println("+++CUSTOMER LIST+++");
			bd.showAll();
			break;
		case 2:
			System.out.println("+++ADD A COSTUMER+++");
			id = insertId(reader);
			name = insertName(reader);
			Customer c = new Customer(id,name);
			bd.addCostumer(c);
			break;
		case 3:
			System.out.println("+++MODIFY A COSTUMER+++");
			id = insertId(reader);
			name = insertName(reader);
			bd.modifyCostumer(id, name);
			break;
		case 4:
			System.out.println("+++DELETE A COSTUMER+++");
			id = insertId(reader);
			System.out.println("+++DELETE A CUSTOMER+++");
			bd.deleteCustomer(id);
			System.out.println("---CUSTOMER DELETED---");
			break;
		case 5:
			System.out.println("---ALL CUSTOMER DELETED---");
			bd.deleteAll();
			break;
		default:
			System.out.println("---BD DISCONNECTED---");
			bd.closeBD();
			break;
}
    }

	private static String insertName(Scanner reader) {
		String name;
		System.out.println("Please add a customer´s name");
		name = reader.nextLine();
		return name;
	}

	private static int insertId(Scanner reader) {
		int id;
		System.out.println("Please insert custormer's id ");
		id= Integer.parseInt(reader.nextLine());
		return id;
	}
}
