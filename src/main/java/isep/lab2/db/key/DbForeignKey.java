package isep.lab2.db.key;

public class DbForeignKey extends DbKey {

    String keyName;


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
}
