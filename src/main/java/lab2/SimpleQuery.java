package lab2;

import org.apache.log4j.*;

import java.sql.*;
import java.util.Properties;

/** 
 * JDBC Request
 */
public class SimpleQuery {

	protected static Logger log = Logger.getLogger(SimpleQuery.class);
	protected static Properties p = new Properties();
	
	static final String JDBC_DRIVER = p.getProperty("lab2.jdbc.driver");
	static final String DB_URL = p.getProperty("lab2.db.url");

	public static void main(String[] args) {

		Connection conn = null;
	   	Statement stmt = null;
	   	ResultSet rs = null;
	   	try{
	   		conn = DbConnection.getInstance();
	      	log.info("Creating statement...");

	      	stmt = conn.createStatement();
	      	String sql = "SELECT last_name FROM actor";

	      	log.debug("Executing statement: " + sql);
	      	rs = stmt.executeQuery(sql);

	      	while(rs.next()){

	         	String last = rs.getString("last_name");
	         	log.info("Last name: " + last);
	      	}
	      
	      	log.info("End of the request...");
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		} finally {
	      	try {
	      		rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				log.error(e);
			}
		}
	}
}
