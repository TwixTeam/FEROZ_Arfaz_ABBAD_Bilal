package lab2.databaseScript;

import org.apache.log4j.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 
 * db table
 */
public class DbTable {

	private String name;
	private ArrayList<DbColumn> columns;

	public DbTable() {
		this.columns = new ArrayList<>();
	}

	public DbTable(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<DbColumn> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<DbColumn> columns) {
		this.columns = columns;
	}
}