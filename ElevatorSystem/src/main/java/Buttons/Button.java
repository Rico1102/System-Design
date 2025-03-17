package Buttons;

public interface Button {

    public void onPress();

    public void addObserver(ButtonObserver observer);

    public Object getSymbol();

}
