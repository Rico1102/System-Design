package Splitwise.expense.split;

import Splitwise.expense.Expense;
import Splitwise.expense.split.Split;

import java.util.List;

public interface SplitStrategy {

    boolean validateSplit(Expense expense) ;
    List<Split> splitExpense(Expense expense) ;

}
