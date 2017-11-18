package isep.lab2.db.factory;

import isep.lab2.db.column.NumericColumn;
import isep.lab2.db.column.TextColumn;
import isep.lab2.db.entity.DbColumn;
import org.apache.log4j.*;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ColumnFactory {

    protected static Logger log = Logger.getLogger(ColumnFactory.class);


    public static DbColumn createColumn(DbTable table, ResultSet colInfo) {

        DbColumn.SQLTypes type = null;
        try {

            type = DbColumn.SQLTypes.valueOf(colInfo.getString("COLUMN_TYPE").split(" ")[0]);

            String colName = colInfo.getString("COLUMN_NAME");
            String defaulVal = colInfo.getString("COLUMN_DEF");
            boolean nullable = colInfo.getString("IS_NULLABLE").equals("YES");


            switch(type) {
                // Numeric
                case TINYINT:
                case SMALLINT:
                case MEDIUMINT:
                case BIGINT:
                case INT:
                case DECIMAL:
                case FLOAT:
                case DOUBLE:
                case REAL:
                case BIT:
                case BOOLEAN:
                case SERIAL:
                    boolean auto_incr = colInfo.getString("IS_AUTOINCREMENT").equals("YES");

                    if(rs.getString("COLUMN_SIZE") != null) {
                        c.setLength(Integer.parseInt(rs.getString("COLUMN_SIZE")));
                    }

                // Temporal
                case DATE:
                case DATETIME:
                case TIMESTAMP:
                case TIME:
                case YEAR:

                //Text
                case CHAR:
                case VARCHAR:
                case TINYTEXT:
                case MEDIUMTEXT:
                case LONGTEXT:
                case BINARY:

                //Document
                case VARBINARY:
                case TINYBLOP:
                case MEDIUMBLOP:
                case BLOP:
                case LONGBLOP:
                case TEXT:

                //List
                case ENUM:
                case SET:

                //Spatial
                case GEOMETRY:
                case POINT:
                case LINESTRING:
                case POLYGON:
                case MULTIPOINT:
                case MULTILINESTRING:
                case MULTIPOLYGON:
                case GEOMETRYCOLLECTION:
                case JSON:
            }

        } catch (SQLException se) {
            log.error(se);
        } catch (Exception e) {
            log.error(e);
        }
    }

    public static DbColumn createColumn(DbTable table, ResultSet colInfo) {

    }

}
