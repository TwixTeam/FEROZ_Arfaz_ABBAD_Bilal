package isep.lab2.db.key;

public class DbUniqueKey extends DbKey {

    String keyName;

    public DbUniqueKey(String tableName, String keyName) {
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
