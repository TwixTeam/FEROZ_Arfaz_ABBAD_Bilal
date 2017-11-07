package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * Retrieve table infos
 */
public class DbConnection {

	protected static Logger log = Logger.getLogger(DbConnection.class);

	private static Connection connection = null;

	private DbConnection() {}

	public static Connection getInstance() {
		return getInstance("jdbc:mysql://localhost/sakila", "com.mysql.jdbc.Driver", "root", "");
	}

	public static Connection getInstance(String url, String driver, String user, String pass) {
		
		try{
			Class.forName(driver);

	    	log.info("Connecting to database : " + url + " as : " + user);
	      	connection = DriverManager.getConnection(url,user,pass);
	      	log.info("Connection : SUCCESS !");
		
		} catch(SQLException se) {
			log.error("SQLException : " + se);

		} catch(Exception e) {
			log.error("Exception : " + e);
		}
		
		return connection;
	}
}
