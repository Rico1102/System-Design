import Buttons.Button;
import Buttons.ButtonObserver;
import Buttons.ExternalButton;
import Buttons.ExternalButtonSymbols;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class BuildingElevatorController implements ButtonObserver {

    List<Floor> floors;

    List<ElevatorCarController> elevatorCarControllers;

    Map<ElevatorCarController, Future<?>> elevatorCarControllerFutureMap = new HashMap<>();

    ExecutorService executorService;

    public BuildingElevatorController(int noOfFloors, int noOfElevatorCars) {
        this.floors = new ArrayList<>();
        this.elevatorCarControllers = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(noOfElevatorCars + 1); //1 extra thread for showing the status of elevators
        for (int i = 0; i < noOfFloors; ++i) {
            floors.add(new Floor((i + 1), noOfElevatorCars));
        }
        for (int i = 0; i < noOfFloors; ++i) {
            if (i != noOfFloors - 1) {
                floors.get(i).setNextFloor(floors.get(i + 1));
            }
            if (i != 0) {
                floors.get(i).setPreviousFloor(floors.get(i - 1));
            }
        }
        for (Floor floor : floors) {
            for (Button button : floor.getButtons()) {
                button.addObserver(this);
            }
        }
        for (int i = 0; i < noOfElevatorCars; ++i) {
            elevatorCarControllers.add(new ElevatorCarController(floors.get(0), i + 1));
        }
    }

    public void startElevatorSystem() {
        for (ElevatorCarController elevatorCarController : elevatorCarControllers) {
            Future<?> future = executorService.submit(elevatorCarController.startElevator());
            elevatorCarControllerFutureMap.put(elevatorCarController, future);
        }
        executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (!Thread.currentThread().isInterrupted()) {
                showElevatorStatus();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public void showElevatorStatus() {
        System.out.println("--------------------Elevator Status----------------------");
        for (ElevatorCarController elevatorCarController : elevatorCarControllers) {
            //TODO: implement logic to show the status of each elevator
            System.out.println("Elevator " + elevatorCarController.getElevatorCar().getCarId() + " is at floor " + elevatorCarController.getCurrentFloor().getFloorNumber() + " and is " +
                    (elevatorCarController.getElevatorCar().getDirection() == Direction.STATIONARY ? " Stationary " : " moving in direction : " + elevatorCarController.getElevatorCar().getDirection()));
        }
        System.out.println("--------------------------------------------------------");
    }

    @Override
    public void onButtonPress(Button button) {
        System.out.println("Request received from floor " + ((ExternalButton) button).getFloorNumber() + " for direction " + ((ExternalButton) button).getSymbol());
        ExternalButton externalButton = (ExternalButton) button;
        ElevatorCarController selectedElevator = null;
        if (externalButton.getSymbol() == ExternalButtonSymbols.UP) {
            long timeToReach = Long.MAX_VALUE;
            //Try to find the elevator which is closest to this floor and is moving in the upward direction
            for (ElevatorCarController elevatorCarController : elevatorCarControllers) {
                if (!elevatorCarController.isCalled() && elevatorCarController.getElevatorCar().getDirection() == Direction.UP) {
                    if (elevatorCarController.getCurrentFloor().getFloorNumber() < externalButton.getFloorNumber()) {
                        if (timeToReach > Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber())) {
                            timeToReach = Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber());
                            selectedElevator = elevatorCarController;
                        }
                    }
                } else if (!elevatorCarController.isCalled() && elevatorCarController.getElevatorCar().getDirection() == Direction.STATIONARY) {
                    if (timeToReach > Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber())) {
                        timeToReach = Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber());
                        selectedElevator = elevatorCarController;
                    }
                }
            }
        } else if (externalButton.getSymbol() == ExternalButtonSymbols.DOWN) {
            //Try to find the elevator which is closest to this floor and is moving in the downward direction
            long timeToReach = Long.MAX_VALUE;
            //Try to find the elevator which is closest to this floor and is moving in the upward direction
            for (ElevatorCarController elevatorCarController : elevatorCarControllers) {
                if (!elevatorCarController.isCalled() && elevatorCarController.getElevatorCar().getDirection() == Direction.DOWN) {
                    if (elevatorCarController.getCurrentFloor().getFloorNumber() < externalButton.getFloorNumber()) {
                        if (timeToReach > Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber())) {
                            timeToReach = Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber());
                            selectedElevator = elevatorCarController;
                        }
                    }
                } else if (!elevatorCarController.isCalled() && elevatorCarController.getElevatorCar().getDirection() == Direction.STATIONARY) {
                    if (timeToReach > Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber())) {
                        timeToReach = Math.abs(elevatorCarController.getCurrentFloor().getFloorNumber() - externalButton.getFloorNumber());
                        selectedElevator = elevatorCarController;
                    }
                }
            }
        }
        if (selectedElevator != null) {
            System.out.println("Selected elevator is " + selectedElevator.getElevatorCar().getCarId() + " to serve the request");
            selectedElevator.acceptRequest(externalButton.getFloorNumber());
        } else {
            //TODO: Implement logic when no elevator is free and all are moving in opposite direction
        }
    }

    public void requestElevator(int floorNumber, ExternalButtonSymbols direction) {
        for (Floor floor : floors) {
//            System.out.println("Checking floor: " + floor.getFloorNumber());
            if (floor.getFloorNumber() == floorNumber) {
//                System.out.println("Floor Selected: " + floorNumber + " Direction: " + direction);
                for (Button button : floor.getButtons()) {
                    if (button instanceof ExternalButton) {
                        if (((ExternalButton) button).getSymbol() == direction) {
//                            System.out.println("Button - Request received from floor " + floorNumber + " for direction " + direction);
                            button.onPress();
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

    public void stopElevatorSystem() throws InterruptedException {
        executorService.shutdownNow();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Shutting down the elevator system");
    }
}
