package Splitwise.balanceSheet;

import Splitwise.User;
import Splitwise.expense.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndividualBalanceSheet extends BalanceSheet{

    Map<User, List<Expense>> userExpenseMapping ;

    public IndividualBalanceSheet(){
        this.userExpenseMapping = new HashMap<>() ;
    }

    @Override
    public void addExpense() {

    }

    @Override
    public void updateExpense() {

    }

    @Override
    public void deleteExpense() {

    }

    @Override
    public void printUserBalanceSheet(User user) {

    }


}
