package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    private int bonus = 0;

    public void lucreaza(Animal animal){
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    public  void lucreaza(Animal animal, Object mananca) throws AnimalPeCaleDeDisparitieException, AnimalManancaOmException{
        if(animal instanceof  AnimalZooRar && mananca == null){
            throw new AnimalPeCaleDeDisparitieException("Animal pe cale de disparitie");
        }else{
            this.lucreaza(animal);
            animal.mananca(mananca);
            animal.seJoaca();
            animal.faceBae();
        }

    }

    @Override
    public void calculeazaBonusSalarial(){
        bonus += 3 * valoareBonusPerAnimal;
        System.out.println("Bonus: " + bonus);
    }
}
