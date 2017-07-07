package exercise3;

import java.util.*;
import java.lang.*;

/**
 * Created by Cristina.Constantin on 7/7/2017.
 */
public class MainClass {
    public static  void main(String[] args){
        Map<Student, Integer> student1 = new HashMap<Student, Integer>();
        Map<Student, Integer> student2 = new HashMap<Student, Integer>();
        Map<Student, Integer> student3 = new HashMap<Student, Integer>();
        Map<Student, Integer> student4 = new HashMap<Student, Integer>();

        extendStudent s1 = new extendStudent("Popescu", "Ioana");
        extendStudent s2 = new extendStudent("Popescu", "Ioan");
        extendStudent s3 = new extendStudent("God", "Father");

        ExtendStudent2 s11 = new ExtendStudent2("Popescu", "Ioana");
        ExtendStudent2 s12 = new ExtendStudent2("Popescu", "Ioan");
        ExtendStudent2 s13 = new ExtendStudent2("God", "Father");

        ExtendStudent3 s21 = new ExtendStudent3("Popescu", "Ioana");
        ExtendStudent3 s22 = new ExtendStudent3("Popescu", "Ioan");
        ExtendStudent3 s23 = new ExtendStudent3("God", "Father");

        ExtendStudent4 s31 = new ExtendStudent4("Popescu", "Ioana");
        ExtendStudent4 s32 = new ExtendStudent4("Traian", "Ioan");
        ExtendStudent4 s33 = new ExtendStudent4("God", "Father");

        student1.put(s1, 20);
        student1.put(s2, 18);
        student1.put(s3, 24);

        student2.put(s11, 20);
        student2.put(s12, 18);
        student2.put(s13, 24);

        student3.put(s21, 20);
        student3.put(s22, 18);
        student3.put(s23, 24);

        student4.put(s31, 20);
        student4.put(s32, 18);
        student4.put(s33, 24);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println(student4);

    }
}
