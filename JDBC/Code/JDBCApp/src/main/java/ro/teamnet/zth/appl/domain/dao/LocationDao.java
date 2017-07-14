package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristina.Constantin on 7/14/2017.
 */
public class LocationDao {
    EntityManager ent = new EntityManagerImpl();

        public <Location> Location findById(Class<Location> entityClass, Long id) throws SQLException, IllegalAccessException {
            return ent.findById(entityClass, id);
        }

        public Long getNextIdVal(String tableName, String columnIdName) throws SQLException {
            return ent.getNextIdVal(tableName, columnIdName);
        }

        public <Location> Object insert(Location entity) {
            return ent.insert(entity);
        }

        public <Location> List<Location> findAll(Class<Location> entityClass) {
            return ent.findAll(entityClass);
        }

        public <Location> Location update(Location entity) {
            return ent.update(entity);
        }

        public void delete(Object entity) {

        }

        public <Location> List<Location> findByParams(Class<Location> entityClass, Map<String, Object> params) {
            return ent.findByParams(entityClass, params);
        }
}
