package lab2;

import org.apache.log4j.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	/**
	 * Connect to the default database
	 */
	public static Connection getInstance() {
		try {
	        p.load(DbConnection.class.getResourceAsStream("/app.properties"));
	    } catch (FileNotFoundException fnfe) {
	        log.error(fnfe);
	    } catch (IOException ioe) {
	    	log.error(ioe);
	    }
		return getInstance(p.getProperty("lab2.db.url"), p.getProperty("lab2.jdbc.driver"), p.getProperty("lab2.db.username"), p.getProperty("lab2.db.password"));
	}
	
	/**
	 * Method to connect to the database
	 * 
	 * @param url URL of the database
	 * @param driver Driver for the database
	 * @param user Username to connect to the database
	 * @param pass Password for the User
	 * 
	 */
	public static Connection getInstance(String url, String driver, String user, String pass) {
		
		connection = null;

		try{
			Class.forName(driver);
			String password = pass.equals(" ") ? "" : pass;
			
	    	log.info("Connecting to database : " + url + " as : " + user);
	      	connection = DriverManager.getConnection(url,user,password);
	      	log.info("Connection : SUCCESS !");
		
		} catch(SQLException se) {
			log.error("SQLException : " + se);

		} catch(ClassNotFoundException cnfe) {
			log.error("ClassNotFoundException : " + cnfe);

		} catch(Exception e) {
			log.error("Exception : " + e);
		}
		
		return connection;
	}
}
