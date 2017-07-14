package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.dao.DepartmentDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Cristina.Constantin on 7/14/2017.
 */
public class DepartmentDaoTest {
    @Test
    public void testFindByIdMethod() throws SQLException, InstantiationException {
        DepartmentDao dao = new DepartmentDao();
        Department instance = null;
        try {
            instance = dao.findById(Department.class, 10L);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(instance.getDepartmentName(), "Administration");
    }

    @Test
    public void testGetNextIdValMethod(){
        DepartmentDao dao = new DepartmentDao();
        Long result = null;
        try {
            result = dao.getNextIdVal("Departments", "department_id");
            System.out.println("Next Id val: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertFalse(result == null);
    }

    @Test
    public void testInsertMethod(){
        DepartmentDao dao = new DepartmentDao();
        Department dep = new Department();
        dep.setDepartmentName("Piroman");
        dep.setLocation(1700L);
        Department nou = (Department) dao.insert(dep);

        assertEquals(nou.getDepartmentName(), "Piroman");
        assertEquals((Object)nou.getId(), 271L);

    }

    @Test
    public void testFindAll(){
        DepartmentDao dao = new DepartmentDao();
        List<Department> value = dao.findAll(Department.class);
        assertEquals(value.get(0).getDepartmentName(),"Administration");
    }

    @Test
    public void testUpdateMethod(){
        DepartmentDao dao = new DepartmentDao();
        Department dep = new Department();
        dep.setDepartmentName("Piroman");
        dep.setLocation(1700L);
        dep.setId(271L);
        Department nou = (Department) dao.update(dep);
        //System.out.println(nou.getDepartmentName());
        assertEquals(nou.getDepartmentName(), "Piroman");
    }

    @Test
    public void testDeleteMethod(){
        DepartmentDao dao = new DepartmentDao();
        Department dept = new Department();
        dept.setId(273L);
        dao.delete(dept);
        Department d = null;
        try {
            d = dao.findById(Department.class,dept.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(null, d);

    }

    @Test
    public void testFindByParams(){
        DepartmentDao dao = new DepartmentDao();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("department_name", "Executive");
        params.put("location_id", 1700L);
        List<Department> list = dao.findByParams(Department.class, params);

        assertEquals(list.size(), 1);
        assertEquals((Object) list.get(0).getDepartmentName(), "Executive");
    }
}
