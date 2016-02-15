/**
 * Created by ericweidman on 2/15/16.
 */
public class Person {
    int id;
    String firstName;
    String lastName;
    String emailAdd;
    String country;
    String ipAdd;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public String getCountry() {
        return country;
    }

    public String getIpAdd() {
        return ipAdd;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAdd='" + emailAdd + '\'' +
                ", country='" + country + '\'' +
                ", ipAdd='" + ipAdd + '\'' +
                '}';
    }

    public Person(int id, String firstName, String lastName, String emailAdd, String country, String ipAdd) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdd = emailAdd;
        this.country = country;
        this.ipAdd = ipAdd;




    }
}
