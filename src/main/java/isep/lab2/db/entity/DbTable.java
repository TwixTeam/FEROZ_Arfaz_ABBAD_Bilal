package isep.lab2.db.entity;

import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.key.DbKey;

import java.util.ArrayList;

/** 
 * db table
 */
public class DbTable {

	private String name;
	private ArrayList<DbColumn> columns;
	private ArrayList<DbKey> keys;

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

	public ArrayList<DbKey> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<DbKey> keys) {
		this.keys = keys;
	}

	public String toSQLCreateTable() {
		String script = "CREATE TABLE '" + this.name + "' (\n";

		for(DbColumn currentColumn : this.getColumns()) {
			script += currentColumn.toSQL();
		}

		script += ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

		return script;
	}

	public String toSQLAlterTable() {
		String script = "ALTER TABLE '" + this.name + "' (\n";

		for(DbKey currentKey : this.getKeys()) {
			script += currentKey.toSQL();
		}

		script += ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";

		return script;
	}
}