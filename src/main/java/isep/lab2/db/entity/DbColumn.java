package isep.lab2.db.entity;

/**
 * db column
 */
public class DbColumn {

	private String type;
	private String name;
	private String defaultValue;
	private boolean isUnique;
	private boolean isNullable;
	private boolean isPrimary;
	private boolean isForeign;

	public enum SQLTypes {
		TINYINT,
		SMALLINT,
		MEDIUMINT,
		INT, 
		BIGINT, 
		DECIMAL, 
		FLOAT, 
		DOUBLE, 
		REAL, 
		BIT, 
		BOOLEAN, 
		SERIAL, 
		DATE, 
		DATETIME, 
		TIMESTAMP, 
		TIME, 
		YEAR, 
		CHAR, 
		VARCHAR, 
		TINYTEXT, 
		TEXT, 
		MEDIUMTEXT, 
		LONGTEXT, 
		BINARY, 
		VARBINARY, 
		TINYBLOP, 
		MEDIUMBLOP, 
		BLOP, 
		LONGBLOP, 
		ENUM, 
		SET, 
		GEOMETRY, 
		POINT, 
		LINESTRING, 
		POLYGON, 
		MULTIPOINT, 
		MULTILINESTRING, 
		MULTIPOLYGON, 
		GEOMETRYCOLLECTION, 
		JSON
	};

	public DbColumn() {
	}

	public DbColumn(String type, String name, String defaultVal, boolean uniq,
			boolean nullable, boolean prim, boolean foreign) {
		this.type = type;
		this.name = name;
		this.defaultValue = defaultVal;
		this.isUnique = uniq;
		this.isNullable = nullable;
		this.isPrimary = prim;
		this.isForeign = foreign;
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

	public boolean isUnique() {
		return isUnique;
	}

	public void setUnique(boolean unique) {
		isUnique = unique;
	}

	public boolean isNullable() {
		return isNullable;
	}

	public void setNullable(boolean nullable) {
		isNullable = nullable;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean primary) {
		isPrimary = primary;
	}

	public boolean isForeign() {
		return isForeign;
	}

	public void setForeign(boolean foreign) {
		isForeign = foreign;
	}
}