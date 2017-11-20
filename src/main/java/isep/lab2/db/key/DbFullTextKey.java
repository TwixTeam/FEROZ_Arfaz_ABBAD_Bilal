package isep.lab2.db.key;

public class DbFullTextKey extends DbKey {

    String keyName;

    public DbFullTextKey(String tableName, String keyName) {
        super(tableName);
        this.keyName = keyName;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
