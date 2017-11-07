package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Request
 */
public class SimpleQuery {

	protected static Logger log = Logger.getLogger(SimpleQuery.class);

	public static void main(String[] args) {

		Connection conn = DbConnection.getInstance();
	   	Statement stmt = null;

	   	try{
	      	log.info("Creating statement...");

	      	stmt = conn.createStatement();
	      	String sql = "SELECT last_name FROM actor";

	      	log.debug("Executing statement: " + sql);
	      	ResultSet rs = stmt.executeQuery(sql);

	      	while(rs.next()){

	         	String last = rs.getString("last_name");
	         	System.out.println("Last name: " + last);
	      	}
	      
	      	log.info("End of the request...");

	      	rs.close();
	      	stmt.close();
	      	conn.close();
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		}
	}
}
