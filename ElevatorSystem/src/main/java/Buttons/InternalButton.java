package Buttons;

import java.util.ArrayList;
import java.util.List;

public class InternalButton implements Button {

    private final InternalButtonSymbols symbol;
    private final int floorNumber;
    private final List<ButtonObserver> observers;

    public InternalButton(InternalButtonSymbols symbol, int floorNumber) {
        this.symbol = symbol;
        this.observers = new ArrayList<>();
        this.floorNumber = floorNumber;
    }

    public void addObserver(ButtonObserver observer) {
        this.observers.add(observer);
    }

    public InternalButtonSymbols getSymbol() {
        return symbol;
    }

    public int getFloorNumber() {
        return floorNumber;
    }


    public void onPress() {
        for (ButtonObserver observer : observers) {
            observer.onButtonPress(this);
        }
    }
}
