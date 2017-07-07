package ro.teamnet.zerotohero.oop.classes;

import ro.teamnet.zerotohero.oop.classes.abstractClasses.Animal;
import ro.teamnet.zerotohero.oop.exception.AnimalManancaOmException;
import ro.teamnet.zerotohero.oop.interfaces.AngajatZoo;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {
    public void faceBaie() {
        System.out.println("AnimalZooFeroce face baie");
    }

    public void seJoaca() {
        System.out.println("AnimalZooFeroce se joaca");
    }

    public void mananca(Object object) {
        if(object instanceof AngajatZoo) {
            throw new AnimalManancaOmException("AnimalZooFeroce: Obiectul primit ca parametru este un AngajatZoo");
        } else {
            System.out.println("AnimalZooFeroce mananca");
        }
    }

    @Override
    public void doarme() {
        super.doarme(); //se foloseste implementarea metodei doarme din superclasa
        System.out.println("Animalul feroce vaneaza");
    }
}
