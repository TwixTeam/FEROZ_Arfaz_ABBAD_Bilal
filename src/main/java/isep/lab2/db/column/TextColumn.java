package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class TextColumn extends DbColumn {
	private String length;
	
	public TextColumn() {
	}

	public TextColumn(String tableName, int intType, String type, String name, String defaultVal, boolean nullable, String length) {

		super(tableName,intType, type, name, defaultVal, nullable);
		this.length = length;
	}
	
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String toSQL() {
		String nullable = this.isNullable() ? "" : " NOT NULL";
		String defaultVal = this.getDefaultValue() != null ? " DEFAULT " + this.getDefaultValue() : "";

		return ("\t'" + this.getName() + "' " + this.getType() + "("+ this.getLength() +")" + nullable + defaultVal + ",\n");
	}
}
