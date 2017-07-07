package Project.exceptions;

/**
 * Created by Cristina.Constantin on 7/4/2017.
 */
public abstract class Animal {
    private String nume;
    private String numeTaraDeOrigine;

    public Animal() {
        System.out.println("Animal nou");
    }

    public Animal(String name){
        this.nume = name;
    }

    public Animal(String name1, String name2){
        this.nume = name1;
        this.numeTaraDeOrigine = name2;
    }

    public abstract void mananca(Object obj) throws AnimalManancaOmException, AnimalPeCaleDeDisparitieException, AnimalManancaAnimalException;
    public abstract void seJoaca();
    public abstract void faceBae();

    public void doarme(){
        System.out.println("Animalul doarme");
    }
}
