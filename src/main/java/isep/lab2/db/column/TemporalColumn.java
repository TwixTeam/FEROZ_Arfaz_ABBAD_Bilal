package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TemporalColumn extends DbColumn {

	public TemporalColumn() {
	}

	public TemporalColumn(String type, String name, String defaultVal, boolean uniq,
			boolean nullable, boolean prim, boolean foreign) {
		super(type, name, defaultVal, uniq, nullable, prim, foreign);
	}
}
