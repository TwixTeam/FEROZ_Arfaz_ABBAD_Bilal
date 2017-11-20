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
		column = new NumericColumn(Types.TINYINT, "tinyint", "test_name", "NULL", true, 3);
	}

	public void testApp() {
		assertTrue("'test_name' tinyint(3) DEFAULT NULL,\n".equals(column.toSQL()));
		log.info("NumericColumn Object OK");
	}
}
