package isep.lab2.db.factory;

import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;

public class DocumentColumnFactory extends ColumnFactory{

    public static DbColumn createColumn(DbTable table, ResultSet colInfo) {
        DbColumn col = null;

        return col;
    }
}
