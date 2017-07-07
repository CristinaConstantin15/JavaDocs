package exercise2;

/**
 * Created by Radu.Hoaghe on 20.04.2015.
 */
public class Student {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Double averageGrade;

    public Student(Integer id, String firstName, String lastName, Double averageGrade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageGrade = averageGrade;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    // Exercise 2 a) Override the toString() method
    @Override
    public String toString() {
        String print = "";
        print += "Studentul cu id-ul " + this.getId() + " , numele " + this.getFirstName() + " , prenumele " + this.getLastName() + " are media " + this.getAverageGrade();
        return print;
    }

    // Exercise 2 c) Override the equals() method
    @Override
    public boolean equals(Object o) {
        // Exercise 2 c1) Check if the current instance is the same instance as the one from Object o
        if(this == o)
            return true;
        // Exercise 2 c2) Check if Object o is null
        if(o == null)
            return false;
        // Exercise 2 c3) Check if Object o class type is the same as the current instance's type
        if(this.getClass() != o.getClass())
            return false;
        // Exercise 2 c4) Now you know for sure that the Object o is of type Student so you
        // need to cast it to a Student type object
        Student student = (Student) o;

        // Exercise 2 c5) Check if all the fields from Student class are equal to the ones from
        // Exercise 2 c5) Object o (id, lastName, firstName, averageGrade)
        if(!id.equals(((Student) o).getId())) return false;
        if(!firstName.equals(((Student) o).getFirstName())) return false;
        if(!lastName.equals(((Student) o).getLastName())) return false;
        if(!averageGrade.equals(((Student) o).getAverageGrade())) return false;

        return true;

        // Exercise 2 d) After you finished implementing equals method go to Exercise 2 e) from Exercise2 class
    }

    // Exercise 2 g) Override the hashCode() method
    // Exercise 2 g) Hint: Don't forget to include in the hashCode result all the fields from
    // Exercise 2 g) the Student class
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode() + lastName.hashCode() + averageGrade.hashCode();

        return result;
        // Exercise 2 h) After you finished implementing hashCode go to Exercise 2 i) from Exercise2 class
    }

}
