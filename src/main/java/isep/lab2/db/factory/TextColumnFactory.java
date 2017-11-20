package isep.lab2.db.factory;


import isep.lab2.db.column.TextColumn;
import isep.lab2.db.entity.DbColumn;

public class TextColumnFactory extends ColumnFactory{

    public static DbColumn createColumn(String tableName, int intType, String type, String name, String defaultVal,
                                        boolean nullable, String length) {

        return new TextColumn(tableName, intType, type, name, defaultVal, nullable, length);
    }
}
