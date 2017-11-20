package isep.lab2.db.key;

import java.util.ArrayList;

public abstract class DbKey {

    private String table;
    private ArrayList<String> targetColumns;

    public enum Types {
        PRIMARY,
        UNIQUE,
        FOREIGN,
        FULLTEXT
    };

    public DbKey() {
    }

    public DbKey(String tableName) {
        this.table = tableName;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ArrayList<String> getTargetColumns() {
        return targetColumns;
    }

    public void setTargetColumns(ArrayList<String> targetColumns) {
        this.targetColumns = targetColumns;
    }

    public String toSQL() {

        String targets = " (";

        for(String columnName : this.targetColumns) {
            targets +="'" + columnName + "', ";
        }

        targets = ")";

        return targets;
    }
}
