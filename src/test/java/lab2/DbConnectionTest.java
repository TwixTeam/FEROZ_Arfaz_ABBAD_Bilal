package lab2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.sql.Connection;

/**
 * Unit test for simple App.
 */
public class DbConnectionTest extends TestCase {
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

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Connection c1 = DbConnection.getInstance();
		assertTrue(c1 != null);

		Connection c2 = DbConnection.getInstance("jdbc:mysql://invalid/url", "invalid.driver", "invalidUser", "invalidPassword");
		assertTrue(c2 == null);
	}
}