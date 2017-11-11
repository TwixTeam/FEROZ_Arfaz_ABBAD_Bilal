package lab2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;

import org.apache.log4j.Logger;

/**
 * Unit test for DbConnection class
 */
public class DbConnectionTest extends TestCase {

	protected static Logger log = Logger.getLogger(SimpleQuery.class);
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DbConnectionTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DbConnectionTest.class);
	}

	public void testApp() {
		//Test connection success
		assertTrue( DbConnection.getInstance() != null);
		log.info("connection success OK");
		//Test connection fail
		assertTrue(DbConnection.getInstance("jdbc:mysql://invalid/url", "invalid.driver", "invalidUser", "invalidPassword") == null);
		log.info("connection fail OK");
	}
}