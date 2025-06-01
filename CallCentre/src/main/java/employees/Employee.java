package employees;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Employee {

    private String name;
    private String id;

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    abstract public void takeCall(String callDetails);
}
