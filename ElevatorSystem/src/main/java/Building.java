import Buttons.ExternalButtonSymbols;

public class Building {

    public static void main(String[] args) throws InterruptedException {
        BuildingElevatorController buildingElevatorController = new BuildingElevatorController(10, 5);
        buildingElevatorController.startElevatorSystem();
        buildingElevatorController.requestElevator(3, ExternalButtonSymbols.DOWN);
        buildingElevatorController.requestElevator(5, ExternalButtonSymbols.UP);
        buildingElevatorController.stopElevatorSystem();
    }

}
