package isep.lab2.db.key;

import java.util.List;

public abstract class DbKey {

    private String table;
    private List<String> targetColumns;

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

    public List<String> getTargetColumns() {
        return targetColumns;
    }

    public void setTargetColumns(List<String> targetColumns) {
        this.targetColumns = targetColumns;
    }
}
