package lab2;

import org.apache.log4j.*;
import java.sql.*;
import java.util.Properties;

/** 
 * Retrieve table infos
 */
public class DbConnection {

	protected static Logger log = Logger.getLogger(DbConnection.class);
	protected static Properties p = new Properties();

	private static Connection connection = null;

	private DbConnection() {}

	public static Connection getInstance() {
		return getInstance(p.getProperty("db.url"), p.getProperty("jdbc.driver"), p.getProperty("db.usersame"), p.getProperty("db.password"));
	}

	public static Connection getInstance(String url, String driver, String user, String pass) {
		
		try{
			Class.forName(driver);

			String password = pass.equals(" ") ? "" : pass;

	    	log.info("Connecting to database : " + url + " as : " + user);
	      	connection = DriverManager.getConnection(url,user,password);
	      	log.info("Connection : SUCCESS !");
		
		} catch(SQLException se) {
			log.error("SQLException : " + se);

		} catch(Exception e) {
			log.error("Exception : " + e);
		}
		
		return connection;
	}
}
