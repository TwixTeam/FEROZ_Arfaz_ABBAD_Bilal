package isep.lab2.db.factory;

import isep.lab2.db.entity.DbTable;
import isep.lab2.db.key.DbForeignKey;
import isep.lab2.db.key.DbKey;

import isep.lab2.db.key.DbPrimaryKey;
import isep.lab2.db.key.DbUniqueKey;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class KeyFactory {
    private static Logger log = Logger.getLogger(KeyFactory.class);

    public static DbKey createKey(DbTable table, ResultSet rs, String keyType){

        DbKey key = null;
        ArrayList<String> targets = new ArrayList<>();

        try {
            switch(keyType) {

                case "unique":
                    if(!rs.getString("INDEX_NAME").equals("PRIMARY")) {
                        key = new DbUniqueKey(table.getName(), rs.getString("INDEX_NAME"), rs.getBoolean("NON_UNIQUE"));
                        key.getTargetColumns().add(rs.getString("COLUMN_NAME"));
                    }
                    break;

                case "primary":
                    key = new DbPrimaryKey(table.getName());
                    key.getTargetColumns().add(rs.getString("COLUMN_NAME"));
                    break;


                case "foreign":
                    //key = new DbForeignKey(table.getName(), );
                    break;

                case "fulltext":
                    break;

                default:
                    log.debug("Key Type not found");
            }
        } catch (SQLException se) {
            log.error(se);
        } catch (Exception e) {
            log.error(e);
        }

        return key;
    }
}
