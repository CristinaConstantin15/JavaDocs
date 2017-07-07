package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class RunApp {
    public static void main(String[] args) {
        Circles circles = new Circles();
        Canvas canvas = new Canvas();
        Shape shape = new Circle(10);
        ShapeBehaviour shapeBehaviour = new Square(10);

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("The default circle area is: " + circles.getAreaPub());

        circles.getAreaDef();

        canvas.paint();

        System.out.println("Ex 20:");
        shape.area();

        shapeBehaviour.area();

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
