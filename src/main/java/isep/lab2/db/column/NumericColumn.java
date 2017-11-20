package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class NumericColumn extends DbColumn {
	private String length;
	private boolean unsigned;

	public NumericColumn() {
	}

	public NumericColumn(String tableName, int intType, String type, String name, String defaultVal, boolean nullable, String length, boolean isUnsigned) {

		super(tableName, intType, type, name, defaultVal, nullable);
		this.length = length;
		this.unsigned = isUnsigned;
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
		String unsigned = this.unsigned ? " UNSIGNED" : "";

		return ("\t'" + this.getName() + "' " + this.getType() + "("+ this.getLength() +")" + unsigned + nullable + defaultVal + ",\n");
	}
}
