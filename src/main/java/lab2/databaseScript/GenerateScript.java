package lab2.databaseScript;

import lab2.db.connection.DbConnection;
import lab2.db.entity.DbColumn;
import lab2.db.entity.DbTable;
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

			getTableColumns(tables);

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
			tables.add(new DbTable(rs.getString("TABLE_NAME")));
		}

		log.debug("Nb Tables found : " + tables.size());
		rs.close();
		return tables;
	}
	

	private static void getTableColumns(ArrayList<DbTable> tables) throws SQLException {
		ResultSet rs = null;
		ArrayList<DbColumn> columns = new ArrayList<>();

		for(DbTable currentTable : tables) {
			rs = metadata.getColumns(null, null, currentTable.getName(), null);

			while (rs.next()) {
				DbColumn c = new DbColumn();
				c.setType(rs.getString("TYPE_NAME"));
				c.setName(rs.getString("COLUMN_NAME"));

				if(rs.getString("COLUMN_SIZE") != null) {
					c.setLength(Integer.parseInt(rs.getString("COLUMN_SIZE")));
				}

				c.setDefaultValue(rs.getString("COLUMN_DEF"));
				c.setAutoIncrement(rs.getString("IS_AUTOINCREMENT").equals("YES"));
				c.setNullable(rs.getString("IS_NULLABLE").equals("YES"));

				currentTable.getColumns().add(c);
				columns.add(c);
			}
		}
		

		log.debug("Nb Colums found : " + columns.size());

		if (rs != null) {
			rs.close();
		}
	}

	private static void generateDbScript(ArrayList<DbTable> tables) {
			PrintWriter writer = null;

			try {
				writer = new PrintWriter("generatedDbScript.sql", "UTF-8");
				for (DbTable table : tables) {

					writer.println("CREATE TABLE '" + table.getName() + "' (");

					for (DbColumn column : table.getColumns()) {
						String autoIncr = column.isAutoIncrement() ? "AUTO_INCREMENT" : "";
						String unsigned = column.getType().split(" ").length > 1 ? "UNSIGNED" : "";
						String nullable = column.isNullable() ? "" : "NOT NULL";
						String defaultVal = column.getDefaultValue() == null ? "" :  "DEFAULT " +  column.getDefaultValue();

						writer.println("'" + column.getName() + "' " + column.getType().split(" ")[0]
								+ "(" + column.getLength() + ") " + unsigned + " " + nullable + " " + defaultVal + " "
								+ autoIncr
						);
					}

					writer.println(");\n");
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