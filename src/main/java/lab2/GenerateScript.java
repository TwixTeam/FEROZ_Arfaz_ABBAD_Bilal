package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * Retrieve table infos
 */
public class GenerateScript {

	protected static Logger log = Logger.getLogger(GenerateScript.class);

	static Connection connection = null;

	static DatabaseMetaData metadata = null;

	public static void main(String[] args) {

		connection = DbConnection.getInstance();
	   	Statement stmt = null;

	   	try{

	      	log.info("Getting MetaData...");
	      	metadata = connection.getMetaData();



	      	connection.close();
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		}
	}
}
