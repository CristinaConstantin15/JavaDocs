/**
 * Created by Alina.Petrescu on 7/4/2017.
 */

package ro.teamnet.zerotohero.oop.graphicshape;

import ro.teamnet.zerotohero.oop.exception.MyException;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 0;
    }

    public Circle(int xPos) {
        this();
        this.xPos = xPos;
    }

    public Circle(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Circle(int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }

    @Override
    public double area() {
        System.out.println("Circle - area()");
        return PI * pow(this.radius, 2);
    }

    public String toString() {
        return "center = (" + this.yPos + ", " + this.yPos + ") and radius = " + this.radius;
    }

    public void fillColor() throws MyException {

        System.out.println("fillColor(): " + super.color);
        //throw new MyException("abcd");
    }

    public void fillColor(int color) throws MyException {
        if(color > 5){
            throw new MyException("mesaaaaaj");
        }
        super.setColor(color);
        System.out.println("This circle color is now 2.");
    }

    public void fillColor(float saturation) {
        super.setSaturation(saturation);
    }
}
