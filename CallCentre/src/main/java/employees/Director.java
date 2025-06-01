package employees;

public class Director extends Employee{
    public Director(String name, String id) {
        super(name, id);
    }

    public void takeCall(String callDetails) {
        System.out.println("Director " + getName() + " is taking the call: " + callDetails);
    }
}
