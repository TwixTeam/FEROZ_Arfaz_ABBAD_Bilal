package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class ListColumn extends DbColumn{

    public ListColumn(String tableName, int intType, String type, String name,  String defaultVal, boolean nullable) {

        super(tableName, intType, type, name, defaultVal, nullable);
    }

}
