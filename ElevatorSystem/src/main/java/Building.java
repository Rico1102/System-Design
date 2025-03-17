import Buttons.ExternalButtonSymbols;

public class Building {

    public static void main(String[] args) throws InterruptedException {
        BuildingElevatorController buildingElevatorController = new BuildingElevatorController(10, 5);
        buildingElevatorController.startElevatorSystem();
        buildingElevatorController.requestElevator(3, ExternalButtonSymbols.DOWN);
        buildingElevatorController.requestElevator(5, ExternalButtonSymbols.UP);
        Thread.sleep(5000);
        buildingElevatorController.requestElevator(2, ExternalButtonSymbols.DOWN);
        Thread.sleep(15000);
        buildingElevatorController.stopElevatorSystem();
    }

}
