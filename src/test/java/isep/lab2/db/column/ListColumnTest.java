package isep.lab2.db.column;

import java.sql.Types;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class ListColumnTest extends TestCase {
	protected static Logger log = Logger.getLogger(ListColumnTest.class);
	ListColumn column;

	public ListColumnTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		column = new ListColumn(Types.ARRAY, "array", "test_name", "NULL", true);
	}
	
	public void testApp() {
		log.info("***"+column.toSQL()+"***");
		assertTrue("'test_name' array DEFAULT NULL,\n".equals(column.toSQL()));
		log.info("ListColumn Object OK");
	}
}
