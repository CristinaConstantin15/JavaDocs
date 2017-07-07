package ro.teamnet.zerotohero.oop.graphicshape;


/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class Circles {

    public double getAreaPub(){
        Circle circle = new Circle();
        return circle.area();
    }

    public void getAreaDef(){
        Circle newCircle = new Circle();
        newCircle.fillColour();
        newCircle.fillColour(0);
        newCircle.fillColour(0);
    }
}
