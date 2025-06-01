package employeeControllers;

import employees.Director;
import employees.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DirectorController extends EmployeeController{

    Queue<Director> directors;
    Map<Director, Boolean> activeDirectors;

    public DirectorController(EmployeeController nextController) {
        super(nextController);
        activeDirectors = new HashMap<>() ;
        directors = new LinkedList<>() ;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee instanceof Director) {
            directors.offer((Director) employee);
            activeDirectors.put((Director) employee, true);
            System.out.println("Director " + employee.getName() + " added to the queue.");
        } else {
            System.out.println("Only Director can be added to this controller.");
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employee instanceof Director) {
            activeDirectors.put((Director) employee, false);
            System.out.println("Director " + employee.getName() + " removed from the queue.");
        } else {
            System.out.println("Only Director can be removed from this controller.");
        }
    }

    @Override
    public void takeCall(String callDetails) {
        Director availableDirector = getAvailableManager();
        if(availableDirector == null){
//            System.out.println("No Director available to take the call: " + callDetails);
            escalateCall(callDetails);
        }
        else{
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    availableDirector.takeCall(callDetails); // Simulate time taken to handle the call
                    directors.offer(availableDirector); // Re-add to the queue after taking the call
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private Director getAvailableManager() {
        while(!directors.isEmpty()) {
            Director director = directors.poll();
            if (activeDirectors.get(director)) {
                return director;
            }
        }
        return null;
    }
}
