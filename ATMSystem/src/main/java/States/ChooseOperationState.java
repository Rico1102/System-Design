package States;

import Core.AtmMachine;

public class ChooseOperationState extends State{

    public ChooseOperationState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void chooseOperation(Operations operation) {
        System.out.println("Choose Operation");
        if(operation == Operations.WITHDRAW) {
            System.out.println("Withdraw");
            atmMachine.setState(new WithdrawCashState(atmMachine));
        } else if(operation == Operations.CHECK_BALANCE) {
            System.out.println("Checking Balance");
            atmMachine.setState(new CheckBalanceState(atmMachine));
        } else {
            System.out.println("Invalid Operation");
        }
    }

}
