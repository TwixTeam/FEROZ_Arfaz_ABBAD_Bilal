package isep.lab2.db.column;

import java.sql.Types;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class NumericColumnTest extends TestCase {
	protected static Logger log = Logger.getLogger(NumericColumnTest.class);
	NumericColumn column;

	public NumericColumnTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		column = new NumericColumn("test_table", Types.TINYINT, "tinyint", "test_column", "NULL", true, "3", true);
	}

	public void testApp() {
		log.debug("Column sql : " + column.toSQL());
		assertTrue("\t'test_column' tinyint(3) UNSIGNED DEFAULT NULL,\n".equals(column.toSQL()));
		log.info("NumericColumn Object OK");
	}
}
