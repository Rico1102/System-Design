import Core.Account;
import Core.AtmMachine;
import Core.Card;
import Core.User;
import States.Operations;

import java.util.Map;

public class AtmController {


    public static void main(String[] args) {
        Account account = new Account(123456, 5000);
        Card card = new Card(123, "1234 5678 9101 1121", "12/23", account);
        User user = new User(card);

        AtmMachine atmMachine = new AtmMachine();
        System.out.println("Atm Machine is in Idle State");

        System.out.println("Inserting Card");
        atmMachine.insertCard(card);

        if(atmMachine.authenticatePin(1234)){

            atmMachine.chooseOperation(Operations.WITHDRAW);

            System.out.println("Pin Authenticated");
            Map<String , Integer> notes = atmMachine.withdrawCash(2800);
            if(notes != null){
                System.out.println("Cash Withdrawn Successfully");
                System.out.println("Notes Dispensed: ");
                for(Map.Entry<String, Integer> entry : notes.entrySet()){
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
            }
            else{
                System.out.println("Cash Withdrawal Failed");
            }
            atmMachine.ejectCard();

        }
        else{
            System.out.println("Invalid Pin");
            System.out.println("Exiting");
            atmMachine.ejectCard();
        }

        System.out.println("Inserting Card");
        atmMachine.insertCard(card);

        if(atmMachine.authenticatePin(123)){
            atmMachine.ejectCard();
        }
        else{
            System.out.println("Invalid Pin");
            System.out.println("Exiting");
            atmMachine.ejectCard();
        }

        System.out.println("Inserting Card");
        atmMachine.insertCard(card);

        if(atmMachine.authenticatePin(1234)){
            atmMachine.chooseOperation(Operations.CHECK_BALANCE);
            atmMachine.checkBalance();
            atmMachine.ejectCard();
        }
        else{
            System.out.println("Invalid Pin");
            System.out.println("Exiting");
            atmMachine.ejectCard();
        }

        System.out.println("Inserting Card");
        atmMachine.insertCard(card);

        if(atmMachine.authenticatePin(1234)){

            atmMachine.chooseOperation(Operations.WITHDRAW);

            System.out.println("Pin Authenticated");
            Map<String , Integer> notes = atmMachine.withdrawCash(2800);
            if(notes != null){
                System.out.println("Cash Withdrawn Successfully");
            }
            else{
                System.out.println("Cash Withdrawal Failed");
            }
            atmMachine.ejectCard();

        }
        else{
            System.out.println("Invalid Pin");
            System.out.println("Exiting");
            atmMachine.ejectCard();
        }

    }

}
