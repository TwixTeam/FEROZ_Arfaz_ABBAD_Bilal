package lab2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lab2.db.connection.DbConnection;
import lab2.db.query.SimpleQuery;
import org.apache.log4j.Logger;

import junit.framework.TestCase;

/**
 * Unit test for SimpleQuery class
 */
public class SimpleQueryTest extends TestCase {
	protected static Logger log = Logger.getLogger(SimpleQuery.class);
	Connection conn = null;
   	Statement stmt = null;
   	ResultSet rs = null;
   	String sql = "";

	public SimpleQueryTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		conn = DbConnection.getInstance();
		stmt = conn.createStatement();
      	sql = "SELECT last_name FROM actor";
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		try {
      		rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			log.error(e);
		} catch (NullPointerException npe) {
			log.error(npe);
		}
	}
	
	public void testApp() {
		try {
			rs = stmt.executeQuery(sql);
			log.info("simpleQuery OK");
		} catch (SQLException e) {
			log.error(e);
		}
	}
}
