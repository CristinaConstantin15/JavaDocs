package ro.teamnet.zerotohero.oop.graphicshape.exception;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class NestedException {

    public void doSomething() throws MyException{

        try{

            System.out.println("ceva 1");

        } catch (Exception e){
            System.out.println("primesc exceptia " + e);
            throw new MyException();

        }

    }
}
