package isep.lab2.db.script;

import isep.lab2.db.connection.DbConnection;
import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;
import isep.lab2.db.factory.ColumnFactory;
import org.apache.log4j.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;

/** 
 * generate db script
 */
public class GenerateScript {

	private static Logger log = Logger.getLogger(GenerateScript.class);

	private static DatabaseMetaData metadata = null;

	public static void main(String[] args) {

		Connection connection = DbConnection.getInstance();

	   	try{

	      	log.info("Getting MetaData...");
	      	metadata = connection.getMetaData();


	      	ArrayList<DbTable> tables = getTablesName();


			generateDbScript(tables);


	      	connection.close();
	   	} catch(SQLException se){
	   		log.error("SQLException : " + se);

	   	} catch(Exception e){
	   		log.error("Exception : " + e);

		}
	}

	private static ArrayList<DbTable> getTablesName() throws SQLException {
		ResultSet rs;
		ArrayList<DbTable> tables;

		rs = metadata.getTables(null, null, null, new String[] {"TABLE"});
		tables = new ArrayList<>();

		while(rs.next()) {
			DbTable currentTable = new DbTable(rs.getString("TABLE_NAME"));
			getTableColumns(currentTable);

			tables.add(currentTable);
		}

		log.debug("Nb Tables found : " + tables.size());

		rs.close();
		return tables;
	}


	private static void getTableColumns(DbTable table) throws SQLException {
		ResultSet rs;

		rs = metadata.getColumns(null, null, table.getName(), null);

		while (rs.next()) {
			DbColumn c = ColumnFactory.createColumn(table, rs);
		}

		log.debug("Nb Colums found : " + table.getColumns().size());

		if (rs != null) {
			rs.close();
		}
	}

	private static void generateDbScript(ArrayList<DbTable> tables) {
			PrintWriter writer = null;

			try {
				writer = new PrintWriter("generatedDbScript.sql", "UTF-8");
				for (DbTable table : tables) {

					writer.println(table.toSQL());

				}

				log.info("Le fichier generatedDbScript.sql a été créé");

			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				log.debug(e);
			} finally{
				if (writer != null) {
					writer.close();
				}
			}
	}
}