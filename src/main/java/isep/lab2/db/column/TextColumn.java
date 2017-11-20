package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TextColumn extends DbColumn {
	private int length;
	
	public TextColumn() {
	}

	public TextColumn(int intType, String type, String name, String defaultVal, boolean nullable, int length) {

		super(intType, type, name, defaultVal, nullable);
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String toSQL() {
		String nullable = this.isNullable() ? "NULL" : "NOT NULL";
		String defaultVal = this.getDefaultValue() != null ? "DEFAULT " + this.getDefaultValue() : "";

		return ("'" + this.getName() + "' " + this.getType() + "("+ this.getLength() +")" + " " + nullable + " " + defaultVal + ",\n");
	}
}
