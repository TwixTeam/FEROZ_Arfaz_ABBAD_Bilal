package isep.lab2.db.key;

public class DbUniqueKey extends DbKey {

    String keyName;
    boolean unique;

    public DbUniqueKey(String tableName, String keyName, boolean uniq) {
        super(tableName);
        this.keyName = keyName;
        this.unique = uniq;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String toSQL() {

        String uniqueStatement = this.unique ? " UNIQUE" : "";

        String sql = "ADD" + uniqueStatement + " KEY '" + keyName + "' " + super.toSQL();

        return sql;
    }
}
