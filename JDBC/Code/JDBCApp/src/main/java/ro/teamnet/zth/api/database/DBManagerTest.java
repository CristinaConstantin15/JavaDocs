package ro.teamnet.zth.api.database;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Created by Cristina.Constantin on 7/13/2017.
 */
public class DBManagerTest {
    @Test
    public void testConnectionManagerMethod() throws SQLException {
        Connection con = DBManager.getConnection();
        assertFalse(con == null);

    }


    @Test
    public void testCheckConnectionMethod() throws SQLException{
        DBManager.checkConnection(DBManager.getConnection());
        assertEquals("","");

    }
}
