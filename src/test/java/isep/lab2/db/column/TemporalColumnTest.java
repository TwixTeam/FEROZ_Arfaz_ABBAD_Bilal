package isep.lab2.db.column;

import java.sql.Types;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class TemporalColumnTest extends TestCase {
	protected static Logger log = Logger.getLogger(TemporalColumnTest.class);
	TemporalColumn column;

	public TemporalColumnTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		column = new TemporalColumn("test_table", Types.TIMESTAMP, "timestamp", "test_column", "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", false);
	}
	
	public void testApp() {
		log.debug("Column sql : " + column.toSQL());
		assertTrue("\t'test_column' timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,\n".equals(column.toSQL()));
		log.info("TemporalColumn Object OK");
	}
}
