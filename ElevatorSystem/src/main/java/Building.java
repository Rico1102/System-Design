public class Building {

    public static void main(String[] args) throws InterruptedException {
        BuildingElevatorController buildingElevatorController = new BuildingElevatorController(10, 5);
        Thread.sleep(10000);
        buildingElevatorController.stopElevatorSystem();
    }

}
