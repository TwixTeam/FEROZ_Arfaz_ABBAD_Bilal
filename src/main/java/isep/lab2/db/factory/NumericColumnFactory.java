package isep.lab2.db.factory;


import isep.lab2.db.column.NumericColumn;
import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;

public class NumericColumnFactory extends ColumnFactory {

    public static DbColumn createColumn(int intType, String type, String name, String defaultVal,
                                        boolean nullable, int length) {

        DbColumn column = new NumericColumn(intType, type, name, defaultVal, nullable, length);

        return column;
    }
}
