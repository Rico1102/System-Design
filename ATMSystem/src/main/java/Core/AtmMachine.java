package Core;

import States.IdleState;
import States.Operations;
import States.State;
import WithdrawlSystem.CashWithdrawlHandler;
import WithdrawlSystem.FiveHundredDenominationHandler;
import WithdrawlSystem.OneHundredDenominationHandler;
import WithdrawlSystem.TwoHundredDenominationHandler;

import java.util.Map;

public class AtmMachine {

    private final CashWithdrawlHandler cashWithdrawlHandler;
    int availableBalance;
    private State currentState;
    private Card card;

    public AtmMachine() {
        currentState = new IdleState(this);
        cashWithdrawlHandler = new FiveHundredDenominationHandler(new TwoHundredDenominationHandler(new OneHundredDenominationHandler(null, 10), 10), 10);
        availableBalance = 5000 + 2000 + 1000;
    }

    public void insertCard(Card card) {
        currentState.insertCard(card);
    }

    public boolean authenticatePin(int pin) {
        return currentState.authenticatePin(pin);
    }

    public void checkBalance() {
        currentState.checkBalance();
    }

    public Map<String, Integer> withdrawCash(int amount) {
        return currentState.withdrawCash(amount);
    }

    public void chooseOperation(Operations operation) {
        currentState.chooseOperation(operation);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void setState(State state) {
        currentState = state;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public CashWithdrawlHandler getCashWithdrawlHandler() {
        return cashWithdrawlHandler;
    }

    public int getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(int availableBalance) {
        this.availableBalance = availableBalance;
    }
}
