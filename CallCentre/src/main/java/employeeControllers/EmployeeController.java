package employeeControllers;

import employees.Employee;

public abstract class EmployeeController {

    public EmployeeController nextController;

    public EmployeeController(EmployeeController nextController) {
        this.nextController = nextController;
    }

    abstract public void addEmployee(Employee employee) ;

    abstract public void removeEmployee(Employee employee) ;

    abstract public void takeCall(String callDetails) ;

    public void escalateCall(String callDetails) {
        if(this.nextController != null) {
            this.nextController.takeCall(callDetails);
        } else {
            System.out.println("No higher authority to escalate the call: " + callDetails);
        }
    }

}
