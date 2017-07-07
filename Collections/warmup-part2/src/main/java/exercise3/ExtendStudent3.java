package exercise3;

/**
 * Created by Cristina.Constantin on 7/7/2017.
 */
public class ExtendStudent3 extends Student {
    public ExtendStudent3(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        ExtendStudent3 student = (ExtendStudent3) o;
        if(!firstName.equals(student.getFirstName())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + firstName.hashCode() + lastName.hashCode();
        return result;
    }
}
