package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class Circles {

    public double getAreaPub() {
        Circle c = new Circle();
        return c.area();
    }

    public void getAreaDef() {
        Circle c = new Circle();
        c.fillColour();
        c.fillColour(2);
        c.fillColour(3.4f);
    }

}
