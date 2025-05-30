package Splitwise.expense;

import Splitwise.User;
import Splitwise.expense.split.Split;

import java.util.List;

public class IndividualExpense extends Expense{

    User paidFor ;
    Split split ;

    public IndividualExpense(String description, User payer, double amount, String strategy, User payee) {
        super(description, payer, amount, strategy);
        this.paidFor = payee ;
    }

    @Override
    public void validateAndGenerateSplit() {
        strategy.validateSplit(this) ;
        this.split = strategy.splitExpense(this).get(0) ;
    }

    @Override
    public void updateBalanceSheet() {
        //update payer balance sheet
        //update payee balance sheet
    }

    @Override
    public void printUserShare(User user) {

    }
}
