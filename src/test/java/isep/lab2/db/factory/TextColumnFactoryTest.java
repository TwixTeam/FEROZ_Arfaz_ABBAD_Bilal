package isep.lab2.db.factory;

import java.sql.Types;

import org.apache.log4j.Logger;

import isep.lab2.db.column.TextColumn;
import junit.framework.TestCase;

public class TextColumnFactoryTest extends TestCase {
	protected static Logger log = Logger.getLogger(TextColumnFactoryTest.class);

	public TextColumnFactoryTest(String name) {
		super(name);
	}

	public void testApp() {
		assertTrue(TextColumnFactory.createColumn("test_table", Types.VARCHAR, "varchar", "test_column", "NULL", true, "255") instanceof TextColumn);
		log.info("TextColumnFactory OK");
	}
}
