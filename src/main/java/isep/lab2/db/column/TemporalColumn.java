package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TemporalColumn extends DbColumn {

	public TemporalColumn() {
	}

	public TemporalColumn(String tableName, int intType, String type, String name, String defaultVal, boolean nullable) {
		super(tableName, intType, type, name, defaultVal, nullable);
	}

	public String toSQL() {
		String sql = super.toSQL();

		if(this.getType().equals("TIMESTAMP")) {
			sql =  super.toSQL().split(",")[0] + " ON UPDATE CURRENT_TIMESTAMP\n";
		}

		return sql;
	}
}
