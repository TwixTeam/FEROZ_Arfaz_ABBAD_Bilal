package isep.lab2.db.entity;

import org.apache.log4j.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** 
 * db column
 */
public class DbColumn {

	private String type;
	private String name;
	private int length;
	private String defaultValue;
	private boolean isAutoIncrement;
	private boolean isUnique;
	private boolean isNullable;
	private boolean isPrimary;
	private boolean isForeign;
	public static enum SQLTypes {INT, VARCHAR, TEXT, DATE};
	public DbColumn(){}

	public DbColumn(String type, String name, int length, String defaultVal, boolean autoIncr, boolean uniq, boolean nullable, boolean prim, boolean foreign){
		this.type = type;
		this.name = name;
		this.length = length;
		this.defaultValue = defaultVal;
		this.isAutoIncrement = autoIncr;
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}

	public void setAutoIncrement(boolean autoIncrement) {
		isAutoIncrement = autoIncrement;
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