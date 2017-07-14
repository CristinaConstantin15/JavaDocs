package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristina.Constantin on 7/13/2017.
 */
public interface EntityManager {
    <T> T findById(Class<T> entityClass, Long id) throws SQLException, IllegalAccessException;
    Long getNextIdVal(String tableName, String columnIdName) throws SQLException;
    <T> Object insert(T entity);
    <T> List<T> findAll(Class<T> entityClass);
    <T> T update(T entity);
    void delete(Object entity);
    <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params);
    List<Employee> match(Class<Employee> entityClass, Class<Department> entityClass, String param);
}
