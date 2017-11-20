package isep.lab2.db.factory;

import java.sql.Types;

import org.apache.log4j.Logger;

import isep.lab2.db.column.NumericColumn;
import junit.framework.TestCase;

public class NumericColumnFactoryTest extends TestCase {
	protected static Logger log = Logger.getLogger(NumericColumnFactoryTest.class);

	public NumericColumnFactoryTest(String name) {
		super(name);
	}
	
	public void testApp() {
		assertTrue(NumericColumnFactory.createColumn("test_table", Types.TINYINT, "tinyint", "test_column", "NULL", true, "3", true, false) instanceof NumericColumn);
		log.info("NumericColumnFactoryTest OK");
	}

}
