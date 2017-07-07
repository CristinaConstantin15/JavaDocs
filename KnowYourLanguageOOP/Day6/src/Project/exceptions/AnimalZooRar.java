package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public class AnimalZooRar extends Animal {

    public AnimalZooRar(){
        super();
    }

    public AnimalZooRar(String name1){
        super(name1);
    }

    public AnimalZooRar(String name1, String name2){
        super(name1, name2);
    }

    public void mananca(Object obj) throws AnimalManancaOmException, AnimalManancaAnimalException{
        if(obj instanceof Animal){
            throw new AnimalManancaAnimalException("Animal mananca animal exceptie 1");
        }
        else if(obj instanceof AngajatZoo){
            throw new AnimalManancaOmException("Animal mananca om exceptie 1");
        }else {
            System.out.println("AnimalZooRar mananca");
        }
    }

    public void seJoaca(){
        System.out.println("AnimalulZooRar se joaca");
    }
    public void faceBae(){
        System.out.println("AnimalulZooRar face baie");
        super.doarme();
    }

}
