package ro.teamnet.zerotohero.oop.exception;

import java.io.*;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class ExceptionPropagation {
    public static void main(String args[]) throws MyException, IOException{
        Math obj = new Math();
        //obj.method2(20, 0);

        //obj.readMethod("E:\\work\\text.txt");

        //obj.Method2();

        obj.Method3();
    }
}
