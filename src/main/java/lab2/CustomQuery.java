package lab2;

import org.apache.log4j.*;
import java.sql.*;

/** 
 * JDBC Request
 */
public class CustomQuery {

	protected static Logger log = Logger.getLogger(CustomQuery.class);

	private static Connection connection = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static void main(String[] args) {
		
		try{
			if(args.length < 5) {
				log.debug("Nb of arguments : " + args.length);
				throw new Exception("Missing arguments \n"
									+ "the right command is : mvn exec:java@customQuery -Dexec.args=\" \'url\' \'driver\' \'user\' \'password\' \'request\' \" ");
			}

			else {
				connection = DbConnection.getInstance(args[0], args[1], args[2], args[3]);
				executeRequest(args[4]);

				displayResult();
				closeConnection();
			}
	      	
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		}
	}

	public static void connectToDatabase(String url, String driver, String user, String pass) throws SQLException {
		Class.forName(driver);

		String password = pass.equals(" ") ? "" : pass;

    	log.info("Connecting to database : " + url + " as : " + user);
      	connection = DriverManager.getConnection(url,user,password);

      	log.info("Connection : SUCCESS !");

	}


	public static void executeRequest(String request) throws SQLException {
		log.info("Creating statement...");
      	stmt = connection.createStatement();

      	log.debug("Executing statement: " + request);
      	rs = stmt.executeQuery(request);
	}


	public static void displayResult() throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
      	int nbColumn = rsmd.getColumnCount();

      	log.debug("Number of Result Columns : " + nbColumn);

		for(int i=1; i<=nbColumn; i++) {
			log.info(rsmd.getColumnName(i) + "\t");
		}

		log.info("\n");

      	while(rs.next()){

         	for(int j=1; j<=nbColumn; j++) {
				log.info(rs.getString(j) + "\t");
			}

			System.out.println();
      	}
      
      	log.info("End of the request...");
	}


	public static void closeConnection() throws SQLException {
		rs.close();
      	stmt.close();
      	connection.close();
	}
}
