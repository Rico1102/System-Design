package Buttons;

import java.util.ArrayList;
import java.util.List;

public class ExternalButton implements Button {

    List<ButtonObserver> observers;
    private ExternalButtonSymbols symbol;
    private boolean isPressed;
    private int floorNumber;

    public ExternalButton(ExternalButtonSymbols symbol, int floor) {
        this.symbol = symbol;
        this.floorNumber = floor;
        this.observers = new ArrayList<>();
    }

    public void onPress() {
        //TODO: implement logic to send the request to the elevator controller
        for (ButtonObserver observer : observers) {
            observer.onButtonPress(this);
        }
    }

    public void addObserver(ButtonObserver observer) {
        observers.add(observer);
    }

    public ExternalButtonSymbols getSymbol() {
        return symbol;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
