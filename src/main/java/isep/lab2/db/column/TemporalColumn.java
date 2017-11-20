package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TemporalColumn extends DbColumn {

	public TemporalColumn() {
	}

	public TemporalColumn(int intType, String type, String name, String defaultVal, boolean nullable) {
		super(intType, type, name, defaultVal, nullable);
	}

	public String toSQL() {
		return super.toSQL();
	}
}
