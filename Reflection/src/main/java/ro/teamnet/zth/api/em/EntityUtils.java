package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristina.Constantin on 7/12/2017.
 */
public class EntityUtils {

    private EntityUtils() throws UnsupportedOperationException {

    }

    public static String getTableName (Class entity){
        Annotation[] ann = entity.getAnnotations();
        for(Annotation a : ann){
            if(a.annotationType().equals(Table.class))
                return ((Table)a).name();
        }
        return entity.getName();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity){
        ArrayList<ColumnInfo> list = new ArrayList<ColumnInfo>();
        Field[] fields = entity.getDeclaredFields();

        for(Field f : fields) {
            if (f.isAnnotationPresent(Column.class) ||
                    f.isAnnotationPresent(Id.class)) {
                ColumnInfo onj = new ColumnInfo();
                onj.setColumnName("");
                onj.setDbColumnName("");
                onj.setColumnType(null);
                onj.setId(false);
                onj.setValue(0);
                list.add(onj);
            }
        }
        return list;
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Integer")){
            return (Integer)value;
        }else if(value instanceof BigDecimal && wantedType.getClass().getName().equals("Long")){
            return (Long)value;
        }else if(value instanceof  BigDecimal && wantedType.getClass().getName().equals("Float")){
            return (Float)value;
        }else if(value instanceof  BigDecimal && wantedType.getClass().getName().equals("Double")){
            return (Double)value;
        }else if(!(value instanceof BigDecimal)){
            return value;
        }else{
            return  null;
        }
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        ArrayList<Field> list = new ArrayList<Field>();

        Field[] fields = clazz.getDeclaredFields();
        for(Field f : list){
            if(f.getAnnotations().getClass().getName().equals(annotation.getClass().getName())){
                list.add(f);
            }
        }
        return list;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object.getClass().isAnnotationPresent(Table.class)){
            Field[] fields = object.getClass().getFields();
            for(Field f : fields){
                if(f.isAnnotationPresent(Id.class)){
                    f.setAccessible(true);
                    return f.get(object);
                }
            }
        }
        return object;
    }
}
