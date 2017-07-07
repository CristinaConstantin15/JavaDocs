package ro.teamnet.zerotohero.oop.classes;

import ro.teamnet.zerotohero.oop.classes.abstractClasses.Animal;
import ro.teamnet.zerotohero.oop.exception.AnimalManancaOmException;
import ro.teamnet.zerotohero.oop.interfaces.AngajatZoo;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {
    private String nume;
    private String numeleTariiDeOrigine;

    public AnimalZooRar() {
        this.nume = "";
        this.numeleTariiDeOrigine = "";
    }

    public AnimalZooRar(String nume) {
        this.nume = nume;
    }

    public AnimalZooRar(String nume, String numeleTariiDeOrigine) {
        this.nume = nume;
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setNumeleTariiDeOrigine(String numeleTariiDeOrigine) {
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    public String getNume() {
        return nume;
    }

    public String getNumeleTariiDeOrigine() {
        return numeleTariiDeOrigine;
    }

    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }

    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }

    public void mananca(Object object) {
        if(object instanceof AngajatZoo) {
            throw new AnimalManancaOmException("AnimalZooRar: Obiectul primit ca parametru este un AngajatZoo");
        } else {
            System.out.println("AnimalZooRar mananca");
        }
    }


}
