package isep.lab2.db.factory;

import isep.lab2.db.column.NumericColumn;
import isep.lab2.db.column.TemporalColumn;
import isep.lab2.db.entity.DbColumn;

public class TemporalColumnFactory extends ColumnFactory {

    public static DbColumn createColumn(int intType, String type, String name, String defaultVal,
                                        boolean nullable) {

        DbColumn column = new TemporalColumn(intType, type, name, defaultVal, nullable);

        return column;
    }
}
