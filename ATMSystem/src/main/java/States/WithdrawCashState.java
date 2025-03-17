package States;

import Core.AtmMachine;

import java.util.Map;

public class WithdrawCashState extends State{

    public WithdrawCashState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public Map<String, Integer> withdrawCash(int amount) {
        //Check if machine has enough cash
        if(this.atmMachine.getAvailableBalance() < amount) {
            System.out.println("ATM Machine does not have enough cash");
            return null;
        }
        //Check if account has enough balance
        if(this.atmMachine.getCard().getBalance() < amount) {
            System.out.println("Insufficient Balance in Account !!!");
            return null;
        }
        //Withdraw Cash
        System.out.println("Withdrawing Cash: " + amount);
        try{
            Map<String, Integer> notes = this.atmMachine.getCashWithdrawlHandler().handleRequest(amount);
            this.atmMachine.setAvailableBalance(this.atmMachine.getAvailableBalance() - amount);
            this.atmMachine.getCard().setBalance(this.atmMachine.getCard().getBalance() - amount);
            return notes;
        } catch (Exception e) {
            System.out.println("Cash Withdrawl Failed due to technical issue");
            return null;
        }
    }

}
