package isep.lab2.db.factory;

import isep.lab2.db.entity.DbTable;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public abstract class KeyFactory {
    private static Logger log = Logger.getLogger(ColumnFactory.class);

    public static void createKey(DbTable table, ResultSet rs){

    }
}