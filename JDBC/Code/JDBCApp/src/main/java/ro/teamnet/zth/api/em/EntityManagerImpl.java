package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ro.teamnet.zth.api.em.EntityUtils.*;

/**
 * Created by Cristina.Constantin on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager{

    @Override
    public <T> T findById(Class<T> entityClass, Long id) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableName = getTableName(entityClass);
        List<ColumnInfo> columns = getColumns(entityClass);
        List<Field> fields = getFieldsByAnnotations(entityClass, entityClass);

        Condition cond = new Condition();
        cond.setValue(id);
        for(ColumnInfo col : columns){
            if(col.isId()){
                cond.setColumnName(col.getDbColumnName());
            }
        }

        QueryBuilder query = new QueryBuilder();
        query.setQueryType(QueryType.SELECT);
        query.setTableName(tableName);
        query.addQueryColumns(columns);
        query.addCondition(cond);
        String q = query.createQuery();

        //System.out.println(q);

        try{
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(q);
            if(rst.next()){
                T instance = null;
                try {
                    instance = entityClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                for(ColumnInfo col : columns){
                    assert instance != null;
                    Field f = instance.getClass().getDeclaredField(col.getColumnName());
                    f.setAccessible(true);
                    try {
                        f.set(instance, castFromSqlType(rst.getObject(col.getDbColumnName()),f.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
                //System.out.println(instance);
                return instance;
            }
        }catch(NoSuchFieldException | SQLException exp) {
            exp.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getNextIdVal(String tableName, String columnIdName) throws SQLException{
        Connection con = DBManager.getConnection();
        Long id = null;

        String sqlCommand = "SELECT MAX(" + columnIdName + ")" + " FROM " + tableName;

        try{
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(sqlCommand);
            while(rst.next()){
                id = rst.getLong(1);
                id++;
            }

        }catch(SQLException exp){
            exp.printStackTrace();
        }
        return id;
    }

    @Override
    public <T> Object insert(T entity) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableName = getTableName(entity.getClass());
        List<ColumnInfo> columns = getColumns(entity.getClass());

        for(ColumnInfo col : columns){
            if(col.isId()){
                try {
                    col.setValue(getNextIdVal(tableName, col.getDbColumnName()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Field f = entity.getClass().getDeclaredField(col.getColumnName());
                    f.setAccessible(true);
                    try {
                        col.setValue(f.get(entity));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }

        QueryBuilder query = new QueryBuilder();
        query.setQueryType(QueryType.INSERT);
        query.addQueryColumns(columns);
        query.setTableName(tableName);
        String q = query.createQuery();
        //System.out.println(q);

        try {
            assert con != null;
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(q);
            return findById(entity.getClass(), 271L);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tableName = getTableName(entityClass);
        List<ColumnInfo> columns = getColumns(entityClass);

        QueryBuilder query = new QueryBuilder();
        query.setQueryType(QueryType.SELECT);
        query.setTableName(tableName);
        query.addQueryColumns(columns);
        String q = query.createQuery();

        System.out.println(q);

        List<T> list = new ArrayList<T>();

        try{
            assert con != null;
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery(q);

            while(rst.next()){
                T instance = null;
                try {
                    instance = entityClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                for(ColumnInfo col : columns){
                    assert instance != null;
                    Field f = null;
                    try {
                        f = instance.getClass().getDeclaredField(col.getColumnName());
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    assert f != null;
                    f.setAccessible(true);
                    try {
                        f.set(instance, castFromSqlType(rst.getObject(col.getDbColumnName()),f.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    list.add(instance);
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
