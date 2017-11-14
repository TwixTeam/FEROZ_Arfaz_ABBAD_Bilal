package isep.lab2.db.entity;

import isep.lab2.db.entity.DbColumn;

import java.util.ArrayList;

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