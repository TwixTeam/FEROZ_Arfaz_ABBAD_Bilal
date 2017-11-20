package isep.lab2.db.factory;

import java.sql.Types;

import org.apache.log4j.Logger;

import isep.lab2.db.column.ListColumn;
import junit.framework.TestCase;

public class ListColumnFactoryTest extends TestCase {
	protected static Logger log = Logger.getLogger(ListColumnFactoryTest.class);

	public ListColumnFactoryTest(String name) {
		super(name);
	}

	public void testApp() {
		assertTrue(ListColumnFactory.createColumn("test_table", Types.ARRAY, "array", "test_column", "NULL", true) instanceof ListColumn);
		log.info("ListColumnFactory OK");
	}
}
