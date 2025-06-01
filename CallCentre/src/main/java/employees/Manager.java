package employees;

public class Manager extends Employee{
    public Manager(String name, String id) {
        super(name, id);
    }

    public void takeCall(String callDetails) {
        System.out.println("Manager " + getName() + " is taking the call: " + callDetails);
    }
}
