package isep.lab2.db.key;

public class DbForeignKey extends DbKey {

    String keyName;
    String referencedKey;


    public DbForeignKey(String tableName, String keyName) {
        super(tableName);
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String toSQL() {

        String sql = "ADD KEY '" + keyName + "' " + super.toSQL();

        return sql;
    }
}
