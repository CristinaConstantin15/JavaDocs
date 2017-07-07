package ro.teamnet.zerotohero.oop.exception;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class MyException2 extends Exception {
    public MyException2(String message) {
        super(message);
        //System.out.println("MyException2");
    }

    public MyException2(String message, Throwable cause) {
        super(message, cause);
    }
}