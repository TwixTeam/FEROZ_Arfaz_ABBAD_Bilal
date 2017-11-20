package isep.lab2.db.factory;


import isep.lab2.db.column.NumericColumn;
import isep.lab2.db.entity.DbColumn;


public class NumericColumnFactory extends ColumnFactory {

    public static DbColumn createColumn(String tableName, int intType, String type, String name, String defaultVal,
                                        boolean nullable, String length, boolean isUnsigned, boolean autoIncrement) {

        DbColumn column = new NumericColumn(tableName,intType, type, name, defaultVal, nullable, length, isUnsigned, autoIncrement);

        return column;
    }
}
