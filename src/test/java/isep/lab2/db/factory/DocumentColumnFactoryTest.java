package isep.lab2.db.factory;

import java.sql.Types;

import org.apache.log4j.Logger;

import isep.lab2.db.column.DocumentColumn;
import junit.framework.TestCase;

public class DocumentColumnFactoryTest extends TestCase {
	protected static Logger log = Logger.getLogger(DocumentColumnFactoryTest.class);

	public DocumentColumnFactoryTest(String name) {
		super(name);
	}

	public void testApp() {
		assertTrue(DocumentColumnFactory.createColumn("test_table", Types.BLOB, "blob", "test_column", "", true) instanceof DocumentColumn);
		log.info("DocumentColumnFactory OK");
	}
}
