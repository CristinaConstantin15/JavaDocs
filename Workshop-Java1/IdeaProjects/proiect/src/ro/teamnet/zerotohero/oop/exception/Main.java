package ro.teamnet.zerotohero.oop.exception;

import ro.teamnet.zerotohero.oop.graphicshape.Circle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();

//        System.out.println("Ex2: ");
//        try {
//            circle.fillColor(6);
//        } catch (MyException e) {
//            System.out.println("oooook");
//            //circle.fillColor(5);
//
//            e.printStackTrace();
//        }
//
//
//        try {
//            method();
//        } catch (MyException2 e1) {
//            System.out.println("Am prins exceptia ex4");
//            e1.printStackTrace();
//        }
//
//        //Ex6
//        tryCatchResources();

        //Ex9
        ex9();

        //Ex10
       // ex10();

    }

    static void method() throws MyException2 {
        System.out.println();
        System.out.println("Ex3: ");
        try {
            method1();
        } catch (MyException e) {
            System.out.println("Am prins exceptia ex3");
            e.printStackTrace();
            throw new MyException2("Am aruncat exceptia ex4");
        }
    }

    //Ex3
    static void method1() throws MyException {
        method2();
    }

    //Ex3
    static void method2() throws MyException {
        method3();
    }

    //Ex3
    static void method3() throws MyException {
        throw new MyException("Am aruncat exceptia ex9");
    }

    //Ex9
    static void method4() throws MyException2 {
        throw new MyException2("Am aruncat exceptia ex9");
    }

    static void tryCatchResources() {
        System.out.println();
        System.out.println("Ex6: ");
        try (BufferedReader br =
                     new BufferedReader(new FileReader("fisier.in"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("A mers!!");
        }

    }

    static void ex9() {
        try {
            method1();
            method4();
        } catch (MyException e) {
            e.printStackTrace();
            System.out.println("Ex9 - exceptia1");
        } catch (MyException2 myException2) {
            myException2.printStackTrace();
            System.out.println("Ex9 - exceptia2");
        }
    }

    static void ex10() {
        try {
            method();
            method1();
        } catch (MyException2 | MyException e) {
            System.out.println("Ex10 - exceptia1 + exceptia2");
        }
    }
}
