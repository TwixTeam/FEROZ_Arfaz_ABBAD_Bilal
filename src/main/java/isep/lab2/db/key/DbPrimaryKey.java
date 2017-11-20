package isep.lab2.db.key;

public class DbPrimaryKey extends DbKey {

    public DbPrimaryKey(String tableName) {
        super(tableName);
    }

    public String toSQL() {

        String sql = "ADD PRIMARY KEY " + super.toSQL();

        return sql;
    }
}
