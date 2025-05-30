package Splitwise.balanceSheet;

import Splitwise.User;
import Splitwise.expense.Expense;
import Splitwise.expense.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class BalanceSheet {

    Map<User, Double> balanceMap;

    public BalanceSheet(){
        balanceMap = new HashMap<>() ;
    }

    private void updateBalance(Split split){
        balanceMap.put(split.getPaidBy() , balanceMap.get(split.getPaidBy()) + split.getAmount()) ;
        balanceMap.put(split.getPaidFor() , balanceMap.get(split.getPaidBy()) - split.getAmount()) ;
    }

    abstract public void addExpense() ;

    abstract public void updateExpense() ;

    abstract public void deleteExpense() ;

    abstract public void printUserBalanceSheet(User user) ;

}
