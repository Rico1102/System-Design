package Splitwise.expense;

import Splitwise.User;
import Splitwise.expense.split.SplitStrategy;

import java.util.ArrayList;
import java.util.List;

public class ExpenseController {

    List<Expense> expenses ;

    public ExpenseController(){
        this.expenses = new ArrayList<>() ;
    }

    public void createIndividualExpense(User paidBy, User paidFor, String strategy, double amount, String description){

    }

    public void createGroupExpense(User paidBy, List<User> involvedUsers, String strategy, double amount, String description){

    }
}
