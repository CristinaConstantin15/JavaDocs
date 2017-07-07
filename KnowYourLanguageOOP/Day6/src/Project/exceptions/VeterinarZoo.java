package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    private int bonus = 0;

    public void lucreaza(Animal animal){
        if(animal instanceof AnimalZooFeroce){
            animal.faceBae();
        }
        System.out.println("Veterinarul are grija de animal");
    }

    @Override
    public void calculeazaBonusSalarial(){
        bonus += 2 * valoareBonusPerAnimal;
        System.out.println("Bonus: " + bonus);
    }


}
