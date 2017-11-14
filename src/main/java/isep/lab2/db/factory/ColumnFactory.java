package isep.lab2.db.factory;

import isep.lab2.db.entity.DbColumn;
import org.apache.log4j.*;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ColumnFactory {

    protected static Logger log = Logger.getLogger(ColumnFactory.class);

    public static void createColumn(DbTable table, ResultSet colInfo) {
        //get type from ResultSet
        String type = null;
        try {
            type = colInfo.getString("COLUMN_TYPE");

            switch(type) {
                case DbColumn
            }

        } catch (SQLException se) {
            log.error(se);
        } catch (Exception e) {
            log.error(e);
        }
    }
}
