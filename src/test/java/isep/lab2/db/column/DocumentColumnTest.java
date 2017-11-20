package isep.lab2.db.column;

import org.apache.log4j.Logger;

import isep.lab2.db.query.SimpleQuery;
import junit.framework.TestCase;

public class DocumentColumnTest extends TestCase {
	protected static Logger log = Logger.getLogger(SimpleQuery.class);
	DocumentColumn column;
	
	public DocumentColumnTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		column = new DocumentColumn(255, "BLOB", "test_Name", "", true);
	}


}
