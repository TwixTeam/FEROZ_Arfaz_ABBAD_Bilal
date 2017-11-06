package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Connection
 *
 */
public class App {

	protected static Logger log = Logger.getLogger(App.class);

	static final String JDBC_DRIVER = ${jdbc.driver};  
   static final String DB_URL = "jdbc:mysql://localhost/sakila";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";

	public static void main(String[] args) {

		System.out.println("Hello World!");
		log.info("In Main class");
		System.out.println();

		Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      //Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		  //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT last_name FROM actor";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name

	         String last = rs.getString("last_name");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", First name: " + first);
	         System.out.println(", Last name: " + last);
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
		}
	}
}
