package exercise3;

/**
 * Created by Cristina.Constantin on 7/7/2017.
 */
public class ExtendStudent2 extends Student{
    public ExtendStudent2(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        ExtendStudent2 student = (ExtendStudent2) o;
        if(!firstName.equals(student.getFirstName())) return false;
        if(!lastName.equals(student.getLastName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + firstName.hashCode();

        return result;
    }
}
