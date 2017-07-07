package ro.teamnet.zerotohero.oop.runapp;

import ro.teamnet.zerotohero.canvas.Canvas;
import ro.teamnet.zerotohero.oop.graphicshape.*;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class RunApp extends Circles{

    public static void main(String[] args){
        Circles circles = new Circles();
        System.out.println("The default circle area is " + circles.getAreaPub());
        circles.getAreaDef();

        Canvas canvas = new Canvas();
        canvas.paint();

        Shape shape;
        shape = new Circle(10);
        System.out.println("Circlea area: " + shape.area());

        ShapeBehaviour object;
        object = new Square(10);
        System.out.println("Sqaure area: " + object.area());

        Object p1 = new Point(10, 20);
        Object p2 = new Point(50, 100);
        Object p3 = new Point(10, 20);

        System.out.println("p1 equals p2 is " + p1.equals(p2));
        System.out.println("p1 equals p3 is " + p1.equals(p3));

    }
}
