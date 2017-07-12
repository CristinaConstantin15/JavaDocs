package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Cristina.Constantin on 7/12/2017.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod1() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetTableNameMethod2() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumns() {
        ArrayList<ColumnInfo> columns = EntityUtils.getColumns(Department.class);
        assertEquals("Table name should be departments!", null, columns);
    }

}
