package ro.teamnet.zth.web;

/**
 * Created by Cristina.Constantin on 7/18/2017.
 */
public class Person {
        private String firstName;
        private String lastName;
        private int age;
        private Boolean married;

    public Person(String firstName, String lastName, int age, Boolean married) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.married = married;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    @Override
    public String toString(){
        String s = "";
        return s + this.firstName + " " + this.lastName + " " + this.age + " " + this.married;
    }
}
