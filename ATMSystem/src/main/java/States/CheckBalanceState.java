package States;

import Core.AtmMachine;

public class CheckBalanceState extends State{

    public CheckBalanceState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void checkBalance() {
        System.out.println("Available Balance: " + this.atmMachine.getCard().getBalance());
    }

}
