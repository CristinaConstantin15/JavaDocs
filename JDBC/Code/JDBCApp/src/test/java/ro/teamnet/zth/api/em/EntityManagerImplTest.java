package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;


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
            System.out.println(result);
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

}
