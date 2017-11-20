package isep.lab2.db.column;

import java.sql.Types;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class TextColumnTest extends TestCase {
	protected static Logger log = Logger.getLogger(TextColumnTest.class);
	TextColumn column;
	
	public TextColumnTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		column = new TextColumn(Types.VARCHAR, "varchar", "test_Name", "NULL", true, 255);
	}
	
	public void testApp() {
		assertTrue("'test_Name' varchar(255) DEFAULT NULL,\n".equals(column.toSQL()));
		log.info("DocumentColumn Object OK");
	}

}
