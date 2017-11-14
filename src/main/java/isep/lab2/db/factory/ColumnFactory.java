package isep.lab2.db.factory;

import isep.lab2.db.entity.DbColumn;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;

public abstract class ColumnFactory {

    public static void createColumn(DbTable table, ResultSet colInfo) {
        //get type from ResultSet
        String type = colInfo.getString("")

        switch(type) {
        }
    }
}
