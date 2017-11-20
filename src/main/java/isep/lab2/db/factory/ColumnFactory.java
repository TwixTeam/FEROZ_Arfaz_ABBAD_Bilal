package isep.lab2.db.factory;


import isep.lab2.db.entity.DbColumn;
import org.apache.log4j.*;
import isep.lab2.db.entity.DbTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public abstract class ColumnFactory {

    private static Logger log = Logger.getLogger(ColumnFactory.class);


    public static DbColumn createColumn(DbTable table, ResultSet colInfo) {

        int typeNumber;
        String length = "";
        String typeName;
        DbColumn currentColumn = null;


        try {
            typeNumber = colInfo.getInt("DATA_TYPE");
            typeName = colInfo.getString("TYPE_NAME").split(" ")[0];

            String colName = colInfo.getString("COLUMN_NAME");
            String defaultVal = colInfo.getString("COLUMN_DEF");
            boolean nullable = colInfo.getString("IS_NULLABLE").equals("YES");

            if(typeName.toUpperCase().equals("ENUM") || typeName.toUpperCase().equals("SET")) {
                typeNumber = Types.VARCHAR;
            }

            else if(typeName.toUpperCase().equals("TEXT")) {
                typeNumber = Types.BLOB;
            }

            switch(typeNumber) {
                // Numeric
                case Types.BIGINT:
                case Types.BIT:
                case Types.DECIMAL:
                case Types.FLOAT:
                case Types.INTEGER:
                case Types.NUMERIC:
                case Types.REAL:
                case Types.SMALLINT:
                case Types.TINYINT:
                case Types.BOOLEAN:
                case Types.DOUBLE:

                    boolean isUnsigned = colInfo.getString("TYPE_NAME").split(" ").length > 1;

                    if(colInfo.getString("COLUMN_SIZE") != null) {
                        length = colInfo.getString("COLUMN_SIZE");
                        log.debug(length);
                    }

                    if(colInfo.getString("DECIMAL_DIGITS") != null && !colInfo.getString("DECIMAL_DIGITS").equals("0")) {
                        length += "," + colInfo.getString("DECIMAL_DIGITS");
                        log.debug(length);
                    }

                    currentColumn = NumericColumnFactory.createColumn(table.getName(),typeNumber, typeName, colName, defaultVal, nullable, length, isUnsigned);

                    break;


                //Text
                case Types.CHAR:
                case Types.VARCHAR:
                case Types.LONGNVARCHAR:
                case Types.LONGVARCHAR:
                case Types.NCHAR:
                case Types.NVARCHAR:

                    if(colInfo.getString("COLUMN_SIZE") != null) {

                        length = colInfo.getString("COLUMN_SIZE");
                    }
                    currentColumn = TextColumnFactory.createColumn(table.getName(), typeNumber, typeName, colName, defaultVal, nullable, length);

                    break;


                // Temporal
                case Types.DATE:
                case Types.TIME:
                case Types.TIME_WITH_TIMEZONE:
                case Types.TIMESTAMP:
                case Types.TIMESTAMP_WITH_TIMEZONE:

                    currentColumn = TemporalColumnFactory.createColumn(table.getName(), typeNumber, typeName, colName, defaultVal, nullable);
                    break;

                //Document
                case Types.BINARY:
                case Types.LONGVARBINARY:
                case Types.VARBINARY:
                case Types.BLOB:
                case Types.CLOB:
                case Types.NCLOB:
                case Types.JAVA_OBJECT:
                case Types.SQLXML:
                case Types.DATALINK:

                    currentColumn = DocumentColumnFactory.createColumn(table.getName(), typeNumber, typeName, colName, defaultVal, nullable);
                    break;


                //List
                case Types.ARRAY:
                case Types.STRUCT:

                    currentColumn = ListColumnFactory.createColumn(table.getName(), typeNumber, typeName, colName, defaultVal, nullable);
                    break;

                default:
                    log.debug("Unknown SQL Type : " + typeName.toString());
                    break;
            }



        } catch (SQLException se) {
            log.error(se);
        } catch (Exception e) {
            log.error(e);
        }

        return currentColumn;
    }

}
