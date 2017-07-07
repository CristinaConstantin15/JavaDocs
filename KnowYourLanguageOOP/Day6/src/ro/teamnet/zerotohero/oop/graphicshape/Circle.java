package ro.teamnet.zerotohero.oop.graphicshape;

import java.lang.*;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class Circle extends Shape {
    private int xPos;
    private int yPos;
    private int radius;

    public Circle() {
        this.xPos = 4;
        this.yPos = 3;
        this.radius = 3;
    }

    public Circle(int x){
        this.xPos = x;
        this.yPos = 3;
        this.radius = 3;
    }

    public Circle(int x, int y){
        this.xPos = x;
        this.yPos = y;
        this.radius = 3;
    }

    public Circle(int x, int y, int z){
        this.xPos = x;
        this.yPos = y;
        this.radius = z;
    }

    @Override
    public double area(){
        return 2 * 3.14 * radius * radius;
    }

    @Override
    public String toString(){
        String string = "";
        return string + "center = (" + this.xPos + "," + this.yPos + ")" + " and radius = " + this.radius;
    }

    public void fillColour(){

        System.out.println("Color: " + color);
    }

    public void fillColour(int newColor){
        super.setColor(newColor);
        System.out.println("The circle color is now " + color);
    }

    public void fillColour(float newSaturation){
        super.setSaturation(newSaturation);
    }
}
