package ro.teamnet.zerotohero.oop.runapp;

import java.util.Date;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class Immutable {
    private final double fMass;
    private final String fName;
    private final Date fDateOfDiscovery;

    public Immutable(double fMass, java.lang.String fName, Date fDateOfDiscovery) {
        this.fMass = fMass;
        this.fName = fName;
        this.fDateOfDiscovery = fDateOfDiscovery;
    }

    public double getMass() {
        return fMass;
    }

    public Date getDateOfDiscovery() {
        return new Date(fDateOfDiscovery.getTime());
    }

}
