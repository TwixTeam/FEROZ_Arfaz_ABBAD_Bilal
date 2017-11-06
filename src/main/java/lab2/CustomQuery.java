package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Request
 */
public class CustomQuery {

	protected static Logger log = Logger.getLogger(CustomQuery.class);

	private static String jdbc_driver = "";  
	private static String db_url = "";

	//  Database credentials
	private static String user = "";
	private static String pass = "";

	private static String sql_request = "";

	public static void main(String[] args) {
		
		try{
			if(args.length < 5) {
				log.debug("Nb of arguments : " + args.length);
				throw new Exception("Missing arguments \n"
									+ "the right command is : mvn exec:java@customQuery \"url\" \"driver\" \"user\" \"password\"");
			}

			else {

				db_url = args[0].toString();
				jdbc_driver = args[1].toString();

				user = args[2].toString();
				pass = args[3].toString();

				sql_request = args[4].toString();
			}

			Connection conn = null;
		   	Statement stmt = null;

	   		//Class.forName(jdbc_driver);

	    	log.info("Connecting to database : " + db_url + " as : " + user);
	      	conn = DriverManager.getConnection(db_url,user,pass);
	      	log.info("Connection : SUCCESS !");

	      	log.info("Creating statement...");

	      	stmt = conn.createStatement();

	      	log.debug("Executing statement: " + sql_request);
	      	ResultSet rs = stmt.executeQuery(sql_request);

	      	ResultSetMetaData rsmd = rs.getMetaData();
	      	int nb_column = rsmd.getColumnCount();

 			for(int i=0; i<nb_column; i++) {
 				System.out.print(rsmd.getColumnName(i) + "\t");
 			}

	      	while(rs.next()){

	         	for(int j=0; j<nb_column; j++) {
 					System.out.print(rs.getString(j) + "\t");
 				}
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
