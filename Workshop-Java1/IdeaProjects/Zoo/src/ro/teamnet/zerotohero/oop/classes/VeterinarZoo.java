package ro.teamnet.zerotohero.oop.classes;

import ro.teamnet.zerotohero.oop.classes.abstractClasses.Animal;
import ro.teamnet.zerotohero.oop.interfaces.AngajatZoo;

/**
 * Created by Alina.Petrescu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if (animal instanceof AnimalZooFeroce) {
            animal.faceBaie();
        }
    }
}
