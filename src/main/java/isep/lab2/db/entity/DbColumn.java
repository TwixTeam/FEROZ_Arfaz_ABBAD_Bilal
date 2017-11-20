package isep.lab2.db.entity;

/**
 * db column
 */
public abstract class DbColumn {

	private String tableName;
	private String type;
	private int intType;
	private String name;
	private String defaultValue;
	private boolean isNullable;


	public DbColumn() {
	}

	public DbColumn(String tableName, int intType, String type, String name, String defaultVal,
			boolean nullable) {
		this.tableName = tableName;
		this.intType = intType;
		this.type = type;
		this.name = name;
		this.defaultValue = defaultVal;
		this.isNullable = nullable;
	}

	public int getIntType() {
		return intType;
	}

	public void setIntType(int intType) {
		this.intType = intType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public void setNullable(boolean nullable) {
		isNullable = nullable;
	}

	public String toSQL() {
		String nullable = this.isNullable() ? "" : " NOT NULL";
		String defaultVal = this.getDefaultValue() != null ? " DEFAULT " + this.getDefaultValue() : "";

		return ("\t'" + this.getName() + "' " + this.getType() + nullable + defaultVal + ",\n");
	}

}