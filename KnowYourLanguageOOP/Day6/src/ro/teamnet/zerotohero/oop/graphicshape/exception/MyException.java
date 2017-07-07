package ro.teamnet.zerotohero.oop.graphicshape.exception;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class MyException extends Exception {

    public MyException()  {
    }

    public MyException(String message) {
        super(message);
    }

    public void PrintException(String w) {
        try {
            if (w.contains(" ")) {
                throw new MyException();
            }
        } catch(MyException e) {
            System.out.println("Exceptia este " + e);
        }
    }
}
