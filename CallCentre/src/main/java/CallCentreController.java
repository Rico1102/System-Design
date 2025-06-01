import employeeControllers.CallOperativeController;
import employeeControllers.DirectorController;
import employeeControllers.EmployeeController;
import employeeControllers.ManagerController;
import employees.CallOperative;
import employees.Director;
import employees.Manager;

public class CallCentreController {

    public EmployeeController defaultController ;
    public CallOperativeController callOperativeController ;
    public ManagerController managerController;
    public DirectorController directorController;

    public CallCentreController() {
        this.directorController = new DirectorController(null);
        this.managerController = new ManagerController(directorController);
        this.callOperativeController = new CallOperativeController(managerController);
        this.defaultController = this.callOperativeController ;
        this.addDirector();
        this.addCallOperative();
        this.addManager();
    }

    public void addDirector(){
        this.directorController.addEmployee(new Director("Director1", "D001"));
    }

    public void addManager(){
        this.managerController.addEmployee(new Manager("Manager1", "M001"));
        this.managerController.addEmployee(new Manager("Manager2", "M002"));
    }

    public void addCallOperative(){
        this.callOperativeController.addEmployee(new CallOperative("CallOperative1", "C001"));
        this.callOperativeController.addEmployee(new CallOperative("CallOperative2", "C002"));
        this.callOperativeController.addEmployee(new CallOperative("CallOperative3", "C003"));
        this.callOperativeController.addEmployee(new CallOperative("CallOperative4", "C004"));
    }

    public void takeCall(String callDetails) {
        this.defaultController.takeCall(callDetails);
    }
}
