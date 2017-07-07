package ro.teamnet.zerotohero.oop.exception;

import java.lang.*;
import java.io.*;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class Math {
    public void division(int num1, int num2) {
         System.out.println(num1/num2);
    }
    public void method1(int num1, int num2) {
         division(num1, num2);
    }
    public void method2(int num1, int num2) throws MyException {
         try{
             method1(num1, num2);
         }catch(Exception e){
            System.out.println("Exception Handled 1");
            throw new MyException("Other Exception");
        }
    }

    public String readMethod(String path) throws IOException{
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }catch(IOException e){
            System.out.println("Exception Handled 2");
            return "error";
        }
    }

    public String Method1(String path) throws IOException{
        BufferedReader br =
                new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } catch(IOException e){
            System.out.println("Exception Handled 2");
            return "error";
        } finally {
            return "done";
        }
    }

    public String Method2() throws IOException{
        BufferedReader br =
                new BufferedReader(new FileReader("E:\\work\\text.txt"));
        try {
            System.out.println(br.readLine());
            return br.readLine();
        } finally {
            if (br != null)
                br.close();
        }
    }

    public String Method3() throws IOException, ArithmeticException{
        BufferedReader br =
                new BufferedReader(new FileReader("E:\\work\\text.txt"));
        try {
            System.out.println(br.readLine());
            return br.readLine();
        }catch(IOException | ArithmeticException ex){
            String string = br.readLine();
            System.out.println("Exception Handled 2");
            br.close();
            return string;
        }
    }
}
