package ro.teamnet.zerotohero.oop.classes;

import ro.teamnet.zerotohero.oop.classes.abstractClasses.Animal;
import ro.teamnet.zerotohero.oop.exception.AnimalPeCaleDeDisparitieException;
import ro.teamnet.zerotohero.oop.interfaces.AngajatZoo;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        this.lucreaza(animal);

        animal.mananca(mancare);
        animal.seJoaca();
        animal.doarme();
        animal.faceBaie();

        if ((animal instanceof AnimalZooRar) && (mancare == null)) {
            throw new AnimalPeCaleDeDisparitieException("IngrijitorZoo: animalul primit este de tipul AnimalZooRar si macarea este null");
        }

    }

}
