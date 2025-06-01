package employees;

public class CallOperative extends Employee{

    public CallOperative(String name, String id) {
        super(name, id);
    }

    public void takeCall(String callDetails) {
        System.out.println("Call Operative " + getName() + " is taking the call: " + callDetails);
    }
}
