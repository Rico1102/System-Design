package States;

import Core.AtmMachine;

public class HasCardState extends State{

    public HasCardState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public boolean authenticatePin(int pin) {
        System.out.println("Authenticating Pin");
        if(this.atmMachine.getCard().getPin() == pin) {
            System.out.println("Pin Authenticated");
            this.atmMachine.setState(new ChooseOperationState(atmMachine));
            return true;
        } else {
            System.out.println("Pin Authentication Failed");
            return false;
        }
    }

}
