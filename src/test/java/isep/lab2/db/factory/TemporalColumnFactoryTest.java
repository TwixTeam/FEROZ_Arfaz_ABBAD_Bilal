package isep.lab2.db.factory;

import java.sql.Types;

import org.apache.log4j.Logger;

import isep.lab2.db.column.TemporalColumn;
import junit.framework.TestCase;

public class TemporalColumnFactoryTest extends TestCase {
	protected static Logger log = Logger.getLogger(TemporalColumnFactoryTest.class);

	public TemporalColumnFactoryTest(String name) {
		super(name);
	}

	public void testApp() {
		assertTrue(TemporalColumnFactory.createColumn("test_table", Types.TIMESTAMP, "timestamp", "test_column", "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", false) instanceof TemporalColumn);
		log.info("TemporalColumnFactory OK");
	}
}
