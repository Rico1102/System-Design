package States;

import Core.AtmMachine;
import Core.Card;

public class IdleState extends State{

    public IdleState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted");
        this.atmMachine.setCard(card);
        this.atmMachine.setState(new HasCardState(atmMachine));
    }

    @Override
    public void ejectCard() {
        System.out.println("Action not allowed in this state");
    }

    @Override
    public void exit() {
        System.out.println("Action not allowed in this state");
    }

}
