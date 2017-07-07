package ro.teamnet.zerotohero.oop.graphicshape.exception;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class ExceptionPropagation {

   public void meth1() {
        int data = 100 / 0;
    }

   public void meth2() {
        meth1();
    }
    public void meth3() {
        try {
            meth2();
        } catch (Exception e) {
            System.out.println("excpetie prinsa");
        }
    }
}
