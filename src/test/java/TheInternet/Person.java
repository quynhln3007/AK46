package TheInternet;

public class Person {
    String firstName;
    String lastname;
    String due;

    public Person(String firstName, String lastname, String due) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.due = due;
    }

    public double getDue() {
        return Double.parseDouble(due.replace("$", ""));
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastname);
    }
}
