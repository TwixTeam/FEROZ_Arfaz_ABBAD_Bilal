package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class DocumentColumn extends DbColumn {

	public DocumentColumn() {
	}

	public DocumentColumn(String type, String name, String defaultVal, boolean uniq,
			boolean nullable, boolean prim, boolean foreign) {
		super(type, name, defaultVal, uniq, nullable, prim, foreign);
	}
}
