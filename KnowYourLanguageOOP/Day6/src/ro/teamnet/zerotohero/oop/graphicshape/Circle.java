package ro.teamnet.zerotohero.oop.graphicshape;
/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;

    public Circle () {
        this.xPos = 2;
        this.yPos = 2;
        this.radius = 30;
    }

    public Circle (int xPos) {
        this.xPos = xPos;
        this.yPos = 2;
        this.radius = 30;
    }

    public Circle (int xPos,int  yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = 30;
    }

    public Circle (int xPos, int yPos, int radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
    }


    public double area() {
        return java.lang.Math.PI * radius * radius;
    }

    public void fillColour() {
        System.out.println(super.color);
    }

    public void fillColour(int color) {
        super.setColor(color);
        System.out.println("The circle color is now " + color);
}

    public void fillColour(float saturation) {
        super.setSaturation(saturation);
        System.out.println("The circle saturation is now " + saturation);
    }




    @Override
    public String toString() {
        return "center (" + xPos + "," + yPos + ") and radius = " + radius;
    }
}
