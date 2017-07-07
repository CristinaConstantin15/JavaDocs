package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {
    public AnimalZooFeroce(){
        super();
    }

    public AnimalZooFeroce(String name1){
        super(name1);
    }

    public AnimalZooFeroce(String name1, String name2) {
        super(name1, name2);
    }

    public void mananca(Object obj) throws AnimalManancaOmException, AnimalManancaAnimalException{
        if(obj instanceof Animal){
            throw new AnimalManancaAnimalException("Animal mananca animal exceptie 2");
        }
        else if(obj instanceof AngajatZoo){
            throw new AnimalManancaOmException("Animal mananca om exceptie 2");
        }else {
            System.out.println("Animal feroce mananca");
        }
    }

    public void seJoaca(){
        System.out.println("Animalul feroce se joaca");
    }
    public void faceBae(){
        System.out.println("Animalul feroce face baie");
        super.doarme();
    }

    @Override
    public void doarme(){
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
