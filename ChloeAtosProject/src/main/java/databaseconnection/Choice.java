package databaseconnection;

import java.util.Scanner;

public class Choice {

	private static Scanner sc = new Scanner(System.in);
	private Game read;

	public String getInput() {
		System.out.println("Enter CRUD choice: ");
		return sc.nextLine();
	}

	public void options() {
		// create an instance of the CRUD queries class to open the connection
		CRUDqueries q = new CRUDqueries();

		// Ask for user input on the CRUD choice in the getInput method and store the
		// result in the crud variable
		String crud = getInput();

		// try-finally block so the finally block can close the connection
		try {
			// do-while loop to start the loop and present the options to interact with the
			// database
			do {
				// switch case to match which CRUD operation to perform
				switch (crud.toLowerCase()) {
				case "create":
					Game g = new Game();
					System.out.println("enter game name");
					String input = sc.nextLine();
					g.setName(input);
					System.out.println("enter game description");
					input = sc.nextLine();
					g.setDescription(input);
					System.out.println("enter game price");
					int x = sc.nextInt();
					sc.nextLine();
					g.setPrice(x);
					q.create(g);
					System.out.print(g.getName());
					break;
			
				case "read":
					q.read();
					break;

				case "update":
					System.out.println("Enter id of record to update: ");
					int uid = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the new name of the game: ");
					String nName = sc.nextLine();
					q.update(uid, nName);					
					break;			
			
				case "delete":
					System.out.println("Enter id of record to delete: ");
					int id = sc.nextInt();
					sc.nextLine();//capture enter key
					q.delete(id);
					break;
				
				default:
					System.out.println("Invalid CRUD choice");
				}
				// check if user wants to continue or break out of the loop
				System.out.println("Would you like to continue? (y/n)");
				String quit = sc.nextLine();
				if (quit.toLowerCase().equals("y")) {
					crud = getInput();
				} else if (quit.toLowerCase().equals("n")) {
					crud = "quit";
				} else {
					System.out.println("Please enter 'y' or 'n'");
				}

			} while (!crud.equals("quit"));
			System.out.println("Goodbye!");
		} finally {
		//	q.closeConn();
		}
	}

}
