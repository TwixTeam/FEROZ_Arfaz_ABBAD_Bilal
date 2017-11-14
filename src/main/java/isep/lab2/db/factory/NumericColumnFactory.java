package isep.lab2.db.factory;

import isep.lab2.db.entity.DbColumn;

public class NumericColumnFactory extends ColumnFactory {

    public static DbColumn createColumn(String type) {
        super(type);
    }
}
