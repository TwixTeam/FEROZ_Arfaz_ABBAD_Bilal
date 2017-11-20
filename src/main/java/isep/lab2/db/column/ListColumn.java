package isep.lab2.db.column;

import isep.lab2.db.entity.DbColumn;

public class ListColumn extends DbColumn{

    public ListColumn(int intType, String type, String name,  String defaultVal, boolean nullable) {

        super(intType, type, name, defaultVal, nullable);
    }
}
