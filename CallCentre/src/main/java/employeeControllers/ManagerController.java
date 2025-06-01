package employeeControllers;

import employees.Employee;
import employees.Manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ManagerController extends EmployeeController{

    Queue<Manager> managers;
    Map<Manager, Boolean> activeManagers;

    public ManagerController(EmployeeController nextController) {
        super(nextController);
        activeManagers = new HashMap<>() ;
        managers = new LinkedList<>() ;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee instanceof Manager) {
            managers.offer((Manager) employee);
            activeManagers.put((Manager) employee, true);
            System.out.println("Manager " + employee.getName() + " added to the queue.");
        } else {
            System.out.println("Only Manager can be added to this controller.");
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employee instanceof Manager) {
            activeManagers.put((Manager) employee, false);
            System.out.println("Manager " + employee.getName() + " removed from the queue.");
        } else {
            System.out.println("Only Manager can be removed from this controller.");
        }
    }

    @Override
    public void takeCall(String callDetails) {
        Manager availableCallOperative = getAvailableManager();
        if(availableCallOperative == null){
//            System.out.println("No Manager available to take the call: " + callDetails);
            escalateCall(callDetails);
        }
        else{
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    availableCallOperative.takeCall(callDetails); // Simulate time taken to handle the call
                    managers.offer(availableCallOperative); // Re-add to the queue after taking the call
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private Manager getAvailableManager() {
        while(!managers.isEmpty()) {
            Manager manager = managers.poll();
            if (activeManagers.get(manager)) {
                return manager;
            }
        }
        return null;
    }
}
