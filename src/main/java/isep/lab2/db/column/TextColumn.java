package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TextColumn extends DbColumn {
	private int length;
	
	public TextColumn() {
	}

	public TextColumn(String type, String name, String defaultVal, boolean autoIncr, boolean uniq,
			boolean nullable, boolean prim, boolean foreign, int length) {
		super(type, name, defaultVal, uniq, nullable, prim, foreign);
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
