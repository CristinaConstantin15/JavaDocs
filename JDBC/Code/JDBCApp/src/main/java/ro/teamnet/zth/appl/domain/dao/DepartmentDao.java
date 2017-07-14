package ro.teamnet.zth.appl.domain.dao;

import ro.teamnet.zth.api.em.EntityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristina.Constantin on 7/14/2017.
 */
public class DepartmentDao {
    EntityManager ent = new EntityManagerImpl();

    public <Department> Department findById(Class<Department> entityClass, Long id) throws SQLException, IllegalAccessException {
        return ent.findById(entityClass, id);
    }

    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException {
        return ent.getNextIdVal(tableName, columnIdName);
    }

    public <Department> Object insert(Department entity) {
        return ent.insert(entity);
    }

    public <Department> List<Department> findAll(Class<Department> entityClass) {
        return  ent.findAll(entityClass);
    }

    public <Department> Department update(Department entity) {
        return ent.update(entity);
    }

    public void delete(Object entity) {

    }

    public <Department> List<Department> findByParams(Class<Department> entityClass, Map<String, Object> params) {
        return ent.findByParams(entityClass, params);
    }
}
