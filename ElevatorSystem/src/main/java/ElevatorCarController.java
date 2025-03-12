import Buttons.Button;
import Buttons.ButtonObserver;
import Buttons.InternalButton;
import Buttons.InternalButtonSymbols;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ElevatorCarController implements ButtonObserver {

    private final ElevatorCar elevatorCar;
    private Floor currentFloor;
    private boolean isMoving;

    private boolean isCalled; //to check if the elevator is called to a floor

    private Floor destinationFloor;

    private Direction direction;

    private final Set<Integer> floorsToVisit = new HashSet<>();

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition condition = lock.newCondition();

    public ElevatorCarController(Floor floor, int elevatorCarId) {
        this.elevatorCar = new ElevatorCar(elevatorCarId);
        this.currentFloor = floor;
        for (Button button : elevatorCar.getButtons()) {
            button.addObserver(this);
        }
        this.isMoving = false;
    }

    public void acceptRequest(int floorNumber) {
        try{
            lock.lock();
            isCalled = true ;
            System.out.println("Elevator " + elevatorCar.getCarId() + " is moving to floor " + floorNumber);
            floorsToVisit.add(floorNumber);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    private void moveElevator() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                lock.lock();
                while (floorsToVisit.isEmpty()) {
                    isMoving = false;
                    this.elevatorCar.setDirection(Direction.STATIONARY);
                    condition.await();
                }
                isMoving = true;
                int nextFloor = floorsToVisit.iterator().next();
                if(currentFloor.getFloorNumber() == nextFloor){
                    System.out.println("Elevator " + this.elevatorCar.getCarId() + " has reached floor " + nextFloor);
                    floorsToVisit.remove(nextFloor);
                    this.elevatorCar.setDirection(Direction.STATIONARY);
                    this.isCalled = false ;
                    Thread.sleep(5000);
                } else if(currentFloor.getFloorNumber() < nextFloor){
                    this.elevatorCar.setDirection(Direction.UP);
                    currentFloor = currentFloor.getNextFloor();
                    Thread.sleep(1000);
                } else {
                    this.elevatorCar.setDirection(Direction.DOWN);
                    currentFloor = currentFloor.getPreviousFloor();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    public void onButtonPress(Button button) {
        InternalButton internalButton = (InternalButton) button;
        if (((InternalButtonSymbols) button.getSymbol()).isFloorButton()) {
            try{
                lock.lock();
                //TODO: Implement logic to move the elevator to the requested floor
                System.out.println("Adding the request to queue " + internalButton.getFloorNumber());
                floorsToVisit.add(internalButton.getFloorNumber());
                condition.signal();
            } finally {
                lock.unlock();
            }
        } else {
            //TODO: Implement logic to open/close the door
        }
    }

    public Runnable startElevator(){
        return this::moveElevator;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isCalled() {
        return isCalled;
    }

    public void setCalled(boolean called) {
        isCalled = called;
    }

    public Floor getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(Floor destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Set<Integer> getFloorsToVisit() {
        return floorsToVisit;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public Condition getCondition() {
        return condition;
    }
}
