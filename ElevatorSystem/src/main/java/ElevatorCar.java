import Buttons.Button;
import Buttons.InternalButton;
import Buttons.InternalButtonSymbols;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ElevatorCar {

    private final String carId;

    private final String capacity;

    private Direction direction;

    private boolean isMoving;

    private boolean isCalled; //to check if the elevator is called to a floor

    List<Button> buttons;

    public ElevatorCar(int elevatorCarId){
        this.carId = elevatorCarId + "";
        this.capacity = "10";
        this.direction = Direction.STATIONARY;
        this.buttons = new ArrayList<Button>();
        this.isCalled = false;
        this.isMoving = false;
        for(int i=1 ; i<=9 ; ++i){
            buttons.add(new InternalButton(InternalButtonSymbols.getInternalButtonSymbol(i+""), i));
        }
        buttons.add(new InternalButton(InternalButtonSymbols.OPEN, -1));
        buttons.add(new InternalButton(InternalButtonSymbols.CLOSE, -1));
    }

    public void pressButton(int floorNumber){
        for(Button button: buttons){
            if(button instanceof InternalButton){
                if(((InternalButton) button).getFloorNumber() == floorNumber){
                    button.onPress();
                }
            }
        }
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public String getCarId() {
        return carId;
    }

    public String getCapacity() {
        return capacity;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public boolean isCalled() {
        return isCalled;
    }

    public void setCalled(boolean called) {
        isCalled = called;
    }
}
