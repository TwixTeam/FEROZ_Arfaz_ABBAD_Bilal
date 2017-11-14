package isep.lab2.db.query;

import isep.lab2.db.connection.DbConnection;
import org.apache.log4j.*;

import java.sql.*;

/** 
 * JDBC Request
 */
public class SimpleQuery {

	protected static Logger log = Logger.getLogger(SimpleQuery.class);
	
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
	         	System.out.println("Last name: " + last);
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
			} catch (NullPointerException npe) {
				log.error(npe);
			}
		}
	}
}
