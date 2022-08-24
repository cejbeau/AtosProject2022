package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;



public class CRUDqueries {
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public CRUDqueries() {
        try {
            conn = DriverManager.getConnection(databaseconnectionjava.URL, databaseconnectionjava.USER, databaseconnectionjava.PASS);
            stmt = conn.createStatement();// create a statement object to execute sql queries
            System.out.println("Connection Successful!");
        } catch (SQLException e) {
            System.out.println("Incorrect credentials");
            e.printStackTrace();
        }
    }

    
    public Game create(Game g) {
    	String createStmt = "INSERT INTO product_inventory(game_name, game_description, price) Values('" + g.getName() + "', '" + g.getDescription() + "', " + g.getPrice() + ");";
		try {
			stmt.executeUpdate(createStmt);
			System.out.println("Create statement executed");
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
    	return g;
    }
    
    public Game read () {
		String readStmt = "SELECT * FROM product_inventory";
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id"));
				System.out.println("Game: " + rs.getString("game_name"));
				System.out.println("Description: " + rs.getString("game_description"));
				System.out.println("Price: " + rs.getInt("price"));
			}

		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
		}
		return null;
	
    }
    
		public void update(int id, String updateVal) {
			String updateStmt = "UPDATE product_inventory SET game_name = '" + updateVal + "' WHERE id = " + id + ";";
			try {
				stmt.executeUpdate(updateStmt);
				System.out.println("Update statement executed");
				
			}catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}

		}
		
		public void delete(int id) {
			String delStmt = "DELETE FROM product_inventory WHERE id= " + id +  "; ";
			try {
				stmt.executeUpdate(delStmt);
				System.out.println("Delete statement executed");
			} catch (SQLException e) {
				System.out.println("Bad query");
				e.printStackTrace();
			}
			
		}
			
			public void closeConn() {
				try {
					conn.close();
					System.out.println("Closed!");
				} catch (SQLException e) {
					System.out.println("Closing connection...");
					e.printStackTrace();
				}
			}
}
