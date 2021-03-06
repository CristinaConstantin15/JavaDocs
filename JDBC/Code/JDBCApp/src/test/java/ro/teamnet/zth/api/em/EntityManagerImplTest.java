package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertFalse;

/**
 * Created by Cristina.Constantin on 7/13/2017.
 */
public class EntityManagerImplTest {
    @Test
    public void testFindByIdMethod() throws SQLException, InstantiationException {
        EntityManagerImpl ent = new EntityManagerImpl();
        Department instance = ent.findById(Department.class, 10L);
        assertEquals(instance.getDepartmentName(), "Administration");

    }

    @Test
    public void testGetNextIdValMethod(){
        EntityManagerImpl ent = new EntityManagerImpl();
        Long result = null;
        try {
            result = ent.getNextIdVal("Departments", "department_id");
            System.out.println("Next Id val: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertFalse(result == null);
    }

    @Test
    public void testInsertMethod(){
        EntityManagerImpl ent = new EntityManagerImpl();
        Department dep = new Department();
        dep.setDepartmentName("Piroman");
        dep.setLocation(1700L);
        Department nou = (Department) ent.insert(dep);

        assertEquals(nou.getDepartmentName(), "Piroman");
        assertEquals((Object)nou.getId(), 271L);

    }

    @Test
    public void testFindAll(){
        EntityManagerImpl ent = new EntityManagerImpl();
        List<Department> value = ent.findAll(Department.class);
        assertEquals(value.get(0).getDepartmentName(),"Administration");
    }

    @Test
    public void testUpdateMethod(){
        EntityManagerImpl ent = new EntityManagerImpl();
        Department dep = new Department();
        dep.setDepartmentName("Piroman");
        dep.setLocation(1700L);
        dep.setId(271L);
        Department nou = (Department) ent.update(dep);
        //System.out.println(nou.getDepartmentName());
        assertEquals(nou.getDepartmentName(), "Piroman");
    }

    @Test
    public void testDeleteMethod(){
        EntityManagerImpl ent = new EntityManagerImpl();
        Department dept = new Department();
        dept.setId(273L);
        ent.delete(dept);
        Department d = ent.findById(Department.class,dept.getId());
        assertEquals(null, d);

    }

    @Test
    public void testFindByParams(){
        EntityManagerImpl ent = new EntityManagerImpl();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("department_name", "Executive");
        params.put("location_id", 1700L);
        List<Department> list = ent.findByParams(Department.class, params);

        assertEquals(list.size(), 1);
        assertEquals((Object) list.get(0).getDepartmentName(), "Executive");
    }
}
