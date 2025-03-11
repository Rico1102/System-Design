import Buttons.Button;
import Buttons.ExternalButton;
import Buttons.ExternalButtonSymbols;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final int floorNumber;

    List<Button> buttons;

    Floor previousFloor;
    Floor nextFloor;

    public Floor(Integer floorNumber, int numberOfElevators){
        this.floorNumber = floorNumber;
        this.buttons = new ArrayList<>();
        for(int i=1 ; i<=numberOfElevators ; ++i){
            buttons.add(new ExternalButton(ExternalButtonSymbols.valueOf("UP"), floorNumber));
            buttons.add(new ExternalButton(ExternalButtonSymbols.valueOf("DOWN"), floorNumber));
        }
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Floor getPreviousFloor() {
        return previousFloor;
    }

    public Floor getNextFloor() {
        return nextFloor;
    }

    public void setPreviousFloor(Floor previousFloor) {
        this.previousFloor = previousFloor;
    }

    public void setNextFloor(Floor nextFloor) {
        this.nextFloor = nextFloor;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
