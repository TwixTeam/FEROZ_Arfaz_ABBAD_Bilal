package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Request
 */
public class App {

	protected static Logger log = Logger.getLogger(App.class);

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/sakila";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection conn = null;
	   	Statement stmt = null;

	   	try{

	    	log.info("Connecting to database...");
	      	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      	log.info("Connected to database !");

	      	log.info("Creating statement...");
	      	stmt = conn.createStatement();
	      	String sql = "SELECT last_name FROM actor";
	      	ResultSet rs = stmt.executeQuery(sql);

	      	log.info(rs);
	      	//STEP 5: Extract data from result set
	      	while(rs.next()){
	         	//Retrieve by column name

	         	String last = rs.getString("last_name");

	         	//Display values
	         	System.out.println("Last name: " + last);
	      	}
	      
	      	//STEP 6: Clean-up environment
	      	rs.close();
	      	stmt.close();
	      	conn.close();
	   	} catch(SQLException se){
	      	se.printStackTrace();
	   	} catch(Exception e){
	      	e.printStackTrace();
		}
	}
}
