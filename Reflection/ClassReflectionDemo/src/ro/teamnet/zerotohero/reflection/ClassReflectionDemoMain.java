package ro.teamnet.zerotohero.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;

/**
 * TODO
 * in order to resolve the exercises below, you will have to create
 * all the needed clasees, with their members and methods
 * (in ro.teamnet.zerotohero.reflection.demoobjects package)
 */

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

class SuperSuperClass extends  SuperClass {
    @Override
    public String toString(){
        return "SuperSuperClass";
    }
}

class SuperClass extends Primitive{
    @Override
    public String toString(){
        return "SuperClass";
    }
}

class Primitive {
    public String name;
    private String cnp;

    public Primitive() {
        this.name = "Cristina";
    }

    public Primitive(String string){
        this.name = string;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    class Class1{

    }

    class Class2{

    }

    class Class3{

    }
}


public class ClassReflectionDemoMain {
    public static void main(String[] args) throws Exception{
        System.out.println("TODO 1:");
        //get the class for a String object, and print it
		Class stringClass = "myString".getClass();
		System.out.println("getName(): " + stringClass.getName());
		System.out.println("getStringName(): " + stringClass.getSimpleName());
		System.out.println("getCanonicalName(): " + stringClass.getCanonicalName());

		System.out.println("TODO 2:");
        //get the class of an Enum, and print it
        Class enumClass = Day.SUNDAY.getClass();
        System.out.println("getClass(): " + enumClass);

        System.out.println("TODO 3:");
        //get the class of a collection, and print it
        Class collectionClass = (new HashMap()).getClass();
        System.out.println("getClass(): " + collectionClass);

        System.out.println("TODO 4:");
        //get the class of a primitive type, and print it
        int constant = 100;
        System.out.println("getClass(): " + Integer.valueOf(constant).getClass());

        System.out.println("TODO 5:");
        Primitive primi = new Primitive();
        Field f = Primitive.class.getDeclaredField("name");
        String value = (String) f.get(primi);
        System.out.println("name = " + value);

        System.out.println("TODO 6:");
        //get and print the class for a primitive type, using the wrapper class
        Class wrapperClass = Integer.TYPE;
        System.out.println("class: " + wrapperClass);

        System.out.println("TODO 7:");
        //get the class for a specified class name
        Class classClass = Class.forName("ro.teamnet.zerotohero.reflection.Primitive");
        System.out.println(classClass);

        System.out.println("TODO 8:");
        //get the superclass of a class, and print it
        Class superClass = SuperClass.class.getSuperclass();
        System.out.println("SuperClass " + superClass);

        System.out.println("TODO 9:");
        //get the superclass of the superclass above, and print it
        Class superSuperClass = SuperSuperClass.class.getSuperclass();
        System.out.println("SuperSuperClass " + superSuperClass);

        System.out.println("TODO 10:");
        //get and print the declared classes within some other class
        Class[] multiClass = Primitive.class.getDeclaredClasses();
        //System.out.println(multiClass);
        for(Class i : multiClass){
            System.out.println(i);
        }

        System.out.println("TODO 11:");
        //print the number of constructors of a class
        int count = Primitive.class.getDeclaredConstructors().length;
        System.out.println(count);

        System.out.println("TODO 12:");
        //get and invoke a public constructor of a class
        Primitive classy = (Primitive)Primitive.class.getDeclaredConstructor(String.class).newInstance("hello");
        System.out.println(classy);

        System.out.println("TODO 13:");
        //get and print the class of one private field
        Field field = Primitive.class.getDeclaredField("cnp");
        System.out.println(field.getType());

        System.out.println("TODO 14:");
		//set and print the value of one private field for an object
        Primitive obj = new Primitive();
        Field field2 = obj.getClass().getDeclaredField("cnp");
        field2.setAccessible(true);
        field2.set(obj, "1234567890");
        System.out.println(field2.get(obj));

        System.out.println("TODO 15:");
        //get and print only the public fields class
        Primitive obj2 = new Primitive();
        Field[] publicFields = obj2.getClass().getFields();
        for(Field i : publicFields){
            System.out.println(i);
        }

        System.out.println("TODO 16:");
        //get and invoke one public method of a class
        Primitive obj3 = new Primitive();
        Method method = obj3.getClass().getDeclaredMethod("getName");
        method.invoke(obj3);

        System.out.println("TODO 17:");
        //get and invoke one inherited method of a class
        SuperClass obj4 = new SuperClass();
        Method method2 = obj4.getClass().getMethod("getName");
        method2.invoke(obj4);

        System.out.println("TODO 18:");
		//invoke a method of a class the classic way for 100 times, and print the timestamp (System.currentTimeMillis())
        Primitive obj5 = new Primitive();
        int count2 = 100;
        long start1 = System.currentTimeMillis();
        while(count2 > 0){
            obj5.getName();
            count2--;
        }
        long end1 = System.currentTimeMillis();
        long rez2 = end1 - start1;
        System.out.println("Primul rezultat " +  rez2);

		//invoke a method of a class by Reflection for 100 times, and print the timestamp
		//what do you observe?
        Primitive obj6 = new Primitive();
        int c = 100;
        Method methodNew = obj6.getClass().getDeclaredMethod("getName");
        long start2 = System.currentTimeMillis();
        while(c > 0){
            methodNew.invoke(obj6);
            c--;
        }
        long end2 = System.currentTimeMillis();
        long rez2 = end2 - start2;
        System.out.println("Al doilea rezultat: " + rez2);


		
    }
}
