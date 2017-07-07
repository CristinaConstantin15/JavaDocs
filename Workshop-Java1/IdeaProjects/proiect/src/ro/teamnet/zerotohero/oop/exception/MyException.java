package ro.teamnet.zerotohero.oop.exception;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
        //System.out.println("MyException1");
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}
