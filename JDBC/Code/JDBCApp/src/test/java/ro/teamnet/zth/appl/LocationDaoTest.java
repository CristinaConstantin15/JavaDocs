package ro.teamnet.zth.appl;

import org.junit.Test;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.domain.dao.LocationDao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Cristina.Constantin on 7/14/2017.
 */
public class LocationDaoTest {
    @Test
    public void testFindByIdMethod() throws SQLException, InstantiationException {
        LocationDao loc = new LocationDao();
        Location instance = null;
        try {
            instance = loc.findById(Location.class, 1000L);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        assertEquals(instance.getCity(), "Roma");

    }


    @Test
    public void testInsertMethod(){
        LocationDao loc = new LocationDao();
        Location l = new Location();
        l.setStreetAddress("whereever");
        l.setPostalCode("98760");
        l.setCity("Cluj");
        l.setStateProvince("Cluj");
        Location nou = (Location) loc.insert(l);

        assertEquals(nou.getCity(), "Cluj");

    }

    @Test
    public void testFindAll(){
        LocationDao loc = new LocationDao();
        List<Location> value = loc.findAll(Location.class);
        assertEquals(value.get(0).getCity(),"Roma");
    }

    @Test
    public void testUpdateMethod(){
        LocationDao loc = new LocationDao();
        Location l = new Location();
        l.setCity("Cluj");
        l.setPostalCode("98760");
        l.setStreetAddress("whereever");
        l.setStateProvince("Cluj");
        l.setId(1300L);
        Location nou = (Location) loc.update(l);
        //System.out.println(nou.getDepartmentName());
        assertEquals(nou.getCity(), "Cluj");
    }

    @Test
    public void testFindByParams(){
        LocationDao loc = new LocationDao();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("CITY", "Roma");
        params.put("location_id", 1000L);
        List<Location> list = loc.findByParams(Location.class, params);

        assertEquals(list.size(), 1);
        assertEquals((Object) list.get(0).getCity(), "Roma");
    }
}
