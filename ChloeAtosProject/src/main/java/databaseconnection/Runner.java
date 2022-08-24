package databaseconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Runner {
	
	//SQL - Structured Query Language (mysql workbench)
	//Connect to this database to perform CRUD on a table
	
	//JDBC - Java DataBase Connectivity - is an API which allows us to connect to a database from our aJava application
	// - uses drivers to connect to the database and execute queries
	private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.print("hello");
//		try {
//            conn = DriverManager.getConnection(databaseconnectionjava.URL, databaseconnectionjava.USER, databaseconnectionjava.PASS);
//            stmt = conn.createStatement();// create a statement object to execute sql queries
//            System.out.println("Connection Successful!");
//        } catch (SQLException e) {
//            System.out.println("Incorrect credentials");
//            e.printStackTrace();
//        }
		Choice c = new Choice();

c.options();}

}
