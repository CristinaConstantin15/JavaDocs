package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        System.out.println("Square - area()");
        return side * side;
    }
}
