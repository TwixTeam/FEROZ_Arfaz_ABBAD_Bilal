package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class NumericColumn extends DbColumn {
	private int length;
	private boolean isAutoIncrement;
	
	public NumericColumn() {
	}

	public NumericColumn(String type, String name,  String defaultVal, boolean uniq,
			boolean nullable, boolean prim, boolean foreign, int length, boolean autoIncr) {
		super(type, name, defaultVal, uniq, nullable, prim, foreign);
		this.length = length;
		this.isAutoIncrement = autoIncr;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}

	public void setAutoIncrement(boolean autoIncrement) {
		isAutoIncrement = autoIncrement;
	}
}
