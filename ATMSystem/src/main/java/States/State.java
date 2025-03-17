package States;

import Core.AtmMachine;
import Core.Card;

import java.util.Map;

public abstract class State {

    AtmMachine atmMachine;

    public State(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    public void insertCard(Card card) {
        System.out.println("Action not allowed in this state");
    }

    public boolean authenticatePin(int pin) {
        System.out.println("Action not allowed in this state");
        return false;
    }

    public void chooseOperation(Operations operation) {
        System.out.println("Action not allowed in this state");
    }

    public void checkBalance() {
        System.out.println("Action not allowed in this state");
    }

    public Map<String , Integer> withdrawCash(int amount) {
        System.out.println("Action not allowed in this state");
        return null;
    }

    public void ejectCard() {
        System.out.println("Card ejected, Please take your card");
        this.atmMachine.setCard(null);
        exit() ;
    }

    public void exit() {
        System.out.println("Exiting ATM System");
        System.out.println("Thank you for using our ATM System");
        System.out.println("--------------------------------------\n");
        atmMachine.setState(new IdleState(atmMachine));
    }

}
