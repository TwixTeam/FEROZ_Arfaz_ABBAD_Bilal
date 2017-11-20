package isep.lab2.db.factory;

import isep.lab2.db.column.NumericColumn;
import isep.lab2.db.column.TextColumn;
import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;

public class TextColumnFactory extends ColumnFactory{

    public static DbColumn createColumn(int intType, String type, String name, String defaultVal,
                                        boolean nullable, int length) {

        DbColumn column = new TextColumn(intType, type, name, defaultVal, nullable, length);

        return column;
    }
}
