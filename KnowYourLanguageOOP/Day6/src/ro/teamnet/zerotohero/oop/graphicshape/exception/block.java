package ro.teamnet.zerotohero.oop.graphicshape.exception;

import java.io.IOException;

/**
 * Created by ramona.raducu on 7/4/2017.
 */
public class block {

    public void meth1() {
        try {
            System.out.println("Ana are mere");
        } catch (Exception e) {
            System.out.println("Excetia este " + e);
        } finally {
            System.out.println("Am ajuns in final");
        }
    }

    public void meth2() {
        try {
            System.out.println("Ana are pere");
        }catch(Exception ex1) {
            System.out.println("IOException ex " + ex1);
        }
    }
}
