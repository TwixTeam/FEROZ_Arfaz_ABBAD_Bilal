package isep.lab2.db.factory;

import isep.lab2.db.column.ListColumn;
import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;

public class ListColumnFactory extends ColumnFactory{

    public static DbColumn createColumn(int intType, String type, String name, String defaultVal, boolean nullable) {

        DbColumn column = new ListColumn(intType, type, name, defaultVal, nullable);

        return column;
    }
}
