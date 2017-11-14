package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class NumericColumn extends DbColumn {

	public NumericColumn() {
	}

	public NumericColumn(String type, String name, int length, String defaultVal, boolean autoIncr, boolean uniq,
			boolean nullable, boolean prim, boolean foreign) {
		super(type, name, length, defaultVal, autoIncr, uniq, nullable, prim, foreign);
	}

}
