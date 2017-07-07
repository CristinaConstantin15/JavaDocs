package ro.teamnet.zerotohero.oop.graphicshape.runapp;
import  ro.teamnet.zerotohero.oop.graphicshape.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;
import ro.teamnet.zerotohero.oop.graphicshape.exception.*;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class RunApp {

    public static void main(String[] args)  {

        Circles c = new Circles();
        System.out.println("The default circle area is 2827.234567890 " + c.getAreaPub());
        c.getAreaDef();

        Canvas can = new Canvas();
        can.paint();

        Shape s = new Circle(10);
        System.out.println("shape area:" + s.area());
        ShapeBehaviour sb = new Square(10);
        System.out.println("shapeBehaviour: " + sb.area());
        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);
        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

        String w = "Ana are mere";
        MyException myE = new MyException();
        myE.PrintException(w);

        /* ex 3 - exceptii */

        ExceptionPropagation e = new ExceptionPropagation();
        e.meth3();
        System.out.println("Trece de exceptie :)");

        NestedException n = new NestedException();
        try {
            n.doSomething();
        } catch (MyException e1) {
            e1.printStackTrace();
        }



    }
}
