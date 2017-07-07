package ro.teamnet.zerotohero.oop.exception;


/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class Foo {
    public void bar() throws MyException {
        throw new MyException("Try again please");
    }
}
