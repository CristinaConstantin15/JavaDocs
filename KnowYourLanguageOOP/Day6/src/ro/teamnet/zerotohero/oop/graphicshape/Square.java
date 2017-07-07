package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
