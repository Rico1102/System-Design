package employeeControllers;

import employees.CallOperative;
import employees.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CallOperativeController extends EmployeeController  {

    Queue<CallOperative> callOperatives;
    Map<CallOperative, Boolean> activeCallOperatives;

    public CallOperativeController(EmployeeController nextController) {
        super(nextController);
        activeCallOperatives = new HashMap<>();
        callOperatives = new LinkedList<>();
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee instanceof CallOperative) {
            callOperatives.offer((CallOperative) employee);
            activeCallOperatives.put((CallOperative) employee, true);
            System.out.println("Call Operative " + employee.getName() + " added to the queue.");
        } else {
            System.out.println("Only Call Operatives can be added to this controller.");
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employee instanceof CallOperative) {
            activeCallOperatives.put((CallOperative) employee, false);
            System.out.println("Call Operative " + employee.getName() + " removed from the queue.");
        } else {
            System.out.println("Only Call Operatives can be removed from this controller.");
        }
    }

    @Override
    public void takeCall(String callDetails) {
        CallOperative availableCallOperative = getAvailableCallOperative();
        if(availableCallOperative == null){
//            System.out.println("No Call Operatives available to take the call: " + callDetails);
            escalateCall(callDetails);
        }
        else{
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    availableCallOperative.takeCall(callDetails); // Simulate time taken to handle the call
                    callOperatives.offer(availableCallOperative); // Re-add to the queue after taking the call
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private CallOperative getAvailableCallOperative() {
        while(!callOperatives.isEmpty()) {
            CallOperative callOperative = callOperatives.poll();
            if (activeCallOperatives.get(callOperative)) {
                return callOperative;
            }
        }
        return null;
    }
}
