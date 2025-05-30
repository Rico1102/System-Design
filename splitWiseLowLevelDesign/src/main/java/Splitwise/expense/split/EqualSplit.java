package Splitwise.expense.split;

import Splitwise.expense.Expense;

import java.util.List;

public class EqualSplit implements SplitStrategy{
    @Override
    public boolean validateSplit(Expense expense) {
        return false;
    }

    @Override
    public List<Split> splitExpense(Expense expense) {
        return null;
    }
}
