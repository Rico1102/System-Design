package Splitwise.balanceSheet;

import Splitwise.User;
import Splitwise.expense.Expense;

import java.util.List;
import java.util.Map;

public class GroupBalanceSheet extends BalanceSheet{

    List<User> users ;
    Map<User , Map<User , Double>> userBalanceMapping ;
    Map<User , List<Expense>> userExpenseMapping ;

    public GroupBalanceSheet(List<User> users){
        this.users = users ;
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
